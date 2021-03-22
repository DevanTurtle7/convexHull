import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 2));
        points.add(new Point(2, -3));
        points.add(new Point(5, 2));
        points.add(new Point(-1, 10));
        points.add(new Point(6, 3));

        Collections.sort(points, new PointComparator());

        for (Point p : points) {
            System.out.println(p);
        }
    }
}
