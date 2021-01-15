package logicalPrograms;

public class FibonacciSeries {

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("Enter a Number..");
		int n = sc.nextInt();
		int a = 0, b = 1, c = 0;

		for (int i = 0; i <= n; i++) {
			System.out.print(a+" , ");
			c = a + b;
			a = b;
			b = c;
		}

		sc.close();

	}

}
