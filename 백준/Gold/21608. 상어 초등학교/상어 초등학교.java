import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int[][] like;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int student = N * N;
        board = new int[N][N]; // 자리 배정
        like = new int[N * N + 1][4]; // 원하는 사람 번호 저장

        for (int seq = 0; seq < student; seq++) {

            st = new StringTokenizer(br.readLine());
            int seq_num = Integer.parseInt(st.nextToken()); // 해당 친구

            for (int i = 0; i < 4; i++) { // 배열에 좋아하는 친구 숫자 저장
                like[seq_num][i] = Integer.parseInt(st.nextToken());
            }

            if (seq == 0) { // 제일 처음 한명 배치
                board[1][1] = seq_num;
                continue;
            }

            int r = 0; // 최종 자리
            int c = 0;

            //max를 항상 0으로 초기화해야함!!!
            int max_like = -1; // 좋아하는 친구 최대
            int max_empty = -1; // 비어있는 칸 최대

            for (int i = 0; i < N; i++) { // 전체 board를 돈다.
                for (int j = 0; j < N; j++) {

                    if (board[i][j] != 0) continue;

                    int cnt_like = 0; // 좋아하는 친구 세기
                    int cnt_empty = 0; // 비워져있는 칸 세기

                    // board를 돌면서 상하좌우가 빙
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                        if (board[nx][ny] == 0) cnt_empty++; // 비워져있는 칸 세기
                        else {
                            for (int l : like[seq_num]) { // 4명의 좋아하는 친구 돌기
                                if (board[nx][ny] == l) { // 4명의 좋아하는 친구랑 같으면
                                    cnt_like++;
                                }//
                            }
                        }
                    }
                    if (cnt_like > max_like) { // 만약 좋아하는 친구가 전보다 더 클 경우
                        max_like = cnt_like; // 바로 갱신해서 잊어버리지 말자!!!!!!
                        max_empty = cnt_empty;
                        r = i;
                        c = j;
                    } else if (cnt_like == max_like) { // 만약 좋아하는 친구가 같을 경우
                        if (cnt_empty > max_empty) { // 비어있는 칸이 클 경우
                            max_empty = cnt_empty;// 바로 갱신해서 잊어버리지 말자!!!!!!
                            r = i;
                            c = j;
                        }
                    } // 만약 둘다 같으면 어차피 앞에것이 행으로도 열로도 더 작으니 갱신만 안하면 된다.
                }
            }
            board[r][c] = seq_num;
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int like_cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                        continue;

                    for (int l : like[board[i][j]]) {
                        if (board[nx][ny] == l) like_cnt++;
                    }
                }
                answer += (int) Math.pow(10, like_cnt - 1);
            }
        }
        System.out.print(answer);
    }
}