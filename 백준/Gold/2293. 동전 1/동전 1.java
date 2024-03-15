import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,k;
    static int[] coins;
    static int[] dp; // 다이나믹 프로그래밍으로 풀거임

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 코인 종류
        k = Integer.parseInt(st.nextToken()); // 얼마 만들어야하는지

        coins = new int[n];
        dp = new int[k+1]; // 1부터 k

        dp[0] = 1; // 0을 만드는 경우의 수는 1


        for(int i=0;i<n;i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0;i<n;i++){
            for(int j=1;j<=k;j++){ //합계 1~10 저장하는 dp
                if(j>=coins[i]){
                    dp[j] += dp[j-coins[i]]; // 동전크기를 뺀 가격에 저장 되어있는 경우의 수를 더한다
                    // 예를 들어 dp[5] = 3이고 dp[10] = 6 인 상태에서 동전5의 경우의 수를 더할때
                    // dp[10] 은 이미 있는 6에 dp[10원-5원]인 3 를 더해줘야한다.
                    // 이유 : dp[5]는 dp[10원-5원] 자리에 5원이 들어가는 경우의 수와 같다.
                }
            }
        }

        System.out.print(dp[k]);

    } // main 끝

}