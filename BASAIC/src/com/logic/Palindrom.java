package com.logic;

import java.util.Scanner;

//print the number also reveres same.
public class Palindrom {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number :");
		int num=sc.nextInt(); //525
		int rem=0,r=0,tem=num;
		while(num!=0){
			rem=num%10; //5 
			r=r*10+rem; //5
			num=num/10; //52
			sc.close();
		}
		if(tem==r)
			System.out.println(r+" is palimdrom");
		else
			System.out.println("not a palindrom : "+num);
	}

}
