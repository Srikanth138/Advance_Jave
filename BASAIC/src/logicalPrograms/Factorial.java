package logicalPrograms;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter A number..");
		int n=sc.nextInt();
		int a=1;
		for(int i=1;i<=n;i++) {
			a=a*i;
		}
		if(n!=0) {
			System.out.println(a);
		}
		else {
			System.out.println("Not a correct Number");
		}
		
		sc.close();

	}

}
