package ecoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Smarties {

	/**
	 * @author Hamza Raza
	 *
	 */
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("C:\\DATA.txt"));
			String[] smarties = { "orange", "blue", "green", "yellow", "pink", "violet", "brown", "red" };

			while (sc.hasNextLine()) {
				List<String> list = new ArrayList<String>();
				String line;
				double time = 0;
				while (!(line = sc.nextLine()).equalsIgnoreCase("end of box")) {
					list.add(line);
				}
				for (String s : smarties) {
					if (s.equalsIgnoreCase("red")) {
						time += getCount(list, s) * 16;
						break;
					}
					time += Math.ceil(getCount(list, s) / 7.0) * 13;
				}
				System.out.println(time);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int getCount(List<String> list, String name) {
		int count = 0;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equalsIgnoreCase(name))
				count++;
		}
		return count;
	}
}
