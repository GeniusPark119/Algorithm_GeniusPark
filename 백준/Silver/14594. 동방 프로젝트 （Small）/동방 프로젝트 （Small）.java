import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 동아리 방의 개수
        int M = Integer.parseInt(br.readLine()); // 빌런 행동 횟수
        boolean[] collapse = new boolean[N]; // 벽이 허물어졌는지 여부
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < y; j++) { // 모든 방을 첫 번째 방의 arr에 저장된 숫자로 바꾼다.
                collapse[j] = true;
            }
        }
        int answer = 1; // 방이 하나 있고 다음부터 벽이 있을 때 마다 추가함
        for (int i = 1; i < N; i++) {
            if (!collapse[i]) { // 벽이 있음
                answer++;
            }
        }
        System.out.print(answer);
    }
}
