import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static char board[][] = new char[5][9]; // 전체 board
    static boolean visited[] = new boolean[13]; // A(0) ~ L(12) 이 있는지 확인
    static List<int[]> list = new ArrayList<>(); // 알파벳으로 채워야할 곳을 담아두는 리스트 { i, j }

    static boolean end = false; // 처음으로 사전순에 먼저나오는게 출력됐으면 true로 바꾼다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'x') { // x 인 부분은 새로 글자가 들어가야하니 list에 추가해준다.
                    list.add(new int[]{i, j});
                } else if (board[i][j] != '.') { // .인부분이 아니라면 글자인 부분이니 visited에 있다는 표시를 해준다.
                    visited[board[i][j] - 'A'] = true;
                }
            }
        }
        backTracking(0); // list에 있는 글자가 필요한 맨처음 지점부터 시작
        br.close();
    } // main

    private static void backTracking(int idx) { // 백트래킹

        if (end) return; // 만약 이미 출력된게 있으면 끝냄

        if (idx == list.size()) { // idx가 list를 다 돌았다면
            if (check()) { // 각 6개의 줄의합이 26인지 확인
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.print(board[i][j] + "");
                    }
                    System.out.println();
                }
                end = true; // 이미 출력 완료 표시
            } else {
                return; // 아니면 그냥 return
            }
        }

        for (int i = 0; i < 12; i++) {
            if (!visited[i]) { // 아직 없는 알파벳

                int[] arr = list.get(idx); // 다음 필요한 idx를 빼준다.

                board[arr[0]][arr[1]] = (char) ('A' + i); // 해당 부분 board에 다음 글자 넣어준다.
                visited[i] = true; // 해당 글자 true

                backTracking(idx + 1); // 백트래킹 ( 전후로 글자바꾸기, visited 처리하기 신경쓰기)

                board[arr[0]][arr[1]] = '.'; // 해당글자 다시 .
                visited[i] = false; // 해당 글자 다시 false
            }
        }
    }

    public static boolean check() { // 6줄의 합이 모두 26이 나오는지 확인
        int sum1 = (board[0][4] - 'A' + 1) + (board[1][3] - 'A' + 1) + (board[2][2] - 'A' + 1) + (board[3][1] - 'A' + 1);
        int sum2 = (board[1][1] - 'A' + 1) + (board[1][3] - 'A' + 1) + (board[1][5] - 'A' + 1) + (board[1][7] - 'A' + 1);
        int sum3 = (board[0][4] - 'A' + 1) + (board[1][5] - 'A' + 1) + (board[2][6] - 'A' + 1) + (board[3][7] - 'A' + 1);
        int sum4 = (board[3][1] - 'A' + 1) + (board[3][3] - 'A' + 1) + (board[3][5] - 'A' + 1) + (board[3][7] - 'A' + 1);
        int sum5 = (board[1][1] - 'A' + 1) + (board[2][2] - 'A' + 1) + (board[3][3] - 'A' + 1) + (board[4][4] - 'A' + 1);
        int sum6 = (board[1][7] - 'A' + 1) + (board[2][6] - 'A' + 1) + (board[3][5] - 'A' + 1) + (board[4][4] - 'A' + 1);

        if (sum1 == 26 && sum2 == 26 && sum3 == 26 && sum4 == 26 && sum5 == 26 && sum6 == 26) {
            return true;
        }
        return false;

    }
} // class