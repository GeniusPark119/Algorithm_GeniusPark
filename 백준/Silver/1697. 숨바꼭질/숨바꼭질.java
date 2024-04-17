import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        visited = new boolean[100001];

//        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int ans = bfs(n, k);
        System.out.println(ans);
    }

    static int bfs(int n, int k) {

        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(n, 0));
        visited[n] = true;

        while (!queue.isEmpty()) {

            Point p = queue.poll();
            int now = p.now;
            int dep = p.dep;
            if (now == k) return dep;

            if (now - 1 >= 0 && !visited[now - 1]) {
                queue.offer(new Point(now - 1, dep + 1));
                visited[now - 1] = true;
            }
            if (now + 1 <= 100000 && !visited[now + 1]) {
                visited[now + 1] = true;
                queue.offer(new Point(now + 1, dep + 1));
            }
            if (now * 2 <= 100000 && !visited[now * 2]) {
                visited[now * 2] = true;
                queue.offer(new Point(now * 2, dep + 1));
            }

        }

        return 0;


    }

    static class Point {
        int now;
        int dep;

        public Point(int now, int dep) {
            this.now = now;
            this.dep = dep;
        }
    }

}
