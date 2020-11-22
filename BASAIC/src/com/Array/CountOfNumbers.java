package com.Array;

public class CountOfNumbers {

	public static void main(String[] args) {
		int a[]={5946};
		int cnt=0; //count
		int ct=0; //count
		while(a[0]>0){
			a[0]=a[0]/10;
			cnt=cnt+1;
		}
		System.out.println("Array Length 1: "+cnt);
		
		
		int aa=987654321;
		while(aa!=0){
			aa=aa/10;
			ct++;
		}
		System.out.println("Array Length 2 : "+ct);
	}

}
