import java.io.*;
import java.util.*;

public class Main { // 4485 녹색 옷 입은 애가 젤다지?

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; true; tc++) { // tc가 언제끝날지 모르니 true 조건을 건다

            int N = Integer.parseInt(br.readLine());

            if (N == 0) break; // 0 이면 입력 끝!

            int[][] board = new int[N][N];

            for (int i = 0; i < N; i++) { // 동굴 맵
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 다익스트라는 우선순위큐
            Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
            int[][] min = new int[N][N];
            final int MAX = N * N * 9 + 1;

            for (int[] m : min) { // 최대값 초기화
                Arrays.fill(m, MAX);
            }

            queue.offer(new int[]{0, 0, min[0][0] = board[0][0]});
            // 출발지점은 해당 지점의 k를 저장하고 queue에 넣는다.


            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int currR = curr[0];
                int currC = curr[1];
                int currK = curr[2];

                //if (min[currR][currC] < currK) continue;

                for (int i = 0; i < 4; i++) { // 상하좌우 탐색
                    int nr = currR + dr[i];
                    int nc = currC + dc[i];

                    if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                        int nk = currK + board[nr][nc];
                        if (nk < min[nr][nc]) { // nk가 최소값보다 작을 때에만 최소값 갱신하고 pq에 넣어준다
                            min[nr][nc] = nk;
                            queue.offer(new int[]{nr, nc, nk});
                        }

                    }

                }
            }

            sb.append("Problem ").append(tc).append(": ").append(min[N - 1][N - 1]).append("\n");
        }
        System.out.print(sb);


        br.close();
    } // main
} // class