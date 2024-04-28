import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { // 2024년 2월 28일

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 문제의 개수 1~1000
        int T = Integer.parseInt(st.nextToken()); // 남은 기한 1~1000

        int[][] dp = new int[N + 1][T + 1]; // i개의 문제가 있고, 남은 기한이 j일 때 아낄 수 있는 돈의 최대 양이 이 배열에 저장이 된다.

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()); // 걸리는 일수
            int m = Integer.parseInt(st.nextToken()); // 해당 문제의 벌금

            sum += m;

            for (int j = 1; j <= T; j++) {
                if (j >= d) {
                    dp[i][j] = Math.max(dp[i - 1][j - d] + m, dp[i - 1][j]); // 풀었을 때와 안 풀었을 때 뭐가 더 돈을 많이 아낄 수 있는지
                } else {
                    dp[i][j] = dp[i - 1][j]; // j일 내에 이번 문제를 풀 수 없으면 이전 문제까지 아낀 돈을 그대로 가져온다.
                }
            }


        }

        System.out.print(sum - dp[N][T]);

        br.close();
    } // main
} // class