package logicalPrograms;

import java.util.Scanner;

public class Reverse_Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a name: ");
		String n = sc.next();

		String name = ""; // main point
		for (int i = n.length() - 1; i >= 0.; i--) {
			name = name + n.charAt(i);
		}
		if (n.equals(name)) {
			System.out.println(name + " Palindrom");
		} else {
			System.out.println(name + " Is Not a palindram");
		}

//		Number 
		System.out.println("Enter a number: ");
		int n1 = sc.nextInt();
		int x = 0, y = 0, num = n1;

		for (int i = 0; i < n1; i++) {
			if (n1 != 0) {
				x = n1 % 10; // 523%10=3 =>52%10=2 =>5%10=5
				y = y * 10 + x; // 0*10+3=3 =>3*10+2=32 => 32*10+5=325
				n1 = n1 / 10; // 523/10=52 => 52/10=5 => 5/10=0
			}
		} // for

		if (num == y) {
			System.out.println(y + "is palindram Number");
		} else {
			System.out.println(y + "Is Not a palindram");
		}

		sc.close();

	}

}
