package kattis;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CoastLength {

	/**
	 * @author Hamza Raza
	 *
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] split = sc.nextLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		int[][] grid = new int[N][M];

		for (int i = 0; i < grid.length; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
			}
		}

		int count = 0;
		Point[] dir = { new Point(0, -1), new Point(0, 1), new Point(-1, 0), new Point(1, 0) };
		List<Point> edges = new ArrayList<Point>();
		for (int i = 0; i < N; i++) {
			edges.add(new Point(i, 0));
			edges.add(new Point(i, M - 1));
		}
		for (int i = 0; i < M; i++) {
			edges.add(new Point(0, i));
			edges.add(new Point(N - 1, i));
		}
		boolean[][] visited = new boolean[N][M];
		Queue<Point> queue = new LinkedList<Point>();

		for (Point point : edges) {
			if (grid[point.x][point.y] == 1) {
				count++;
				continue;
			}
			if (!visited[point.x][point.y]) {
				queue.add(point);
				visited[point.x][point.y] = true;
			}

			while (!queue.isEmpty()) {
				Point p = queue.poll();

				for (Point d : dir) {
					int x = p.x + d.x;
					int y = p.y + d.y;

					if (x < 0 || x >= N || y < 0 || y >= M)
						continue;

					if (grid[x][y] == 1) {
						count++;
						continue;
					}

					if (!visited[x][y]) {
						queue.add(new Point(x, y));
						visited[x][y] = true;
					}
				}
			}
		}
		System.out.println(count);
		sc.close();
	}
}