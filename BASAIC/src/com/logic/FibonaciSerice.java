package com.logic;
import java.util.Scanner;

public class FibonaciSerice {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number :");
		int num=sc.nextInt();
		int a=0,b=1;
		for(int i=1;i<=num;i++){
			int c=a+b;
			System.out.println(a);
			a=b;
			b=c;
			
		}
		sc.close();
	}

}
