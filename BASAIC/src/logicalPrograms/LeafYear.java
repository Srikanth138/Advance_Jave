package logicalPrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeafYear {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter a Year :: ");
		String num = br.readLine();
		int n = Integer.parseInt(num);

		if ((n % 4 == 0 || n % 100 == 0) || n % 400 == 0) {
			System.out.println(n + " leap year");
		} else {
			System.out.println(n + " Not a leaf year");
		}
	}

}
