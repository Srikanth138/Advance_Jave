package logicalArray;

class A {

	static void m1(){
		int i,j,sum=0;
		Integer a[][]={{1,2,3},{4,5,6},{7,8,9}};
		for(i=0;i<a.length;i++){ 
			for(j=0;j<a[i].length;j++){
				if(i==j){
					sum=sum+a[i][j];
					System.out.print(a[i][j]+" ");
				}
			}
		}
		//a.length=3
		for(i=0;i<a.length;i++){	//->index 0 1 2
			for(j=0;j<a[i].length;j++){  	//1 2 3 =>a[0][2]
				if((i+j)==(a.length-1)){	//4 5 6 =>a[1][1]
					sum=sum+a[i][j];	 	//7 8 9 =>a[2][0]
					System.out.print(a[i][j]+" ");
					//System.out.println((i+j)+" "+(a.length-1));	
				}
			}
		}
		System.out.println("\n'Sum of diagonal :"+sum);
	}
}
public class DiagonalArray extends A{
		public static void main(String[] args) { 
			m1();	//extends class
	}
}
