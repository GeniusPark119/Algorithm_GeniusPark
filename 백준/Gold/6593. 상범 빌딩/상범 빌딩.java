import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int l, r, c;
    static char[][][] board; // 층 세로 가로
    static boolean[][][] visited; // 방문처리

    static int[] dl = {0, 0, 0, 0, -1, 1};
    static int[] dr = {-1, 1, 0, 0, 0, 0}; // 북(위) 남(아래) 서(왼) 동(오) 상 하
    static int[] dc = {0, 0, -1, 1, 0, 0};

    static int startL, startR, startC, endL, endR, endC;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) break;

            board = new char[l][r][c];
            visited = new boolean[l][r][c];

            for (int i = 0; i < l; i++) { // 층
                for (int j = 0; j < r; j++) { // 세로
                    board[i][j] = br.readLine().toCharArray();
                    for (int k = 0; k < c; k++) {
                        if (board[i][j][k] == 'S') { // 시작지점
                            startL = i;
                            startR = j;
                            startC = k;
                        }
                        if (board[i][j][k] == 'E') { // 끝 지점
                            endL = i;
                            endR = j;
                            endC = k;
                        }
                    }
                }
                br.readLine();
            }

            int answer = bfs();

            if (answer == -1)
                System.out.println("Trapped!");
            else
                System.out.println("Escaped in " + answer + " minute(s).");

        }

    }

    public static int bfs() {

        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(startL, startR, startC, 0));
        visited[startL][startR][startC] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int pL = point.l;
            int pR = point.r;
            int pC = point.c;
            int dep = point.dep;


            for (int i = 0; i < 6; i++) {
                int nl = pL + dl[i];
                int nr = pR + dr[i];
                int nc = pC + dc[i];

                if (nl < 0 || nl >= l || nr < 0 || nr >= r || nc < 0 || nc >= c || visited[nl][nr][nc])
                    continue;

                if (nl == endL && nr == endR && nc == endC)
                    return dep + 1;

                if (board[nl][nr][nc] == '.') {
                    queue.offer(new Point(nl, nr, nc, dep + 1));
                    visited[nl][nr][nc] = true;

                }

            }


        }
        return -1;

    }

    static class Point {
        int l;
        int r;
        int c;
        int dep;

        Point(int l, int r, int c, int dep) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.dep = dep;
        }
    }

}
