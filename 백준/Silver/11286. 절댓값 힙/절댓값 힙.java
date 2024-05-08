import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Math.abs(o1) - Math.abs(o2));

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                pq.offer(num);
            } else {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                    continue;
                }
                if (pq.peek() <= 0) {
                    sb.append(pq.poll()).append("\n");
                    continue;
                }

                List<Integer> list = new ArrayList<>();
                int min = pq.peek();
                while (!pq.isEmpty() && Math.abs(pq.peek()) == min) {
                    list.add(pq.poll());
                }
                Collections.sort(list);
                sb.append(list.get(0)).append("\n");
                for (int j = 1; j < list.size(); j++) {
                    pq.offer(list.get(j));
                }
            }
        }

        System.out.print(sb);
        br.close();
    }
}