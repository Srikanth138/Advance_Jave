package com.Array;

public class FindLogicMani {

	public static void main(String[] args) {
		int a=5678;
		int sum=0,rem;
		
		while(a!=0){
			rem=a%10; //8 ,7 ,6 ,5
			System.out.println("rem :"+rem);
			
			a=a/10; //5678 ,567 ,56 ,5
			System.out.println("divided :"+a);
			
			sum=sum+rem; //8+7+6+5		
			System.out.println("sum :"+sum);
		}
		System.out.println("total :"+sum);

	}

}
