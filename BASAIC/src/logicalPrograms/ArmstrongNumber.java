package logicalPrograms;

public class ArmstrongNumber {

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("Enter a Number..");
		int n = sc.nextInt();
		int a = n, sum = 0,num=0;

		for (int i = 0; i < n; i++) {
			if (n != 0) {
				num = n % 10;           //      10)407(40 -> 400=>7
				n = n / 10;
				sum = sum + num*num*num;
			} // if
			
			else {
				System.out.println("enter a correct number");
			}//else
			
		} // for
		if (a == sum) {
			System.out.println(sum + "is a Armstrong Number");
		} else {
			System.out.println(sum + "Is not a Armstrong Number");
		}

		sc.close();

	}

}
