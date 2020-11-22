package com.Array;

import java.util.Scanner;

public class Array3nd {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a[]=new int[5];
		for(int i=0;i<a.length;i++){
			System.out.println(i+" enter ur element ");
			a[i]=sc.nextInt();
			
		}
		sc.close();
		
		int sum=0;
		for(int i=0;i<a.length;i++){
			sum=sum+a[i];
		}
		System.out.println("the sum of"+sum);
		 
		//this static type
		short s[]={100,200,300,400}; //store in short datatype
		int add=0;
		for(int i=0;i<s.length;i++)
			add=add+s[i];
		System.out.println("add "+add);

	}

}
