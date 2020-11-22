package com.Array;

public class Array3Dim {

	public static void main(String[] args) {
		int i,j,index;
//		int a[][][]=new int[2][2][2]; //[index_size][row_size][Column_size]
//		try(Scanner sc=new Scanner(System.in)){
//		
//		System.out.println("enter the elements");
//		for(index=0;index<2;index++){
//			for (i=0;i<a.length;i++){
//				for(j=0;j<a.length;j++){
//					a[index][i][j]=sc.nextInt();
//				}
//			}
//		}
		int a[][][]={{{10,20},{30,40}},{{50,60},{70,80}}};
		System.out.println("ur matrix...");
		for(index=0;index<2;index++){ //size of index
			for (i=0;i<a.length;i++){ //row's
				for(j=0;j<a.length;j++){ //column's
					System.out.println(index+" "+i+" "+j+" "+a[index][i][j]+" "); //great logic
				}
				System.out.print("");
			}
			System.out.println("");
		}
	  //}//try
	}//main
}//class
