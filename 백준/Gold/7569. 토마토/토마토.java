import java.io.*;
import java.util.*;

public class Main {
    static int[][][] board;
    static int m, n, h;
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<Point> queue;
    static int answer;

    public static void main(String[] args) throws IOException {
        queue = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken()); // 가로
        n = Integer.parseInt(st.nextToken()); // 세로
        h = Integer.parseInt(st.nextToken()); // 높이

        board = new int[h][n][m];

        for (int i = 0; i < h; i++) { // 높이
            for (int j = 0; j < n; j++) { // 세로
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) { // 가로
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k] == 1)
                        queue.offer(new Point(i, j, k, 0));
                }

            }
        }

        bfs();

        if (!check())
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    public static boolean check() {

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[i][j][k] == 0)
                        return false;
                }

            }
        }
        return true;
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x; //높이
            int y = point.y; //세로
            int z = point.z; //가로
            int dep = point.dep;

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i]; //높이
                int ny = y + dy[i]; //세로
                int nz = z + dz[i]; //가로

                if (0 <= nx && nx < h && 0 <= ny && ny < n
                        && 0 <= nz && nz < m && board[nx][ny][nz] == 0) {
                    board[nx][ny][nz] = 1;
                    queue.offer(new Point(nx, ny, nz, dep + 1));

                }
            }

            answer = Math.max(answer, dep);
        }
    }

    static class Point {
        int x; // 높이
        int y; // 세로
        int z; // 가로
        int dep;

        public Point(int x, int y, int z, int dep) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.dep = dep;
        }
    }

}


