package ecoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrimeTime {

	/**
	 * @author Hamza Raza
	 *
	 */
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("C:\\DATA2.txt"));

			int numOfTerms = sc.nextInt();
			long[] terms = new long[numOfTerms];

			int key = 0;

			for (int i = 0; i < terms.length; i++)
				terms[i] = sc.nextLong();

			for (int i = 100000; i <= 500000; i++) {
				for (int k = 0; k < terms.length; k++) {
					if (terms[k] % i != 0)
						break;
					if (k == terms.length - 1)
						key = i;
				}
			}

			char[] values = { ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
					'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
					'V', 'W', 'X', 'Y', 'Z', '.', ',', '!', '?' };

			int[] charValues = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
					14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
					29, 30 };

			for (int i = 0; i < terms.length; i++) {
				StringBuilder keyValue = new StringBuilder().append(String
						.valueOf(terms[i] / key));

				if (keyValue.length() != 4)
					keyValue.insert(0, "0");

				for (int k = 0; k < keyValue.length(); k += 2) {
					int index = getIndex(Integer.parseInt(keyValue.substring(k,
							k + 2)), charValues);
					System.out.print(values[index]);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int getIndex(int value, int[] toSearch) {
		for (int i = 0; i < toSearch.length; i++) {
			if (toSearch[i] == value)
				return i;
		}
		return -1;
	}

	public static boolean isPrime(int number) {
		if (number <= 1)
			return false;
		else if (number == 2)
			return true;
		else if (number % 2 == 0)
			return false;

		int sRoot = (int) Math.sqrt(number);
		for (int i = 3; i <= sRoot; i += 2) {
			if (number % i == 0)
				return false;
		}
		return true;
	}
}