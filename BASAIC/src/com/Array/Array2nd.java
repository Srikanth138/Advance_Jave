package com.Array;

import java.util.Scanner;

public class Array2nd {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a[]=new int[5];
		for(int i=0;i<a.length;i++){
			System.out.println(i+" enter ur element ");
			a[i]=sc.nextInt();
			
		}
		sc.close();
		for(int i=0;i<a.length;i++)
		System.out.print("Array element "+a[i]+", index "+i+" ");
		
		
	}

}
