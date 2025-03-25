import java.io.*;
import java.util.*;

public class Main { // 특정 거리의 도시 찾기 2025.03.26
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) { // 1~N 도시
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list.get(A).add(B);
        }

        boolean[] visited = new boolean[N + 1]; // 1~N 방문처리
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{X, 0});
        visited[X] = true;
        StringBuilder sb = new StringBuilder();
        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) { // bfs
            int[] arr = queue.poll();
            int city = arr[0];
            int distance = arr[1];

            if (distance == K) { // 거리가 K 라는 것은 중간에 visited 체크되지 않고 왔다는 것이다.
                answer.add(city);
                continue;
            }

            List<Integer> nexts = list.get(city);

            for (int next : nexts) { // visited되지 않았다면 거리 늘려서 queue에 저장, visited 처리
                if (!visited[next]) {
                    queue.offer(new int[]{next, distance + 1});
                    visited[next] = true;
                }
            }
        }

        if (answer.isEmpty()) System.out.print(-1);
        else {
            Collections.sort(answer);
            for (int city : answer) {
                sb.append(city).append("\n");
            }
            System.out.print(sb);
        }
    }
}
