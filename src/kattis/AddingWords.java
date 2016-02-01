package kattis;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddingWords {

	/**
	 * @author Hamza Raza
	 *
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> values = new HashMap<String, Integer>();
		
		loop:while (sc.hasNextLine()) {
			String[] split = sc.nextLine().split(" ");
			String command = split[0];
			boolean unknown = false;
			
			if (command.equalsIgnoreCase("def")) {
				String key = split[1];
				int value = Integer.parseInt(split[2]);

				values.put(key, value);
			} else if (command.equalsIgnoreCase("calc")) {
				int sum = 0;
				boolean add = true;

				for (int i = 1; i < split.length - 1; i++) {
					if (i % 2 == 0) {
						System.out.print(split[i] + " ");
						if (split[i].equalsIgnoreCase("+"))
							add = true;
						else if (split[i].equalsIgnoreCase("-"))
							add = false;
						continue;
					}
					System.out.print(split[i] + " ");
					if (values.containsKey(split[i])) {
						if (add)
							sum += values.get(split[i]);
						else
							sum -= values.get(split[i]);
					} else {
						unknown = true;
					}
				}
				
				if(unknown) {
					System.out.println("= unknown");
					continue loop;
				}

				if (values.containsValue(sum)) {
					String word = "";
					for(String value : values.keySet()) {
						if(values.get(value) == sum) {
							word = value;
						}
					}
					System.out.println("= " + word);
				} else {
					System.out.println("= unknown");
				}
			} else {
				values.clear();
			}
		}
		sc.close();
	}
}