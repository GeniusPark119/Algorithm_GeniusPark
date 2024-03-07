import java.io.*;
import java.util.*;

public class Main {
    static int n, m, cheeze, count, time;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};


    public static void main(String[] args) throws IOException {
//        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        board = new int[n][m];

        cheeze = 0; // 치즈의 개수
        time = 0; // 시간초
        count = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1)
                    count++;
            }
        }
        while (count > 0) {
            visited = new boolean[n][m];
            cheeze = count;
            time++;
            bfs();
        }


        System.out.println(time);
        System.out.println(cheeze);
    }

    public static void bfs() {

        Queue<Point> queue = new LinkedList();

        visited[0][0] = true;
        queue.offer(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (board[nx][ny] == 1) {
                        board[nx][ny] = 0;
                        count--;
                    }else{
                        queue.offer(new Point(nx,ny));
                    }
                }
            }

        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


