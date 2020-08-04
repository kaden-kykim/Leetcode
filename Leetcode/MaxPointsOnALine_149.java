import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MaxPointsOnALine_149 {

    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int length = points.length;
        if (length == 1 || length == 2) return length;
        Map<Point, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < length; ++i) {
            int[] p1 = points[i];
            map.clear();
            int same = 0;
            boolean hasMax = false;
            for (int j = 0; j < length; ++j) {
                if (i == j) continue;
                int[] p2 = points[j];
                Point point;
                if (p1[0] == p2[0] && p1[1] == p2[1]) { ++same; continue; }
                if (p1[0] == p2[0]) {
                    point = new Point(Double.MAX_VALUE, p1[0]);
                } else if (p1[1] == p2[1]) {
                    point = new Point(0, p1[1]);
                } else {
                    double div = p1[0] - p2[0];
                    point = new Point((p1[1] - p2[1]) * 1000 / div, (p1[0] * p2[1] - p2[0] * p1[1]) / div);
                }
                int count = map.getOrDefault(point, 0) + 1;
                if (max <= count) {
                    max = count;
                    hasMax = true;
                }
                map.put(point, count);
            }
            if (hasMax) max += same;
            else max = Math.max(max, same);
        }
        return max + 1;
    }

    private static class Point {
        double x, y;
        public Point(double x, double y) { this.x = x; this.y = y; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Double.compare(point.x, x) == 0 &&
                    Double.compare(point.y, y) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
