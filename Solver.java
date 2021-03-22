import java.util.Collections;
import java.util.List;

public class Solver {

    private static double getAngle(Point from, Point to) {
        int xDiff = Math.abs(to.getX() - from.getX());
        int yDiff = Math.abs(to.getY() - from.getY());

        return 0.0;
    }

    public static void convexHull(List<Point> points, Point start) {
        Collections.sort(points, (Point p1, Point p2) -> {
            double a1 = getAngle(start, p1);
            double a2 = getAngle(start, p2);

            if (a1 < a2) {
                return -1;
            } else if (a1 == a2) {
                return 0;
            } else {
                return 1;
            }
        });
    }
}
