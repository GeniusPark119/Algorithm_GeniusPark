
import java.io.*;
import java.util.*;

//이중분할?
public class Main {
    static Queue<Point> queue; // 번호가 담긴 좌표 class를 queue에 넣는다.
    static List<Point> list; // 좌표의 번호를 오름차순으로 정리
    static int n, k, s, x, y;
    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        queue = new LinkedList<>();
        list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // N*N
        k = Integer.parseInt(st.nextToken()); // 바이러스 번호 1~K

        board = new int[n + 1][n + 1]; // 바이러스 표
        visited = new boolean[n + 1][n + 1]; // 이미 바이러스가 있던 자리인지 체크

        for (int i = 1; i <= n; i++) { // 이차원 배열에 바이러스 표 저장
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > 0)
                    list.add(new Point(i, j, board[i][j], 0));
            }
        }

        Collections.sort(list, (a, b) -> a.num - b.num);
        

        for (Point p : list) {
            queue.offer(p);
        }

        st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken()); // s초 후에 x,y 좌표
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(board[x][y]);
    }

    public static void bfs() {

        while (!queue.isEmpty()) { // s초 동안

            Point point = queue.poll();

            int x = point.x;
            int y = point.y;
            int num = point.num;
            int dep = point.dep;

            if(dep==s) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (1 <= nx && nx <= n && 1 <= ny && ny <= n && board[nx][ny] == 0) {
                    board[nx][ny] = num;
                    queue.offer(new Point(nx,ny,num,dep+1));
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int num;

        int dep;

        public Point(int x, int y, int num, int dep) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dep = dep;
        }
    }

}


