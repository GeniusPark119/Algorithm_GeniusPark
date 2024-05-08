import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Math.abs(o1) - Math.abs(o2));
        //절대값 기준으로 오름차순 정렬

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) { // 숫자가 0이 아니면 pq 에 더해준다.
                pq.offer(num);
            } else { // 숫자가 0이면 절댓값이 가장작은 수를, 여러개면 음수값을 갖는 수를 빼주는 식
                if (pq.isEmpty()) { // 비어있으면 0 출력
                    sb.append(0).append("\n");
                    continue;
                }
                if (pq.peek() <= 0) { // 0 이하이면 그대로 출력
                    sb.append(pq.poll()).append("\n");
                    continue;
                }
                // 0 보다 크면 같은 절댓값을 가진 수들을 list에 모은다.
                List<Integer> list = new ArrayList<>();
                int min = pq.peek();
                while (!pq.isEmpty() && Math.abs(pq.peek()) == min) {
                    list.add(pq.poll());
                }
                //list 수들을 오름차순 정렬
                Collections.sort(list);
                sb.append(list.get(0)).append("\n"); // 가장 작은수 출력
                //list에 남아있는 수 다시 pq에 저장
                for (int j = 1; j < list.size(); j++) {
                    pq.offer(list.get(j));
                }
            }
        }

        System.out.print(sb);
        br.close();
    }
}
