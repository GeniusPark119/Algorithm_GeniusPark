import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static char[][] board2;

    static boolean[][] visited;
    static boolean[][] visited2;

    static int n;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer, answer2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine()); // 가로

        board = new char[n][n];
        board2 = new char[n][n];
        visited = new boolean[n][n];
        visited2 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = str.charAt(j);
                if (c == 'G') {
                    board[i][j] = c;
                    board2[i][j] = 'R';
                    continue;
                }
                board[i][j] = c;
                board2[i][j] = c;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, board[i][j]);
                    answer++;
                }
                if (!visited2[i][j]) {
                    dfs2(i, j, board2[i][j]);
                    answer2++;
                }

            }
        }

        System.out.println(answer+" "+answer2);

    }

    public static void dfs(int x, int y, char c) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny] && board[nx][ny] == c) {
                visited[nx][ny] = true;
                dfs(nx, ny, c);
            }
        }

    }

    public static void dfs2(int x, int y, char c) {
        visited2[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited2[nx][ny] && board2[nx][ny] == c) {
                visited2[nx][ny] = true;
                dfs2(nx, ny, c);
            }
        }
    }


}


