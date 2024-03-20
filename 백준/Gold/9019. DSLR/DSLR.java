import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int A, B;
    static boolean[] visited;


    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            visited = new boolean[10000];
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            sb.append(bfs());
            sb.append("\n");
        }
        System.out.println(sb);

        br.close();

    }

    public static int D(int num) {
        return num * 2 > 9999 ? num * 2 % 10000 : num * 2;
    }

    public static int S(int num) {
        return num == 0 ? 9999 : num - 1;
    }

    public static int L(int num) {
        String str = String.valueOf(num);
        if (str.length() < 4) return Integer.parseInt(str) * 10;
        return Integer.parseInt(str.substring(1, 4) + (str.charAt(0)-'0'));

    }

    public static int R(int num) {
        String str = String.valueOf(num);
        return (str.charAt(str.length() - 1) - '0') * 1000 + num / 10;

    }

    public static String bfs() {
        Queue<Steps> queue = new LinkedList<>();

        queue.offer(new Steps(A, ""));
        visited[A] = true;

        while (!queue.isEmpty()) {
            Steps steps = queue.poll();
            int num = steps.num;
            String step = steps.step;

            if (num == B) return step;
            if (!visited[D(num)]) {
                queue.offer(new Steps(D(num), step + "D"));
                visited[D(num)] = true;

            }
            if (!visited[S(num)]) {
                queue.offer(new Steps(S(num), step + "S"));
                visited[S(num)] = true;

            }
            if (!visited[L(num)]) {
                queue.offer(new Steps(L(num), step + "L"));
                visited[L(num)] = true;

            }
            if (!visited[R(num)]) {
                queue.offer(new Steps(R(num), step + "R"));
                visited[R(num)] = true;

            }
        }


        return "No";

    }

    public static class Steps {
        int num;
        String step;

        Steps(int num, String step) {
            this.num = num;
            this.step = step;
        }
    }
}
