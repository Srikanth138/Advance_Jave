package com.logic;
//stong mean's 145=1+24+120=145
import java.util.Scanner;

public class Strong {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number :");
		int num=sc.nextInt();
		int tem=num;
		int sum=0;
		while(num!=0){
			int rem=num%10; //145
			int f=1;
			for(int i=1;i<=rem;i++){
				f=f*i;
			}
			System.out.println("the factorial is :"+f);
			sum=sum+f;
			num=num/10;
			
		}
		if(tem==sum)
		System.out.println("Strong is :"+sum);
		else
			System.out.println("not a Strong"+sum);
		sc.close();
	}

}
