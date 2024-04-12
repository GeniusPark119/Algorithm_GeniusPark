import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열

        int[] dr = {-1, 0, 1, 0}; // 북 동 남 서 -> 방향이 제시가되는 문제에서는 순서를 맞추는게 도움이 됩니다.
        int[] dc = {0, 1, 0, -1}; // 북 동 남 서

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()); // 청소기 위치
        int c = Integer.parseInt(st.nextToken()); // 청소기 위치
        int d = Integer.parseInt(st.nextToken()); // 청소기 방향

        int[][] board = new int[N][M]; // 청소할 구역

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        rotate:
        while (true) {
            if (board[r][c] == 0) {
                answer++;
                board[r][c] = 2; // 청소가 된 곳은 2로
            }

            boolean check = false;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || N <= nr || nc < 0 || M <= nc) {
                    continue;
                }
                if (board[nr][nc] == 0) {
                    check = true;
                    break;
                }
            }

            if (check) {
                int nd = d == 0 ? 3 : d - 1;
                while (true) {
                    int nr = r + dr[nd];
                    int nc = c + dc[nd];
                    if (nr < 0 || N <= nr || nc < 0 || M <= nc)
                        continue;
                    if (board[nr][nc] == 0) {
                        r = nr;
                        c = nc;
                        d = nd;
                        break;
                    } else
                        nd = nd == 0 ? 3 : nd - 1;
                }
            } else {
                int nd = d < 2 ? d + 2 : d - 2;
                int nr = r + dr[nd];
                int nc = c + dc[nd];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;
                if (board[nr][nc] == 1) {
                    break rotate;
                } else {
                    r = nr;
                    c = nc;
                }

            }
        }
        System.out.print(answer);
        br.close();
    }
}