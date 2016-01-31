package ccc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Taller {

	/**
	 * @author Hamza Raza
	 *
	 */
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("C:\\Users\\Hamza\\Documents\\DATA.txt"));
			while (sc.hasNextInt()) {
				int N = sc.nextInt();
				int C = sc.nextInt();

				HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

				for (int i = 0; i < N + 1; i++) {
					map.put(i, new ArrayList<Integer>());
				}

				for (int i = 0; i < C; i++) {
					int p = sc.nextInt();
					int q = sc.nextInt();
					List<Integer> list = map.get(p);
					list.add(q);
					map.put(p, list);
				}

				int p = sc.nextInt();
				int q = sc.nextInt();

				if (isTaller(map, N, p, q))
					System.out.println("Yes");
				else if (isTaller(map, N, q, p))
					System.out.println("No");
				else
					System.out.println("Unknown");
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static boolean isTaller(HashMap<Integer, List<Integer>> map, int N, int p, int q) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];

		for (int i = 0; i < map.get(p).size(); i++)
			queue.add(map.get(p).get(i));

		while (!queue.isEmpty()) {
			int t = queue.poll();
			if (t == q)
				return true;
			if (!visited[t]) {
				visited[t] = true;
				for (int i = 0; i < map.get(t).size(); i++)
					queue.add(map.get(t).get(i));
			}
		}
		return false;
	}
}