import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 23 : 41 - 2 : 17

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] honey = new int[N + 1]; // 각 칸의 꿀의 양
        int[] cumulativeSum = new int[N + 1]; // 왼쪽에서부터 오른쪽까지 한칸씩 누적합

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) { // 꿀의 양을 배열 honey에 저장함과 동시에 누적합을 저장한다
            honey[i] = Integer.parseInt(st.nextToken());
            cumulativeSum[i] = cumulativeSum[i - 1] + honey[i];
        }
        int answer = 0;

        // 벌이 양끝에 있는 경우
        for (int i = 2; i < N; i++) {
            answer = Math.max(answer, cumulativeSum[N - 1] - honey[1] + honey[i]); // 양끝을 제외하고 합을 구한다음 꿀통의 위치 꿀 양 더한 것중의 최대값
        }
        // 벌집이 왼쪽끝에 있는 경우 벌 한마리는 무조건 오른쪽 끝에 있는게 최대값이다.
        for (int i = 2; i < N; i++) {
            answer = Math.max(answer, cumulativeSum[N - 1] - honey[i] + cumulativeSum[i - 1]);
        }
        // 벌집이 오른쪽 끝에 있는 경우 벌 한마리는 무조건 왼쪽 끝에 있는게 최대값이다.
        for (int i = 2; i < N; i++) {
            answer = Math.max(answer, cumulativeSum[N] * 2 - honey[1] - honey[i] - cumulativeSum[i]);
        }

        System.out.print(answer);

        br.close();
    } // main
} // class