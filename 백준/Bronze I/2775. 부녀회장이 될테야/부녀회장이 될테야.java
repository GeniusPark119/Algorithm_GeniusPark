import java.util.Scanner;


//나이순 정렬

public class Main {

    static StringBuilder sb;
    static int[][] map;

    public static void main(String[] args) {

        sb = new StringBuilder();
        map = new int[15][15];

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            sb.append(dfs(k, n));
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static int dfs(int k, int n) {

        if(map[k][n]!=0) return map[k][n];

        if (k == 0) {
            return n;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += dfs(k - 1, i);
        }
        map[k][n] = sum;
        return sum;
    }

}
