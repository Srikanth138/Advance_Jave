import java.util.Scanner;
class CGPA{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
float  x1,x2,x3,x4,x5,x6 = 0;
System.out.println("Enter the First sem Marks");
x1=sc.nextFloat();
if(x1>=4 && x1<=10){
	System.out.println(x1);
}
else 
	System.out.println("not allowed below 4 AND Above 10");

System.out.println("Enter the second sem Marks");
x2=sc.nextFloat();
if(x2>=4 && x2<=10){
	System.out.println(x2);
}
else 
	System.out.println("not allowed below 4 AND Above 10");

System.out.println("Enter the 3rd sem Marks");
x3=sc.nextFloat();
if(x3>=4 && x3<=10){
	System.out.println(x3);
}
else 
	System.out.println("not allowed below 4 AND Above 10");

System.out.println("Enter the 4th sem Marks");
x4=sc.nextFloat();
if(x4>=4 && x4<=10){
	System.out.println(x4);
}
else 
	System.out.println("not allowed below 4 AND Above 10");

System.out.println("Enter the 5th sem Marks");
x5=sc.nextFloat();
if(x5>=4 && x5<=10){
	System.out.println(x5);
}
else 
	System.out.println("not allowed below 4 AND Above 10");

System.out.println("Enter the 6th sem Marks");
x6=sc.nextFloat();
if(x6>=4 && x6<=10){
	
}
else
	System.out.println("not allowed below 4 AND Above 10");

float z=x1+x2+x3+x4+x5+x6;
float  z1=z/6;
System.out.println("ur result is"+z1);

sc.close();
}

}
