import java.util.*;
import java.io.*;

public class Main { //20250217 n과 m(2)
    private static int N;
    private static int M;

    private static int[] arr;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 1~N까지의 자연수
        M = Integer.parseInt(st.nextToken()); // M개를 고른 수열
        arr = new int[M];
        bfs(0, 1);

        System.out.print(sb);
    }

    private static void bfs(int depth, int starter) {
        if (depth >= M) {
            for (int num : arr)
                sb.append(num + " ");
            sb.append("\n");
            return;
        }
        for (int i = starter; i <= N; i++) {
                arr[depth] = i;
                bfs(depth + 1, i + 1);
        }
    }
}