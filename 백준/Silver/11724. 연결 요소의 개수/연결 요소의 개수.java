import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        board = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            board[u][v] = 1;
            board[v][u] = 1;
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;

            }
        }

        System.out.println(answer);
    }

    public static void dfs(int num) {
        visited[num] = true;
        for (int i = 1; i <= n; i++) {
            if (board[num][i] == 1 && !visited[i]) {
                dfs(i);
            }

        }
    }


}

