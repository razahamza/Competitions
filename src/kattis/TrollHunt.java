package kattis;

import java.util.Scanner;

public class TrollHunt {

	/**
	 * @author Hamza Raza
	 *
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int bridges = sc.nextInt() - 1;
		int knights = sc.nextInt();
		int minGroup = sc.nextInt();

		double groups = knights / minGroup;
		System.out.println((int) Math.ceil(bridges / groups));
		sc.close();
	}
}
