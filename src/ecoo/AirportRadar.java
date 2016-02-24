package ecoo;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirportRadar {

	/**
	 * @author Hamza Raza
	 *
	 */
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("C:\\DATA3.txt"));

			while (sc.hasNextLine()) {
				int numOfTowers = 0;

				int angle = sc.nextInt();
				int distance = sc.nextInt();
				int numOfAirports = sc.nextInt();

				List<Point> points = new ArrayList<Point>(numOfAirports);
				List<Integer> ranges = new ArrayList<Integer>(numOfAirports);

				for (int i = 0; i < numOfAirports; i++) {
					points.add(new Point(sc.nextInt(), sc.nextInt()));
					ranges.add(sc.nextInt());
				}

				double angleRadians = Math.toRadians(angle);

				double x = distance * Math.cos(angleRadians);
				double y = distance * Math.sin(angleRadians);

				double incrementValue = distance / 100.0;
				double increment = 0;

				for (int i = 0; i < points.size(); i++) {
					while (increment <= distance) {
						x = increment * Math.cos(angleRadians);
						y = increment * Math.sin(angleRadians);

						double lineDistance = Math
								.sqrt(Math.pow(x - points.get(i).x, 2) + Math.pow(y - points.get(i).y, 2));
						if (lineDistance <= ranges.get(i)) {
							numOfTowers++;
							points.remove(i);
							ranges.remove(i);
							i--;
							break;
						}
						increment += incrementValue;
					}
					increment = 0;
				}
				System.out.format("The jet will appear on %d radar screens.%n", ++numOfTowers);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
