package kattis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Goldbach {

	/**
	 * @author Hamza Raza
	 *
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tests = sc.nextInt();
		boolean[] isPrime = new boolean[32001];

		for (int i = 2; i < isPrime.length; i++)
			isPrime[i] = true;

		for (int i = 2; isPrime.length > i * i; i++) {
			if (isPrime[i]) {
				for (int j = i; isPrime.length > i * j; j++) {
					isPrime[i * j] = false;
				}
			}
		}

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				list.add(i);
			}
		}

		for (int a = 0; a < tests; a++) {
			List<String> reps = new ArrayList<String>();
			int number = sc.nextInt();
			int left = 0;
			int right = getIndex(list, number);

			while (left <= right) {
				int leftVal = list.get(left);
				int rightVal = list.get(right);
				if (leftVal + rightVal == number) {
					reps.add(leftVal + "+" + rightVal);
					left++;
				} else if (leftVal + rightVal < number) {
					left++;
				} else {
					right--;
				}
			}
			System.out.println(number + " has " + reps.size() + " representation(s)");
			for (int i = 0; i < reps.size(); i++) {
				System.out.println(reps.get(i));
			}
			if (a != tests - 1)
				System.out.println();
		}
		sc.close();
	}

	public static int getIndex(List<Integer> list, int value) {
		for (int i = 0; i < list.size(); i++) {
			if(i == list.size() - 1)
				return i;
			if (list.get(i) >= value)
				return i - 1;
		}
		return -1;
	}
}
