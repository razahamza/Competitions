package ecoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PowerCipher {

	/**
	 * @author Hamza Raza
	 *
	 */
	static int[] numValues = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
			25, 26, 27, 28, };

	static char[] charValues = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '*', '+', '%' };

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("C:\\data\\DATA.txt"));

			if (sc.hasNextLine()) {
				String code = sc.nextLine();
				String encoded = sc.nextLine();

				String codedLine = getCodedLine(encoded, code);
				char x = codedLine.charAt(codedLine.indexOf(code) + code.length());
				int xValue = getIndex(charValues, x);
				codedLine = codedLine.replaceFirst(code + x, "");

				int[] initialValues = convertToInt(codedLine.toCharArray());

				int[] powerValues = getPowerValues(initialValues.length, xValue);

				for (int i = 0; i < initialValues.length; i++) {
					System.out.print(initialValues[i] + " ");
				}
				System.out.println("");
				for (int i = 0; i < powerValues.length; i++) {
					System.out.print(powerValues[i] + " ");
				}
				sc.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int[] convertToInt(char[] values) {
		int[] ret = new int[values.length];

		for (int i = 0; i < values.length; i++) {
			int index = getIndex(charValues, values[i]);
			ret[i] = index;
		}
		return ret;
	}

	public static int[] getPowerValues(int length, int power) {
		int[] ret = new int[length];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = (int) (Math.pow(power, i + 1)) % 29;
		}
		return ret;
	}

	public static String getCodedLine(String line, String code) {
		char[] letters = line.toCharArray();

		for (int i = 0; i < 28; i++) {
			String newLine = new String(letters);
			System.out.println(newLine);
			if (newLine.contains(code)) {
				return newLine;
			}
			for (int j = 0; j < letters.length; j++) {
				int index = getIndex(charValues, letters[j]);
				letters[j] = charValues[index == 0 ? 28 : index - 1];
			}
		}
		return null;
	}

	public static int getIndex(char[] values, char c) {
		for (int i = 0; i < values.length; i++) {
			if (values[i] == c)
				return i;
		}
		return -1;
	}
}
