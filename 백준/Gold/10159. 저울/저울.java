import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // N개의 수
        int M = Integer.parseInt(br.readLine()); // M개의 비교

        StringBuilder sb = new StringBuilder();

        int[][] board = new int[N + 1][N + 1];
        // 각 숫자 교차 지점에 더 큰 숫자 쓰기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());
            board[heavy][light] = heavy;
            board[light][heavy] = heavy;
        }

        for (int i = 1; i <= N; i++) {
            // i 를 기점으로 작아지는 구조
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[N + 1];
            visited[i] = true; // 본인 방문
            for (int j = 1; j <= N; j++) {
                if (board[i][j] == i) {
                    visited[j] = true;
                    queue.offer(j); // 직접적으로 연결되어있는 것 방문
                }
            }

            while (!queue.isEmpty()) {
                int object = queue.poll();
                for (int j = 1; j <= N; j++) {
                    if (board[object][j] == object && !visited[j]) {
                        visited[j] = true;
                        queue.offer(j);
                    }
                }
            }

            // i를 기점으로 커지는 구조
            for (int j = 1; j <= N; j++) {
                if (board[i][j] == j) {
                    visited[j] = true;
                    queue.offer(j); // 직접적으로 연결되어있는 것 방문
                }
            }

            while (!queue.isEmpty()) {
                int object = queue.poll();
                for (int j = 1; j <= N; j++) {
                    if (board[object][j] == j && !visited[j]) {
                        visited[j] = true;
                        queue.offer(j);
                    }
                }
            }
            int answer = 0;

            for (int j = 1; j <= N; j++) {
                if (!visited[j])
                    answer++;
            }
            sb.append(answer).append("\n");
        }


        System.out.print(sb);

        br.close();
    } // main
} // class