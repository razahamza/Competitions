package ecoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordWrap {

	/**
	 * @author Hamza Raza
	 *
	 */
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("C:\\DATA.txt"));

			while(sc.hasNextLine()) {
				int width = Integer.parseInt(sc.nextLine());
				int temp = width;
				String line = sc.nextLine();
				String[] split = line.split(" ");

				for(int i = 0; i < split.length; i++) {
					if(width < split[i].length()) {
						if(temp != width) {
							System.out.println();
						}
						System.out.println(split[i].substring(0, width));
						split[i] = split[i].substring(width);
					}
					if(temp < split[i].length()) {
						System.out.println();
						temp = width;
					}
					if(temp >= split[i].length()) {
						System.out.print(split[i] + " ");
						temp -= (split[i].length() + 1);
					}
				}
				System.out.println("\n=====");
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
