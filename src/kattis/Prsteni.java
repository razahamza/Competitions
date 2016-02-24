package kattis;

import java.util.Scanner;

public class Prsteni {

	/**
	 * @author Hamza Raza
	 *
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int rings = sc.nextInt();
		int first = sc.nextInt();

		for (int i = 0; i < rings - 1; i++) {
			int next = sc.nextInt();
			int gcd = gcd(first, next);

			System.out.println(first / gcd + "/" + next / gcd);
		}
		sc.close();
	}

	public static int gcd(int x, int y) {
		return y == 0 ? x : gcd(y, x % y);
	}
}