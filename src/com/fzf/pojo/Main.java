package com.fzf.pojo;

import java.util.Scanner;

public class Main {
//计算奇数个数和偶数个数
	public boolean getOddEvenNumber(int inputnum) {
		boolean resultFlag=true;
		if(inputnum%2!=0) {
			resultFlag=false;
		}
		
		return resultFlag;
	}	
	
//计算素数和
	public  int getPrimeNum(int arg1,int arg2){
		int resultNum=0;
		int orderNum=0;	
		for(int start=2;start<10000;start++){
			boolean flag=false;
			boolean priFlag=true;
			if(start==2){
				
				orderNum++;
				flag=true;
			}
			if(start==3){
				orderNum++;
				flag=true;
			}			
			for(int match=2;match<=Math.sqrt(start);match++){				
				if(start%match==0){
					priFlag=false;	
					break;
				}
			}
			
			if((priFlag)&&((start!=2)&&(start!=3))){	
				orderNum++;	
				flag=true;			
			}
			if(priFlag){
				System.out.println(orderNum+"  "+start);
				
			}
			
				if(orderNum>=arg1&&orderNum<=arg2&&flag&&(priFlag)){
					
						resultNum=resultNum+start;
				}


			
		}
		
		return resultNum;
	}
	
//读数	
	String[] charStore={"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
	public String getReadNum(int inputNum){
			
		//此处可以使用 stringbuffer
		String result;
		String resultTmp="";
		int singleNum=0;
		int everyNum;
		if(inputNum<0){
			everyNum=-inputNum;
			result="fu";
			
		}else{
			everyNum=inputNum;
			result="";
		}		
		while(true){
			singleNum=everyNum%10;
			everyNum=everyNum/10;

			for(int i=0;i<charStore.length;i++){
					if(singleNum==i){
						if(resultTmp.equals("")){
							resultTmp=charStore[i];
						}else{
							resultTmp=resultTmp+" "+charStore[i];						
						}
						break;
					}
					
				}
			if(everyNum==0){				
				break;					
			}

		}
		String[] resultArr=resultTmp.split(" ");
		for(int arrindex=resultArr.length-1;arrindex>=0;arrindex--){
			if(result==""){
				result=resultArr[arrindex];
				
			}else{				
				result=result+" "+resultArr[arrindex];	
			}						
		}		
		return result;						
	}

//读数不用数组
	public String getReadNumNoArray(int inputnum){
		String result=" ";
		String resultstr=" ";		
		int chagenum=0;
		if(inputnum<0){
			resultstr="fu";
			inputnum=-inputnum;						
		}
		if(inputnum==0){			
			resultstr="ling";
			return resultstr;
		}else{
			while(inputnum!=0){
				int num=inputnum%10;
				chagenum=chagenum*10+num;
				inputnum=inputnum/10;						
			}
			while(chagenum!=0){
				int num=chagenum%10;
				chagenum=chagenum/10;
				switch(num){
					case 0:result="ling";break;
					case 1:result="yi";break;
					case 2:result="er";break;
					case 3:result="san";break;
					case 4:result="si";break;
					case 5:result="wu";break;
					case 6:result="liu";break;
					case 7:result="qi";break;
					case 8:result="ba";break;
					case 9:result="jiu";break;
				}
				if(resultstr==" "){
					resultstr=result;
				}else{				
					resultstr=resultstr+" "+result;				
				}
			}
		}
		return resultstr;
	}
	public static void  main(String[] args){
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		int inputnum = sc.nextInt();
		String result=main.getReadNumNoArray(inputnum);	
		System.out.println(result);
		String[] resultstr=null;
		mainold2(resultstr);
		
	}
	
	
	 static void mainold2(String[] args){
		Main main = new Main();
		String resultstr=main.getReadNum(-123);
		System.out.println(resultstr);
	}
	
	
	 static void mainold1(String[] args){
		Main num = new Main();
		Scanner sc = new Scanner(System.in);
		int i=0;
		int[] store = new int[2];
		while(i<2){
			store[i] = sc.nextInt();
			i++;
		}
		int n = store[0];
		int m = store[1];
		int resultNum = num.getPrimeNum(n, m);
		System.out.println(resultNum);
		
	}
	
	 static void mainold(String[] args) {
		Main num=new Main();
		int oddNum=0;  
		int evenNum=0;
		Scanner sc = new Scanner(System.in);		
		while(true) {			
			int input = sc.nextInt();
			System.out.println(input);
			if(input==-1) {
				break;				
			}
			
			boolean resultFlag=num.getOddEvenNumber(input);
			System.out.println(resultFlag);
			if(resultFlag) {
				evenNum++;
			}else {
				
				oddNum++;
			}	
		}
		System.out.println(oddNum+" "+evenNum);
	}
}
