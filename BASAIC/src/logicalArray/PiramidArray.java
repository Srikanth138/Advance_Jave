package logicalArray;

public class PiramidArray {

	public static void main(String[] args) {
		int i,j,sum=0;
		
		try{
			int a[][]={{1,2,3},{4,5,6},{7,8,9}};
		for(i=0;i<a.length;i++){				//1 2 3
			for(j=0;j<a[i].length;j++){			//4 5 6
				if(a[i][j]<=a[0][2]){			//7 8 9
					sum=sum+a[i][j];
					System.out.print(a[i][j]+" ");
				}
			}
		}
		
		for(i=1;i<a.length;i++){					//1 2 3 ->a[0][2]
			j=2; sum=sum+a[i][j];					//4 5 6 ->a[1][2]
			System.out.print(a[i][j]+" ");			//7 8 9 ->a[2][2]
			}									//a[2][0] a[2][1]
		
		for(i=a.length-1;i>1;i--){	
			for(j=a[i].length-2;j>=0;j--){
				sum=sum+a[i][j];
				System.out.print(a[i][j]+" ");
				//System.out.println(i+" "+j);
			}
		}
		
		for(i=1;i<a.length-1;i++){
			for(j=0;j<a[i].length-1;j++){
				sum=sum+a[i][j];
				System.out.print(a[i][j]+" ");
			}
		}
		System.out.println("\nsum of pirmidal Array :"+sum);
	 } //try   
		catch(Exception e){e.printStackTrace();};
   }
}
