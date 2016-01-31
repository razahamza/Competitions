package ecoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LetterFrequency {
	
	/**
	 * @author Hamza Raza
	 *
	 */
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("C:\\DATA3.txt"));
			while (sc.hasNextLine()) {
				String line = sc.nextLine().toLowerCase().replaceAll(
						"[^a-z]", "");

				Map<Character, Integer> values = new TreeMap<Character, Integer>();

				for (int i = 0; i < 26; i++) {
					int count = 0;
					for (int k = 0; k < line.length(); k++) {
						if ((char) (i + 'a') == line.charAt(k)) {
							count++;
						}
					}
					values.put((char) (i + 'a'), count);
				}

				int maxValue = 0;
				for (Map.Entry<Character, Integer> a : values.entrySet()) {
					if(a.getValue() > maxValue) {
						maxValue = a.getValue();
					}
				}

				StringBuilder sb = new StringBuilder();
				for (Map.Entry<Character, Integer> a : values.entrySet()) {
					char key = a.getKey();
					int value = a.getValue();

					if (value == maxValue) {
						sb.append(Character.toUpperCase(key) + " ");
					}
				}
				sb.append(" occurs " + maxValue + " times");
				System.out.println(sb);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
