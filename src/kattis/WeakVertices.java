package kattis;

import java.util.Scanner;

public class WeakVertices {

	/**
	 * @author Hamza Raza
	 *
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			int V = Integer.parseInt(sc.nextLine());
			if (V == -1)
				break;

			int[][] arr = new int[V][V];
			boolean[] vertices = new boolean[V];

			for (int i = 0; i < V; i++) {
				String split[] = sc.nextLine().split(" ");
				for (int j = 0; j < V; j++) {
					arr[i][j] = Integer.parseInt(split[j]);
				}
			}

			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					if (arr[i][j] == 1) {
						for (int k = 0; k < V; k++) {
							if (arr[k][j] == 1 && arr[k][i] == 1) {
								vertices[i] = true;
								vertices[j] = true;
								vertices[k] = true;
							}
						}
					}
				}
			}

			for (int i = 0; i < V; i++) {
				if (vertices[i] == false)
					System.out.print(i + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}