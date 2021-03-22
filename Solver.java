import java.util.Collections;
import java.util.List;

public class Solver {

    private static double getAngle(Point from, Point to) {
        int xDiff = Math.abs(to.getX() - from.getX());
        int yDiff = Math.abs(to.getY() - from.getY());

        if (xDiff == 0) {
            return 90.0;
        }

        double angle = Math.atan(yDiff / xDiff);
        angle = Math.toDegrees(angle);
        if (from.getX() > to.getX()) {
            angle = 180 - angle;
        }

        return angle;
    }

    public static void convexHull(List<Point> points, Point start) {
        points.remove(start);

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

        for (Point p : points) {
            System.out.println(p);
        }
    }
}
