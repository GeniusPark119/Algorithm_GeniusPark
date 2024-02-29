import java.io.*;
import java.util.*;

public class Main {

    static Queue<Point> queue;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer;
    static int n, m;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        queue = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    queue.add(new Point(i, j, 0));
                }
            }
        }

        answer = bfs();

        if (check())
            System.out.println(answer);
        else
            System.out.println(-1);
    }

    public static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    public static int bfs() {

        int result = 0;

        while (!queue.isEmpty()) {

            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            int dep = point.dep;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.offer(new Point(nx, ny, dep + 1));
                }


            }
            result = Math.max(result, dep);
        }
        return result;
    }

    static class Point {
        int x;
        int y;
        int dep;

        public Point(int x, int y, int dep) {
            this.x = x;
            this.y = y;
            this.dep = dep;
        }
    }

}


