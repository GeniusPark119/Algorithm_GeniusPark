import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int M; // 행
    static int N; // 열 (반대로)

    static int[][] board, dp;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[M + 1][N + 1];
        dp = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // 다이나믹 프로그래밍 초기값을 -1로 해준다.
            }
        }

        System.out.println(dfs(1, 1));
    }

    static int dfs(int r, int c) {
        if (r == M && c == N) {
            // 도달했을때 나와주면된다.
            return 1;
        }
        if (dp[r][c] != -1) {
            //-1이 아닌 경우는 이미 방문했다는 뜻
            return dp[r][c];
        } else {
            // -1인 경우만 방문
            dp[r][c] = 0;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 1 || M < nr || nc < 1 || N < nc) {
                    continue;
                }

                if (board[r][c] > board[nr][nc]) // 현재값이 더 큰경우 ( 다음 값이 내리막길 )
                    dp[r][c] += dfs(nr, nc);

            }
        }

        return dp[r][c];

    }
}