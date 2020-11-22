package com.Array;

public class SingleArray {

	public static void main(String[] args) {
		int a[]=new int[4];
		a[0]=10; //Scanner sc=new Scanner(System.in); a[0]=sc.nextInt();
		a[1]=20; 
		a[2]=30;
		a[3]=40;
		for(int i=0;i<a.length;i++)
		System.out.print(a[i]+" ");
		
		System.out.println();
		System.out.println(a);
		
		
		int b[]={1,2,3,4,5};
		for(int i=0;i<b.length;i++)
		System.out.print(b[i]+" ");
		
		System.out.println();
		System.out.println(b);
	}
}
