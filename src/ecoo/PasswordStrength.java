package ecoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PasswordStrength {

	/**
	 * @author Hamza Raza
	 *
	 */
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("C:\\DATA2.txt"));

			while (sc.hasNextLine()) {
				String password = sc.nextLine();
				int points = 0;

				for (int i = 0; i < password.length(); i++)
					points += 4;
				
				points += getBasicPoints(password);
				points += (password.length() - getUpperCaseLetters(password)) * 2;
				points += (password.length() - getLowerCaseLetters(password)) * 2;
				points += 4 * getDigitCount(password);
				points += 6 * getSymbolCount(password);
				points += 2 * getMiddleDigitsAndSymbols(password);
				
				if (containsLettersOnly(password)) {
					points -= password.length();
				} else if (containsDigitsOnly(password)) {
					points -= password.length();
				}
				
				points -= 2 * getConsecUpperCaseLetters(password);
				points -= 2 * getConsecLowerCaseLetters(password);
				points -= 2 * getConsecDigits(password);
				points -= 3 * (getSequenceDigits(password) - 2);

				if (points < 0)
					points = 0;
				else if (points > 100)
					points = 100;

				if (points <= 20) {
					System.out.println("Very Weak (score = " + points + ")");
				} else if (points >= 21 && points <= 40) {
					System.out.println("Weak (score = " + points + ")");
				} else if (points >= 41 && points <= 60) {
					System.out.println("Good (score = " + points + ")");
				} else if (points >= 61 && points <= 80) {
					System.out.println("Strong (score = " + points + ")");
				} else if (points >= 81) {
					System.out.println("Very Strong (score = " + points + ")");
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int getBasicPoints(String line) {
		char[] letters = line.toCharArray();
		int points = 0;

		boolean lowerCase = false;
		boolean upperCase = false;
		boolean digit = false;
		boolean symbol = false;

		if (line.length() >= 8)
			points += 2;

		for (int i = 0; i < line.length(); i++) {
			if (Character.isUpperCase(letters[i]) && !upperCase) {
				points += 2;
				upperCase = true;
			} else if (Character.isLowerCase(letters[i]) && !lowerCase) {
				points += 2;
				lowerCase = true;
			} else if (Character.isDigit(letters[i]) && !digit) {
				points += 2;
				digit = true;
			} else if (!Character.isLetter(letters[i])
					&& !Character.isDigit(letters[i]) && !symbol) {
				points += 2;
				symbol = true;
			}
		}
		return points >= 8 ? points : 0;
	}

	public static int getUpperCaseLetters(String line) {
		char[] letters = line.toCharArray();
		int count = 0;

		for (int i = 0; i < line.length(); i++) {
			if (Character.isUpperCase(letters[i])) {
				count++;
			}
		}
		return count > 0 ? count : line.length();
	}

	public static int getLowerCaseLetters(String line) {
		char[] letters = line.toCharArray();
		int count = 0;

		for (int i = 0; i < line.length(); i++) {
			if (Character.isLowerCase(letters[i])) {
				count++;
			}
		}
		return count > 0 ? count : line.length();
	}

	public static int getDigitCount(String line) {
		char[] letters = line.toCharArray();
		int count = 0;

		for (int i = 0; i < line.length(); i++) {
			if (Character.isDigit(letters[i])) {
				count++;
			}
		}
		return count > 0 && count < line.length() ? count : 0;
	}

	public static int getSymbolCount(String line) {
		char[] letters = line.toCharArray();
		int count = 0;

		for (int i = 0; i < line.length(); i++) {
			if (!Character.isDigit(letters[i])
					&& !Character.isLetter(letters[i])) {
				count++;
			}
		}
		return count;
	}

	public static int getMiddleDigitsAndSymbols(String line) {
		char[] letters = line.toCharArray();
		int count = 0;

		for (int i = 1; i < line.length() - 1; i++) {
			if (!Character.isLetter(letters[i])) {
				count++;
			}
		}
		return count;
	}

	public static boolean containsLettersOnly(String line) {
		char[] letters = line.toCharArray();
		int count = 0;

		for (int i = 0; i < line.length(); i++) {
			if (Character.isLetter(letters[i])) {
				count++;
			}
		}
		return count == letters.length ? true : false;
	}

	public static boolean containsDigitsOnly(String line) {
		char[] letters = line.toCharArray();
		int count = 0;

		for (int i = 0; i < line.length(); i++) {
			if (Character.isDigit(letters[i])) {
				count++;
			}
		}
		return count == letters.length ? true : false;
	}

	public static int getConsecUpperCaseLetters(String line) {
		char[] letters = line.toCharArray();
		int count = 0;
		int amount = 0;

		for (int i = 0; i < line.length(); i++) {
			if (Character.isUpperCase(letters[i]))
				count++;
			if (count > 1 && !Character.isUpperCase(letters[i])
					|| (count > 1 && i == line.length() - 1)) {
				amount += count - 1;
				count = 0;
			}
		}
		return amount;
	}

	public static int getConsecLowerCaseLetters(String line) {
		char[] letters = line.toCharArray();
		int count = 0;
		int amount = 0;

		for (int i = 0; i < line.length(); i++) {
			if (Character.isLowerCase(letters[i]))
				count++;
			if (count > 1 && !Character.isLowerCase(letters[i])
					|| (count > 1 && i == line.length() - 1)) {
				amount += count - 1;
				count = 0;
			}
		}
		return amount;
	}

	public static int getConsecDigits(String line) {
		char[] letters = line.toCharArray();
		int count = 0;
		int amount = 0;

		for (int i = 0; i < line.length(); i++) {
			if (Character.isDigit(letters[i]))
				count++;
			if (count > 1 && !Character.isDigit(letters[i])
					|| (count > 1 && i == line.length() - 1)) {
				amount += count - 1;
				count = 0;
			}
		}
		return amount;
	}

	public static int getSequenceLetters(String line) {
		char[] letters = line.toCharArray();
		char temp = ' ';
		int count = 0;
		int largestCount = 0;

		for (int i = 0; i < line.length(); i++) {
			if (Character.isUpperCase(letters[i])) {
				if (count == 0 || (char) (temp + 1) == letters[i]) {
					count++;
				}
				temp = letters[i];
			}
			if (count > largestCount) {
				if (i == line.length() - 1) {
					if (count > 2) {
						if (count > largestCount)
							largestCount = count;
						count = 0;
					}
				} else if ((char) (temp + 1) != letters[i + 1]) {
					if (count > 2) {
						if (count > largestCount)
							largestCount = count;
						count = 0;
					}
				}
			}
		}
		for (int i = 0; i < line.length(); i++) {
			if (Character.isUpperCase(letters[i])) {
				if (count == 0 || (char) (temp - 1) == letters[i]) {
					count++;
				}
				temp = letters[i];
			}
			if (count > largestCount) {
				if (i == line.length() - 1) {
					if (count > 2) {
						if (count > largestCount)
							largestCount = count;
						count = 0;
					}
				} else if ((char) (temp - 1) != letters[i + 1]) {
					if (count > 2) {
						if (count > largestCount)
							largestCount = count;
						count = 0;
					}
				}
			}
		}

		for (int i = 0; i < line.length(); i++) {
			if (Character.isLowerCase(letters[i])) {
				if (count == 0 || (char) (temp + 1) == letters[i]) {
					count++;
				}
				temp = letters[i];
			}
			if (count > largestCount) {
				if (i == line.length() - 1) {
					if (count > 2) {
						if (count > largestCount)
							largestCount = count;
						count = 0;
					}
				} else if ((char) (temp + 1) != letters[i + 1]) {
					if (count > 2) {
						if (count > largestCount)
							largestCount = count;
						count = 0;
					}
				}
			}
		}
		for (int i = 0; i < line.length(); i++) {
			if (Character.isLowerCase(letters[i])) {
				if (count == 0 || (char) (temp - 1) == letters[i]) {
					count++;
				}
				temp = letters[i];
			}
			if (count > largestCount) {
				if (i == line.length() - 1) {
					if (count > 2) {
						if (count > largestCount)
							largestCount = count;
						count = 0;
					}
				} else if ((char) (temp - 1) != letters[i + 1]) {
					if (count > 2) {
						if (count > largestCount)
							largestCount = count;
						count = 0;
					}
				}
			}
		}
		return largestCount;
	}

	public static int getSequenceDigits(String line) {
		char[] letters = line.toCharArray();
		char temp = ' ';
		int count = 0;
		int largestCount = 0;

		for (int i = 0; i < line.length(); i++) {
			if (Character.isDigit(letters[i])) {
				if (count == 0
						|| Character.digit(temp, 10) + 1 == Character.digit(
								letters[i], 10)) {
					count++;
				}
				temp = letters[i];
			}
			if (count > largestCount) {
				if (i == line.length() - 1) {
					if (count > 2) {
						if (count > largestCount)
							largestCount = count;
						count = 0;
					}
				} else if (Character.digit(letters[i], 10) + 1 != Character
						.digit(letters[i + 1], 10)) {
					if (count > 2) {
						if (count > largestCount)
							largestCount = count;
						count = 0;
					}
				}
			}
		}
		for (int i = 0; i < line.length(); i++) {
			if (Character.isDigit(letters[i])) {
				if (count == 0
						|| Character.digit(temp, 10) - 1 == Character.digit(
								letters[i], 10)) {
					count++;
				}
				temp = letters[i];
			}
			if (count > largestCount) {
				if (i == line.length() - 1) {
					if (count > 2) {
						if (count > largestCount)
							largestCount = count;
						count = 0;
					}
				} else if (Character.digit(letters[i], 10) - 1 != Character
						.digit(letters[i + 1], 10)) {
					if (count > 2) {
						if (count > largestCount)
							largestCount = count;
						count = 0;
					}
				}
			}
		}
		return largestCount;
	}
}