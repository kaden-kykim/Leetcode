import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII_210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        int[] inDegree = new int[numCourses];
        List<Integer> order = new ArrayList<>();
        List<List<Integer>> adjacent = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) adjacent.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            adjacent.get(pre[1]).add(pre[0]);
            ++inDegree[pre[1]];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) if (inDegree[i] == 0) queue.offer(i);

        int visitedCount = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            order.add(cur);
            if (visited[cur]) return new int[0];
            visited[cur] = true;
            ++visitedCount;
            for (int adj : adjacent.get(cur)) {
                --inDegree[adj];
                if (inDegree[adj] == 0) queue.offer(adj);
            }
        }
        if (visitedCount == numCourses) {
            int[] result = new int[order.size()];
            for (int i = 0; i < order.size(); ++i) result[i] = order.get(i);
            return result;
        } else return new int[0];
    }

    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacent = new ArrayList<>();
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) adjacent.add(new ArrayList<>());
        for (int[] pre : prerequisites) adjacent.get(pre[0]).add(pre[1]);
        boolean[][] visited = new boolean[numCourses][2];
        for (int i = 0; i < numCourses; ++i) if (helper(order, adjacent, i, visited)) return new int[0];
        int[] result = new int[order.size()];
        for (int i = 0; i < order.size(); ++i) result[i] = order.get(i);
        return result;
    }

    private boolean helper(List<Integer> order, List<List<Integer>> adjacent, int cur, boolean[][] visited) {
        if (visited[cur][0]) return true;
        if (visited[cur][1]) return false;
        visited[cur][0] = true;
        for (int i : adjacent.get(cur)) if (helper(order, adjacent, i, visited)) return true;
        order.add(cur);
        visited[cur][0] = false;
        visited[cur][1] = true;
        return false;
    }

}
