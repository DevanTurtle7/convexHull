import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 2));
        points.add(new Point(-1, 2));
        points.add(new Point(4, 2));
        points.add(new Point(6, 3));
        points.add(new Point(2, -3));
        points.add(new Point(-1, -1));
        points.add(new Point(2, 0));
        points.add(new Point(3, 6));
        points.add(new Point(5, -1));

        Collections.sort(points, new PointComparator());

        Solver.convexHull(points, points.get(0));
    }
}
