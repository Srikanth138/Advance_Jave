package logicalPrograms;

import java.util.Scanner;

public class SwapNumberWithoutUsing3rdVariable {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);	
		System.out.println("Enter A 1st Number..");
		int a=sc.nextInt();
		
		System.out.println("Enter A 2nd Number..");
		int b=sc.nextInt();
		 
		a=a+b; //1+2=3
		b=a-b; //3-2=1
		a=a-b; //3-1=2
		System.out.println(a+" <->"+b);
		
		sc.close();		
	}

}
