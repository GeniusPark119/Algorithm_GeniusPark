import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // N개의 수

        int[] arr = new int[n];
        int[][] board = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()); // 와인의 양을 저장
        }

        int zero = 0; // 이전 zero
        int one = 0; // 이전 one
        int max = 0; // 이전 max

        for (int i = 0; i < n; i++) {
            board[i][0] = max; // zero
            board[i][1] = zero + arr[i];// one
            board[i][2] = one + arr[i];// two

            zero = board[i][0]; // 이전 zero가 될 값
            one = board[i][1]; // 이전 one가 될 값
            max = Math.max(Math.max(board[i][0], board[i][1]), board[i][2]); // 이전 max가 될 값
        }

        int answer = max;
        System.out.print(answer);

        br.close();
    } // main
} // class