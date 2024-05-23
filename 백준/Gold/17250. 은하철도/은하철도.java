import java.io.*;
import java.util.*;

public class Main { // 17250 은하철도

    static int[] rep;
    static long[] sum;

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 은하 개수
        int M = Integer.parseInt(st.nextToken()); // 철도 개수

        rep = new int[N + 1];
        sum = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            rep[i] = i; // 처음에 대표는 자기자신
            sum[i] = Integer.parseInt(br.readLine());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int A = findRep(a); // a의 대표를 데려와
            int B = findRep(b); // b의 대표를 데려와

            // 둘의 리더가 다르면 union
            if (A != B) union(A, B);

            sb.append(sum[findRep(A)]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static int findRep(int x) {
        if (x != rep[x])
            rep[x] = findRep(rep[x]);
        return rep[x];
    }

    public static void union(int A, int B) {
        if (A < B) {
            rep[B] = A;
            sum[A] += sum[B];
        } else {
            rep[A] = B;
            sum[B] += sum[A];
        }
    }
}