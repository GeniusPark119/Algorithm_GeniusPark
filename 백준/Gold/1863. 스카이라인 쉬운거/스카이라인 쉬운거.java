import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // N개의 수

        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1); // 우선순위큐에 높은 빌딩 순으로 저장한다.

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 첫번째 x 좌표는 필요없는 정보이다.
            int high = Integer.parseInt(st.nextToken());
            while (!pq.isEmpty() && pq.peek() > high) { // 전에 있는 빌딩 중에 이번 빌딩 보다 높은게 있다면 빌딩 추가
                pq.poll(); // 높은 빌딩은 추가 후 다 빼준다.
                answer++;
            }
            if (!pq.isEmpty() && pq.peek() == high) { // 만약 이번 빌딩과 같은 층이 있다면 추가 없이 다음 좌표를 확인
                continue;
            }
            pq.offer(high); // 빌딩 높이 추가

        }

        while(!pq.isEmpty() && pq.peek()!=0){ // 남아있는 빌딩 수를 더해준다. 0일 때는 단순히 땅이니 더하지 않음
            answer++;
            pq.poll();
        }

        System.out.print(answer);

        br.close();
    } // main
} // class