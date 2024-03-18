import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int[][] board;
    static int n, l;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // n*n N (2 ≤ N ≤ 100)
        l = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (calRow(i)) answer++;
            if (calCol(i)) answer++;
        }

        System.out.println(answer);

        // 경사로를 설치할 수 없는 경우
        // 1. 계단 길이가 경사로를 설치할 길이보다 짧다.
        // 2. 경사로를 설치해야하는 위치에 이미 경사로가 설치되어있다.
        // 3. 경사로를 만들어야하는 길이 l만큼 계단이없고 높이가 달라진다.

        br.close();

    }

    static boolean calRow(int row) {
        boolean[] visited = new boolean[n]; // 경사면 설치 여부 판별

        for (int i = 0; i < n - 1; i++) {
            int diff = board[row][i] - board[row][i + 1];

            if (diff > 1 || diff < -1) return false; // 높이의 차이가 1을 넘어간다.
            else if (diff == -1) { // 다음 높이가 1 클때
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || visited[i - j]) return false; // 범위를 넘어가거나 이미 경사로가 있는 경우
                    if (board[row][i] != board[row][i - j]) return false; // 땅의 높이가 달라지는 경우
                    visited[i - j] = true; // 경사로를 설치했으니 방문 처리를 해준다.
                }

            } else if (diff == 1) {// 다음 높이가 1 작을 때
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || visited[i + j]) return false;// 범위를 넘어가거나 이미 경사로가 있는 경우
                    if (board[row][i] - 1 != board[row][i + j]) return false;// 땅의 높이가 달라지는 경우
                    visited[i + j] = true; // 경사로를 설치했으니 방문 처리를 해준다.
                }
            }
        }
        return true;
    }

    static boolean calCol(int col) {
        boolean[] visited = new boolean[n]; // 경사로 방문처리

        for (int i = 0; i < n - 1; i++) {
            int diff = board[i][col] - board[i + 1][col];

            if (diff > 1 || diff < -1) return false;

            if (diff == -1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || visited[i - j]) return false; // 범위를 넘어가거나 이미 경사로가 있는 경우
                    if (board[i][col] != board[i - j][col]) return false; // 땅의 높이가 달라지는 경우
                    visited[i - j] = true; // 경사로를 설치했으니 방문 처리를 해준다.
                }
            } else if (diff == 1) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || visited[i + j]) return false;// 범위를 넘어가거나 이미 경사로가 있는 경우
                    if (board[i][col] - 1 != board[i + j][col]) return false; // 땅의 높이가 달라지는 경우
                    visited[i + j] = true;// 경사로를 설치했으니 방문 처리를 해준다.
                }
            }
        }
        return true;
    }
}
