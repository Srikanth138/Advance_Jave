package com.logic;
import java.util.Scanner;

public class StrongNumberRang {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number :");
		int limt=sc.nextInt();
		
		for(int n=1;n<=limt;n++){ //best example java is fast compiler
			int sum=0;
			int temp=n;
			while(n!=0){
				int rem=n%10;
				int fact=1;
				for(int i=1;i<=rem;i++){
					fact=fact*i;
				}
				sum=sum+fact;
				n=n/10;
			}
			if(temp==sum)
				System.out.println(temp+"is Strong");
		}
		sc.close();
	}

}
