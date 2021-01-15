//Ex. 6 = (1 + 2 + 3)

package logicalPrograms;

public class PerfectNumber {

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("Enter a Number..");
		int n = sc.nextInt();
		// Ex. 6 = (1 + 2 + 3)

		int a = 0;
		for (int i = 1; i <= n / 2; i++) {

			if (n != 0) {
//				a = a + i;
				a += i;
			}
		} // for

		if (a == n) {
			System.out.println(a + "is perfect ");
		} else {
			System.out.println(n + "is not a perfect");
		}
		sc.close();

	}

}
