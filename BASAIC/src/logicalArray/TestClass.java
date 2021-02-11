package logicalArray;

import java.util.*;

class TestClass {
	public static void main(String args[] ) throws Exception {
	
	        Scanner s = new Scanner(System.in);
	        //String name = s.nextLine(); 
	        int a[][]=new int[5][];
	        a[0]=new int[1];
	        a[1]=new int[1];
	        a[2]=new int[5];
	        a[3]=new int[1];
	        a[4]=new int[4];
	        System.out.println("enter number");
	        for(int i=0;i < a.length;i++){
	            for(int j=0 ;j< a[i].length;j++){
	               a[i][j] =s.nextInt();
	               // System.out.print(a[i][j]);

	            }
	        }

	        for(int i=0;i < a.length;i++){
	            for(int j=0 ;j< a[i].length;j++){
	              // a[i][j] =s.nextInt();
	                System.out.print(a[i][j]);

	            }
	           System.out.println(" ");
	        }               
	}}