import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E, K;
    static List<List<int[]>> edges;

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수

        K = Integer.parseInt(br.readLine());

        edges = new ArrayList<>();
        final int MAX = V * 10 + 1;

        for (int i = 0; i <= V; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.get(u).add(new int[]{v, w});
        }

        int[] min = new int[V + 1];

        Arrays.fill(min, MAX);
        min[K] = 0;

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        pq.offer(new int[]{K, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currV = curr[0];
            int currD = curr[1]; // W를 Distance로 표현했다.

            if (min[currV] < currD)
                continue;

//            List<int[]> nextList = edges.get(currV);
//            int l = nextList.size();
//            for (int i = 0; i < l; i++) {
//                int nextV = nextList.get(i)[0];
//                int nextD = currD + nextList.get(i)[1];
//                if (nextD < min[nextV]) {
//                    pq.offer(new int[]{nextV, nextD});
//                    min[nextV] = nextD;
//                }
//            }

            for(int[] next : edges.get(currV)){
                int nextV = next[0];
                int nextD = currD + next[1];
                if (nextD < min[nextV]) {
                    pq.offer(new int[]{nextV, nextD});
                    min[nextV] = nextD;
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            sb.append(min[i] == MAX ? "INF" : min[i]).append("\n");
        }

        System.out.print(sb);

    } // main 끝

}