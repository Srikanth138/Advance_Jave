package logicalPrograms;

public class PrimeNumber {

	public static void main(String[] args) {

		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("Enter a Number..");
		int n = sc.nextInt();

		boolean b = false;

		if (n == 0 || n == 1) {
			System.out.println("0 & 1 Is not a Correct Number");
		}

		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				b = true;
				break;
			}

		}
		if (b) {
			System.out.println(n + " is not a prime Number..");
		} else {
			System.out.println(n + " is a Prime Number..");
		}

		sc.close();
	}

}
