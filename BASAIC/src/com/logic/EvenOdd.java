package com.logic;
import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number :");
		int num=sc.nextInt();
		int e=0,o=0;
		while(num!=0){
			int rem=num%10;
			if(rem%2==0){
				e=e+rem;
				num=num/10;
			}
			else{
				o=o+rem;
			num=num/10;
			}
			
		}
		System.out.println("even:"+e);
		System.out.println("odd :"+o);
		sc.close();
	}

}
