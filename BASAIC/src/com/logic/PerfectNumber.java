package com.logic;
//PerfectNumber : 6/2=3 =>1+2+3=6
import java.util.Scanner;

public class PerfectNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number :");
		int num=sc.nextInt();
		
		for(int n=1;n<=num;n++){ //best example java is fast compiler
			int sum=0;
		for(int i=1;i<=n/2;i++){
			if(n%i==0)
				sum=sum+i;
		}
		if(sum==n)
			System.out.println("PerfectNumber"+n);
		
		
		}
		sc.close();
	}

}
