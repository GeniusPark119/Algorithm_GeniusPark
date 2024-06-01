import java.io.*;
import java.util.*;

public class Main { // 22252 정보 상인 호석

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int Q = Integer.parseInt(br.readLine());


        Map<String, Queue<Integer>> map = new HashMap<>(); // name - PriorityQueue

        long ans = 0; // 가치의 총합, 100억까지 갈 수 있기 때문에 long

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int kind = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            int cnt = Integer.parseInt(st.nextToken()); // kind 1일때는 추가되는 정보의 개수 , kind 2일 때는 호석이가 사가는 정보의 개수

            // pq가 있으면 불러오고, 없으면 새로 만든다.
            Queue<Integer> pq = map.getOrDefault(name, new PriorityQueue<>((o1, o2) -> o2 - o1));

            if (kind == 1) { // 고릴라가 정보를 모은다.
                while (cnt-- > 0) {
                    pq.offer(Integer.parseInt(st.nextToken()));
                }
            } else { // 고릴라에게 정보가 있다면 그만큼 산다.
                while (cnt-- > 0 && !pq.isEmpty()) {
                    ans += pq.poll();
                }
            }
            // 업데이트된 pq를 map에서 해당 name에 넣는다.
            map.put(name, pq);

        }

        System.out.print(ans);
        br.close();

    }

}