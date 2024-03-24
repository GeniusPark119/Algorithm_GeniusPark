import java.io.*;
import java.util.*;

public class Main {

    static int M, N, K;
    static char[][] board;
    static int sumJOI[][][];

    static int cnt_J, cnt_O, cnt_I; // 정글,바다,얼음

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // N * M 이 아님 주의!
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        board = new char[M + 1][N + 1];
        sumJOI = new int[M + 1][N + 1][3]; // 000을 끼기 위해 1개줄 추가 + 3개에 JOI 순으로 저장

        for (int i = 1; i <= M; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                board[i][j] = str.charAt(j - 1);

                //JOI 수를 세야해
                if (board[i][j] == 'J') {
                    sumJOI[i][j][0]++;
                } else if (board[i][j] == 'O') {
                    sumJOI[i][j][1]++;
                } else {
                    sumJOI[i][j][2]++;
                }
                // 오른쪽 밑 박스 구하기 : board[i][j] + 윗박스,왼쪽박스 - 왼쪽 대각선 위 박스
                sumJOI[i][j][0] += sumJOI[i - 1][j][0] + sumJOI[i][j - 1][0] - sumJOI[i - 1][j - 1][0];
                sumJOI[i][j][1] += sumJOI[i - 1][j][1] + sumJOI[i][j - 1][1] - sumJOI[i - 1][j - 1][1];
                sumJOI[i][j][2] += sumJOI[i - 1][j][2] + sumJOI[i][j - 1][2] - sumJOI[i - 1][j - 1][2];
            }
        }

//        for (int i = 0; i <= M; i++) {
//            for (int j = 0; j <= N; j++) {
//                System.out.print(sumJOI[i][j][0] + " " + sumJOI[i][j][1] + " " + sumJOI[i][j][2] + "    /   ");
//            }
//            System.out.println();
//        }


        for (int i = 0; i < K; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            cnt_J = cnt_O = cnt_I = 0;

            counting(a, b, c, d);

            sb.append(cnt_J).append(" ").append(cnt_O).append(" ").append(cnt_I).append("\n");

        }

        System.out.println(sb);

    }

    public static void counting(int a, int b, int c, int d) {
        // 오른쪽 밑 박스 구하기 : board[i][j] - 윗박스,왼쪽박스 + 왼쪽 대각선 위 박스
        cnt_J = sumJOI[c][d][0] - sumJOI[a - 1][d][0] - sumJOI[c][b - 1][0] + sumJOI[a - 1][b - 1][0];
        cnt_O = sumJOI[c][d][1] - sumJOI[a - 1][d][1] - sumJOI[c][b - 1][1] + sumJOI[a - 1][b - 1][1];
        cnt_I = sumJOI[c][d][2] - sumJOI[a - 1][d][2] - sumJOI[c][b - 1][2] + sumJOI[a - 1][b - 1][2];
    }
}