import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        long answer = 0; // 10만 * 10만 = 100억으로 int로는 안됩니다. double이 아니라 long입니당!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 적어도 1이 하나는 있어야한다.
        // 모든 수는 0~1 차이로만 이루어져 있어야 한다

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine())); // 오름차순으로 priorityQueue에 명예점수를 저장한다.
        }

        answer += pq.poll() - 1; // 맨 앞은 무조건 1로 만든다.
        int front = 1;

        while (!pq.isEmpty()) {
            int num = pq.poll();

            if (num - front <= 1) { // 다음 수와 이전수의 차이가 0~1 이라면 다음수를 이전수로 바꿔주고 다음으로 넘어간다.
                front = num;
                continue;
            }
            // 차이가 1 초과라면 1이 될 때까지 answer
            front++; // 다음 front는 1이 늘어나야하고
            answer += num - front; // 그 front를 만들기 위한 명예감수의 수를 구한다.
        }

        System.out.print(answer);
        br.close();
    } // main
} // class