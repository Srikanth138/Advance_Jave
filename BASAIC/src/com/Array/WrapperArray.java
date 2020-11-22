package com.Array;

import java.util.Scanner;

public class WrapperArray {

	public static void main(String[] args) {
		
		try(Scanner sc=new Scanner(System.in);){
			int i,j; 
			int c[]=new int[0];
			Integer b[]={1,2,3};
			b[0]=10; //Replaced
			for(i=0;i<b.length;i++)
			System.out.print(b[i]+" ");
			System.out.println(b.getClass()+" difference "+c.getClass());
			
			
			Integer a[][]=new Integer[3][3];
			System.out.println("enter the values");
			for(i=0;i<a.length;i++){
				for(j=0;j<a[i].length;j++){
					a[i][j]=sc.nextInt();
					System.out.print(a[i][j]+" ");
				}
				System.out.println("");
			}
			
			
		} //try
	} //main
} //class
