package com.Array;

public class SumOfArray {

	public static void main(String[] args) {
		int a[][]={{7,8},{3,4},{5,6}};
		int i,j,x=0,y=0;	// i->row & j->column
		for(i=0;i<a.length;i++){ // 3rows
			for(j=0;j<a[i].length;j++){    // a[i].length -> length of the row size defined columns
				x=x+a[i][j];
			System.out.print(a[i][j]+" ");
		}
		System.out.println(" ");
		}
		System.out.println("the sum of Array :"+x);
		
		//sum of jagged Array
		int b[][]={{0},{1,2},{3,2,4},{5,6,7,8},{6,7,8,9,1}};
		for(i=0;i<b.length;i++){  			//4rows
			for(j=0;j<b[i].length;j++){  //b[i].length
				if(i==2 && b[i].length==3){ // i==2-> mean's index of 2 -> 3row will check 
											// &->that row b[i].length==3 -> that row colums or b[2]==3 ->is columns check
				y=y+b[i][j];
				}
			System.out.print(b[i][j]+" ");
		}
		System.out.println(" ");
		}
		System.out.println("the sum of Array :"+y);
		System.out.println(" ");
		
		for(i=0;i<b.length;i++){  
			y=0;
			for(j=0;j<b[i].length;j++){ 
				if(i==2 && b[i].length==3 || i==3 && b[i].length==4){ 
				y=y+b[i][j];
				}//if
				System.out.println(y);
		}//i
			System.out.println("the sum of "+b[i].length+"row :"+y); //length display's start's with 1 & and index display's 0
		}//j
		System.out.println(" ");
		
		try{ //int b[][]={{0},{1,2},{3,2,4},{5,6,7,8},{6,7,8,9,1}};
		for(i=0;i<b.length;i++){  
			y=0;
			for(j=0;j<b[i].length;j++){ 
				if(j==0 && b[j].length==1){ 
				y=y+b[i][j];
				}//if
		}//i
			System.out.println("the "+b[j-1].length+"row column value:"+y); //length display's start's with 1 & and index display's 0
		}//j
		}catch(Exception e){e.printStackTrace();}
	}//main
}//class
