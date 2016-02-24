package kattis;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Peragrams {

	/**
	 * @author Hamza Raza
	 *
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] line = sc.nextLine().toCharArray();
		for(int i = 0 ; i < line.length; i++) {
			char c = line[i];
			int count = 0;
			if(map.containsKey(c))
				count = map.get(c);
			count++;
			map.put(c, count);
		}
		
		int count = 0;
		for(char key : map.keySet()) {
			if(map.get(key) % 2 == 0)
				continue;
			count++;
		}
		
		if(count > 1)
			System.out.println(count - 1);
		else
			System.out.println(0);
		sc.close();
	}
}
