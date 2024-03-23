import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L; //(1 ≤ N ≤ M ≤ 1,000, 1 < L ≤ 4,000,000)
    static int[] cake;

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        cake = new int[M+1];

        for (int i = 0; i < M; i++) {
            cake[i] = Integer.parseInt(br.readLine());
        }

        cake[M] = L;

        for (int i = 0; i < N; i++) {
            int cut_target = Integer.parseInt(br.readLine());

            int mid = L / 2;
            int start = 0;
            int end = L;

            int answer = 0;

            while (start <= end) { // = 이 들어가는게 맞는지 확인하기
                mid = (end + start) / 2; // 조각의 최소 길이 : 이거보다 작게 자를 수는 없다

                int cnt = 0; // 잘라진 횟수
                int before = 0; // 이전 잘라진 포인트
                for (int j = 0; j <= M; j++) { // 케이크를 돌면서 자를 수 있는 부분을 cnt로 기록 0 10 20 30 40 ..50..?? 70
                    if (cake[j] - before >= mid) { // 만약 mid보다 같거나 크게 잘라지면 자른다.
                        cnt++;
                        before = cake[j]; // 이전 잘라진 포인트 변경
                    }
                }

                if (cnt > cut_target) {
                    start = mid + 1; // 너무 최소길이가 작다는 것이니까 수를 키워야함
                    answer = Math.max(answer,mid);
                } else {
                    end = mid - 1; // 너무 최소길이가 크다는 것이니까 수를 줄여야함
                }

            }
            sb.append(answer).append("\n"); // 헤헤ㅔㅣ
        }

        System.out.println(sb);

    }

}