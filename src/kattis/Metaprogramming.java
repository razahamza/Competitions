package kattis;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Metaprogramming {

	/**
	 * @author Hamza Raza
	 *
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<String, Integer>();

		while (sc.hasNextLine()) {
			String[] split = sc.nextLine().split(" ");
			String command = split[0];

			if (command.equalsIgnoreCase("define")) {
				int value = Integer.parseInt(split[1]);
				String key = "";
				for (int i = 2; i < split.length; i++) {
					key += split[i] + " ";
				}
				map.put(key.trim(), value);
			} else if (command.equalsIgnoreCase("eval")) {
				int index = 0;
				String first = "";
				for (int i = 0; i < split.length; i++) {
					if (split[i].equalsIgnoreCase("eval"))
						continue;
					if (split[i].contains(">") || split[i].contains("<") || split[i].contains("=")) {
						index = i;
						break;
					}
					first += split[i] + " ";
				}
				String comparison = "";
				for (int i = 0; i < split.length; i++) {
					if (split[i].contains(">") || split[i].contains("<") || split[i].contains("="))
						comparison = split[i];
				}
				String second = "";
				for (int i = index + 1; i < split.length; i++) {
					second += split[i] + " ";
				}
				first = first.trim();
				second = second.trim();
				
				if (map.containsKey(first) && map.containsKey(second)) {
					switch (comparison) {
					case ">":
						if (map.get(first) > map.get(second))
							System.out.println("true");
						else
							System.out.println("false");
						break;
					case "<":
						if (map.get(first) < map.get(second))
							System.out.println("true");
						else
							System.out.println("false");
						break;
					case "=":
						if (map.get(first) == map.get(second))
							System.out.println("true");
						else
							System.out.println("false");
						break;
					}
				} else {
					System.out.println("undefined");
				}
			}
		}
		sc.close();
	}
}