package ccc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Planes {
	
	/**
	 * @author Hamza Raza
	 *
	 */
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("C:\\Users\\Hamza\\Documents\\DATA.txt"));
			while(sc.hasNextInt()) {
				int gates = sc.nextInt();
				int planes = sc.nextInt();
				
				int[] plane = new int[planes];
				
				for(int i = 0; i < planes; i++) {
					plane[i] = sc.nextInt();
				}
				
				boolean[] array = new boolean[gates];
				
				int count = 0;
				for(int i = 0; i < planes; i++) {
					int index = getFreeIndex(array, plane[i]);
					
					if(index == -1)
						break;
					count++;
					array[index] = true;
				}
				System.out.println(count);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static int getFreeIndex(boolean[] array, int max) {
		for(int i = array.length - 1; i >= 0; i--) {
			if(i + 1 > max)
				continue;
			if(array[i] == false)
				return i;
		}
		return -1;
	}
}