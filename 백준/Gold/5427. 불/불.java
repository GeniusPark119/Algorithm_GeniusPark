import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static int w, h;
    static int startR, startC;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
        StringTokenizer st;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            board = new int[h][w];

            Queue<int[]> queue = new ArrayDeque<>();

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    switch (line.charAt(j)) { // switch를 적을때 case 마다 break를 적고 시작한다!!!
                        case '#':
                            board[i][j] = -1;
                            break;
                        case '*':
                            queue.offer(new int[]{i, j, -2, 0}); // 불이라서 -2, 초기니까 0
                            board[i][j] = -2;
                            break;
                        case '@':
                            startR = i;
                            startC = j;
                            break;
//                        default: // 빈공간 '.'은 모두 일로온다
//                            break;
                    }
                }
            }
            queue.offer(new int[]{startR, startC, 0, 0}); // 사람이니까 0 , 초기니까 0
            int answer = -1;
            rotate:
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int currR = curr[0];
                int currC = curr[1];
                int currW = curr[2];  // who
                int currT = curr[3];  // turn or time

                for (int i = 0; i < 4; i++) {
                    int nr = currR + dr[i];
                    int nc = currC + dc[i];

                    if (nr < 0 || h <= nr || nc < 0 || w <= nc) {
                        if (currW == 0) {
                            answer = currT + 1;
                            break rotate;
                        }
                    } else {
                        if (board[nr][nc] == 0) {
                            board[nr][nc] = currW == -2 ? -2 : currT + 1;
                            queue.offer(new int[]{nr, nc, currW, currT + 1});
                        }
                    }
                }

            }
            sb.append(answer == -1 ? "IMPOSSIBLE" : answer).append("\n");
        }

        System.out.print(sb);
        br.close();

    }
}
