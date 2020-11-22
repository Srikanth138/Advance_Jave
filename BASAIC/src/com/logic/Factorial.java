package com.logic;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number :");
		int num=sc.nextInt();
		int sum=1;
		if(num!=0){

			for(int i=1;i<=num;i++){
				
				sum=sum*i;
			}

			
		}
		System.out.println(sum);
		sc.close();
	}

}
