import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacent = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) adjacent.add(new ArrayList<>());
        for (int[] pre : prerequisites) adjacent.get(pre[0]).add(pre[1]);
        boolean[][] visited = new boolean[numCourses][2];
        for (int i = 0; i < numCourses; ++i) if (helper(adjacent, i, visited)) return false;
        return true;
    }

    private boolean helper(List<List<Integer>> adjacent, int cur, boolean[][] visited) {
        if (visited[cur][0]) return true;
        if (visited[cur][1]) return false;
        visited[cur][0] = true;
        for (int i : adjacent.get(cur)) if (helper(adjacent, i, visited)) return true;
        visited[cur][0] = false;
        visited[cur][1] = true;
        return false;
    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjacent = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) adjacent.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            adjacent.get(pre[0]).add(pre[1]);
            ++inDegree[pre[1]];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) if (inDegree[i] == 0) queue.offer(i);

        int visitedCount = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visited[cur]) return false;
            visited[cur] = true;
            ++visitedCount;
            for (int adj : adjacent.get(cur)) {
                --inDegree[adj];
                if (inDegree[adj] == 0) queue.offer(adj);
            }
        }
        return visitedCount == numCourses;
    }

}
