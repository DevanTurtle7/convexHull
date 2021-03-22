import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter coordinates in the format <x> <y>");
        System.out.println("Press enter to solve the convex hull.");

        List<Point> points = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        while (input != "") {
            String[] tokens = input.split(" ");

            try {
                int x = Integer.parseInt(tokens[0]);
                int y = Integer.parseInt(tokens[1]);
                Point point = new Point(x, y);
                points.add(point);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, try again.");
            }

            input = scanner.nextLine();
        }

        scanner.close();

        Collections.sort(points, new PointComparator());
        List<Point> path = Solver.convexHull(points, points.get(0));

        for (Point point : path) {
            System.out.println(point);
        }
    }
}
