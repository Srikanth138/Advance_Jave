package com.Array;

public class Dobule {

	public static void main(String[] args) {
		int a[][]=new int[2][2];
		int i,j;
		a[0][0]=10; //Scanner sc=new Scanner(System.in); a[0][0]=sc.nextInt();
		a[0][1]=20;
		a[1][0]=30;
		a[1][1]=40;
		System.out.println("UR MATRIX:");
		for(i=0;i<2;i++){
			for(j=0;j<2;j++){
				System.out.print(a[i][j]+" ");
			}
		System.out.println(" ");
		}
		
		//SECOND MATRIX
		int b[][]={{1,2},{3,4}};
		
		System.out.println("UR MATRIX:"+b.length);
		for(i=0;i<2;i++){
			for(j=0;j<2;j++){
				System.out.print(b[i][j]+" ");
			}
		System.out.println(" ");
		}
		
//		MATRIX Addtion
		int c[][]=new int[2][2];
		System.out.println("MATRIX Addtion");
		for(i=0;i<a.length;i++){ 
			for(j=0;j<a[i].length;j++){
				c[i][j]=a[i][j]+b[i][j];
				System.out.print(c[i][j]+" ");
			}
		System.out.println(" ");
		}
		
//		Matric Multiplication
		int d[][]=new int[2][2];
		System.out.println("MATRIX Multiplication");
		int k;
		//reffer the notes are matrix in math compare both
		for(i=0;i<a.length;i++){  //index defined here    
			for(j=0;j<a[i].length;j++){  //index fined here
				d[i][j]=0; 				//one's it back into k to i,j it will be Zero 
				for(k=0;k<2;k++){
					/*	1 2 	5 6
						3 4 	7 8 */
					//This is the main logic
				d[i][j]+=a[i][k]*b[k][j]; //This is the main logic
				//i is row first matrix ->a //j is column 2nd matrix ->b //k is column on 1st matrix's & row on second matrix.
				}
		System.out.print(d[i][j]+" ");
		}
			System.out.println(" ");
		}
		
//		matrix devision
		int f[][]=new int[2][2];
		System.out.println("MATRIX devision");
		for(i=0;i<a.length;i++){
			
			for(j=0;j<b.length;j++){
				f[i][j]=a[i][j]/b[i][j];
				System.out.print(f[i][j]+" ");
			}
		System.out.println(" ");
		}
		
	}

}
