import java.util.Collections;
import java.util.List;
import java.util.Stack;

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

    private static boolean isClockwise(Point from, Point middle, Point to) {
        int x1 = from.getX();
        int x2 = middle.getX();
        int x3 = to.getX();
        int y1 = from.getY();
        int y2 = middle.getY();
        int y3 = to.getY();

        int crossProduct = ((x2 - x1) * (y3 - y1)) - ((y2 - y1) * (x3 - x1));

        return crossProduct > 0;
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

        Stack<Point> stack = new Stack<>();
        stack.add(start);
        stack.add(points.get(0));
        points.remove(0);

        for (Point point : points) {
            System.out.println(point);
            isClockwise(start, points.get(0), point);
        }
    }
}
