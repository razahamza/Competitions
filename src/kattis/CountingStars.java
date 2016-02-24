package kattis;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CountingStars {
	
	/**
	 * @author Hamza Raza
	 *
	 */
	static List<Point> visited = new ArrayList<Point>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int test = 1;
		while (sc.hasNextLine()) {
			String[] split = sc.nextLine().split(" ");
			int r = Integer.parseInt(split[0]);
			int c = Integer.parseInt(split[1]);

			char[][] grid = new char[r][c];

			for (int i = 0; i < grid.length; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < grid[i].length; j++) {
					grid[i][j] = line.charAt(j);
				}
			}
			int count = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					if (grid[i][j] == '-' && !visited.contains(new Point(i, j))) {
						bfs(grid, i, j);
						count++;
					}
				}
			}
			System.out.println("Case " + test + ": " + count);
			test++;
			visited.clear();
		}
		sc.close();
	}

	public static void bfs(char[][] grid, int x, int y) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x, y));

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if (!visited.contains(p)) {
				visited.add(p);
				if (p.x - 1 >= 0) {
					if (grid[p.x - 1][p.y] == '-') {
						queue.add(new Point(p.x - 1, p.y));
					}
				}
				if (p.x + 1 < grid.length) {
					if (grid[p.x + 1][p.y] == '-') {
						queue.add(new Point(p.x + 1, p.y));
					}
				}
				if (p.y - 1 >= 0) {
					if (grid[p.x][p.y - 1] == '-') {
						queue.add(new Point(p.x, p.y - 1));
					}
				}
				if (p.y + 1 < grid[0].length) {
					if (grid[p.x][p.y + 1] == '-') {
						queue.add(new Point(p.x, p.y + 1));
					}
				}
			}
		}
	}
}