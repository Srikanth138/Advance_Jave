package com.Array;

public class Three3Dim {

	public static void main(String[] args) {

//		int a[][]={{1,2,3},{4,5,6},{7,8,9}};
//		int b[][]={{1,2,3},{4,5,6},{7,8,9}};
		int c[][]=new int[3][3];
		int a[][]={{1,1,1},{2,2,2},{3,3,3}};  
		int b[][]={{1,1,1},{2,2,2},{3,3,3}};  
		int i,j,k;
		for(i=0;i<a.length;i++){
			for(j=0;j<a[i].length;j++){ //a[i]-> row length 
				System.out.print(a[i][j]+" ");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
		
		for(i=0;i<a.length;i++){ //row
			for(j=0;j<a[i].length;j++){ //row
				c[i][j]=0;
				for(k=0;k<3;k++){
					
					c[i][j]+=a[i][k]*b[k][j]; //this is the logic (+=)
					
				}
				System.out.print(c[i][j]+" ");
			}
			System.out.println(" ");
		}	
	}
}
