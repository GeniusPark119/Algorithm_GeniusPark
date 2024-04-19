import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    static int N, M; // r c
    static int answer = 65; // 답이 될 수 있는 최대값
    static List<int[]> list; // cctv 담음

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        list = new ArrayList<>(); // cctv 0번 : 1~5, 1번 : i , 2번 : j

        for (int i = 0; i < N; i++) { // board 입력값을 받고 list에 cctv 추가
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= board[i][j] && board[i][j] <= 5) {// cctv일때는 저장한다
                    list.add(new int[]{board[i][j], i, j});

                }
            }
        } // 입력 end
        findBlind(0, board); // dfs
        System.out.print(answer);
        br.close();
    } // main

    public static void findBlind(int cnt, int[][] board) {

        if (cnt == list.size()) {
            answer = Math.min(answer, getZeroCnt(board));
            return;
        }

        int num = list.get(cnt)[0];
        int x = list.get(cnt)[1];
        int y = list.get(cnt)[2];

        int[][] tmp;

        switch (num) {
            case 1:
                tmp = copyBoard(board); // 왼
                watchLeft(x, y, tmp);
                findBlind(cnt + 1, tmp);

                tmp = copyBoard(board); // 오
                watchRight(x, y, tmp);
                findBlind(cnt + 1, tmp);

                tmp = copyBoard(board); // 위
                watchUp(x, y, tmp);
                findBlind(cnt + 1, tmp);

                tmp = copyBoard(board); // 아래
                watchDown(x, y, tmp);
                findBlind(cnt + 1, tmp);

                break;


            case 2:
                tmp = copyBoard(board); // 위 아래
                watchUp(x, y, tmp);
                watchDown(x, y, tmp);
                findBlind(cnt + 1, tmp);

                tmp = copyBoard(board); // 좌우
                watchRight(x, y, tmp);
                watchLeft(x, y, tmp);
                findBlind(cnt + 1, tmp);

                break;
            case 3:
                tmp = copyBoard(board); // 위 오
                watchUp(x, y, tmp);
                watchRight(x, y, tmp);
                findBlind(cnt + 1, tmp);

                tmp = copyBoard(board); // 오 아래
                watchRight(x, y, tmp);
                watchDown(x, y, tmp);
                findBlind(cnt + 1, tmp);

                tmp = copyBoard(board); // 아래 왼
                watchLeft(x, y, tmp);
                watchDown(x, y, tmp);
                findBlind(cnt + 1, tmp);

                tmp = copyBoard(board); // 왼 위
                watchLeft(x, y, tmp);
                watchUp(x, y, tmp);
                findBlind(cnt + 1, tmp);

                break;
            case 4:
                tmp = copyBoard(board); // 위 왼 오 ( 아래 없음 )
                watchUp(x, y, tmp);
                watchLeft(x, y, tmp);
                watchRight(x, y, tmp);
                findBlind(cnt + 1, tmp);

                tmp = copyBoard(board); // 위 왼 아래 ( 오 없음 )
                watchLeft(x, y, tmp);
                watchUp(x, y, tmp);
                watchDown(x, y, tmp);
                findBlind(cnt + 1, tmp);

                tmp = copyBoard(board); // 오 왼 아래 ( 위 없음 )
                watchRight(x, y, tmp);
                watchLeft(x, y, tmp);
                watchDown(x, y, tmp);
                findBlind(cnt + 1, tmp);

                tmp = copyBoard(board); // 오 위 아래 ( 왼 없음 )
                watchRight(x, y, tmp);
                watchUp(x, y, tmp);
                watchDown(x, y, tmp);
                findBlind(cnt + 1, tmp);
                break;
            case 5:
                tmp = copyBoard(board); // 오 왼 위 아래
                watchRight(x, y, tmp);
                watchLeft(x, y, tmp);
                watchUp(x, y, tmp);
                watchDown(x, y, tmp);
                findBlind(cnt + 1, tmp);
                break;
        }

    }

    public static int getZeroCnt(int[][] board) { // 사각지대의 개수 구하기
        int zeroCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) zeroCnt++;
            }
        }
        return zeroCnt;
    }

    public static int[][] copyBoard(int[][] board) { // 말그래도 board를 복사해서 따로 만드는 것
        int[][] newB = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newB[i][j] = board[i][j];
            }
        }
        return newB;
    }

    public static void watchRight(int x, int y, int[][] board) { // 오른쪽 감시
        for (int j = y + 1; j < M; j++) {
            if (board[x][j] == 6) break;
            if (board[x][j] != 0) continue;
            board[x][j] = -1;
        }
    }

    public static void watchLeft(int x, int y, int[][] board) { // 왼쪽 감시
        for (int j = y - 1; j >= 0; j--) {
            if (board[x][j] == 6) break;
            if (board[x][j] != 0) continue;
            board[x][j] = -1;
        }
    }

    public static void watchUp(int x, int y, int[][] board) { // 위쪽 감시
        for (int i = x - 1; i >= 0; i--) {
            if (board[i][y] == 6) break;
            if (board[i][y] != 0) continue;
            board[i][y] = -1;
        }
    }

    public static void watchDown(int x, int y, int[][] board) { // 아래쪽 감시
        for (int i = x + 1; i < N; i++) {
            if (board[i][y] == 6) break;
            if (board[i][y] != 0) continue;
            board[i][y] = -1;

        }
    }


} // class