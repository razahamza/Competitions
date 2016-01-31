package kattis;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EightQueens {
	
	/**
	 * @author Hamza Raza
	 *
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		loop: while (sc.hasNextLine()) {
			char[][] grid = new char[8][8];
			List<Point> coords = new ArrayList<Point>();

			for (int i = 0; i < grid.length; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < grid[i].length; j++) {
					grid[j][i] = line.charAt(j);
					if (grid[j][i] == '*')
						coords.add(new Point(j, i));
				}
			}

			for (int i = 0; i < coords.size(); i++) {
				for (int j = 0; j < coords.size(); j++) {
					if (coords.get(i).equals(coords.get(j)))
						continue;
					int absX = (int) Math.abs(coords.get(i).getX() - coords.get(j).getX());
					int absY = (int) Math.abs(coords.get(i).getY() - coords.get(j).getY());

					if (absX == absY || absX == 0 || absY == 0) {
						System.out.print("invalid");
						continue loop;
					}
				}
			}
			System.out.print("valid");
		}
		sc.close();
	}
}