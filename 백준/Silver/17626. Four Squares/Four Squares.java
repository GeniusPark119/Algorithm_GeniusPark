import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) { // 한 수의 제곱수를 i에서 뺐을때 dp[i-j*j]가 최소인 경우에 1를 더한 값이 dp[i]가 된다.
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }

        System.out.print(dp[n]);


    }
}
