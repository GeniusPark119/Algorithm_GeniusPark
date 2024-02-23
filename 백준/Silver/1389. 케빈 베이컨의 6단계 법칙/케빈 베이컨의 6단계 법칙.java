import java.io.*;
import java.util.*;

public class Main {
    static Set<Integer> set;
    static StringBuilder sb;
    static boolean[][] board;
    static boolean[][] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {

        set = new HashSet<>();
        sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 사람수
        m = Integer.parseInt(st.nextToken()); // 관계

        board = new boolean[n + 1][n + 1];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = true;
            board[y][x] = true;
        }
//        for(boolean[] x : board)
//            System.out.println(Arrays.toString(x));

        int ansSum = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    continue;
                sum += bfs(i, j);
            }
            if(ansSum>sum){
                ansSum = sum;
                ans = i;
            }

        }
        System.out.println(ans);
    }

    static int bfs(int from, int to) {

        Queue<Rela> queue = new LinkedList<>();
        visited = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            if (from == i)
                continue;
            if (board[from][i]){
                queue.offer(new Rela(from, i, 1));
            }
        }

        int result = 0;

        while (!queue.isEmpty()) {
            Rela rela = queue.poll();
            if (rela.y==to) {
                result = rela.dep;
                break;

            }

            for (int i = 1; i <= n; i++) {
                if (board[rela.y][i] && !visited[rela.y][i]) {
                    queue.offer(new Rela(rela.y,i,rela.dep+1));
                    visited[rela.y][i] = true;
                    visited[i][rela.y] = true;
                }

            }
        }

        return result;
    }

    static class Rela {
        int x;
        int y;
        int dep;

        public Rela(int x, int y, int dep) {
            this.x = x;
            this.y = y;
            this.dep = dep;
        }
    }
}
