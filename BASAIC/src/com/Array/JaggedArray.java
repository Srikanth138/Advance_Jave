package com.Array;

import java.util.Scanner;

public class JaggedArray {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);){
		int a[][]=new int[3][];
		a[0]=new int[] {1,2}; //first row
		a[1]=new int[]{3,2,1};
		a[2]=new int[2];
		int i,j;
		for(i=0;i<a.length;i++){ 
			for(j=0;j<a[i].length;j++){ 
				System.out.print(a[i][j]+" ");
			}
			System.out.println(" ");
		}
		
		System.out.println("enter the number's");
		for(i=0;i<a.length;i++){ 
			for(j=0;j<a[i].length;j++){ 
				a[i][j]=sc.nextInt();
			}
			System.out.println(" ");
		}
		
		for(i=0;i<a.length;i++){ 
			for(j=0;j<a[i].length;j++){ 
				System.out.print(a[i][j]+" ");
			}
			System.out.println(" ");
		}
	  }//try closed
		
		
	}

}
