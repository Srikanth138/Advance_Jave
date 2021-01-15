package logicalPrograms;

import java.util.Scanner;

public class EvenAndOdd {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number ..");
		int num = sc.nextInt();

//		if (num % 2 == 0) {
//			System.out.println(num + "is even number");
//		} else {
//			System.out.println(num + "is odd Number");
//		}

		int i = 1;
		for (; i <= num;) {
			if (i % 2 == 0)
				System.out.println(i + "is even number's");
			else {
				System.out.println(i + "is Odd Number's");
			}
			i++;
		}

		sc.close();

	}

}
