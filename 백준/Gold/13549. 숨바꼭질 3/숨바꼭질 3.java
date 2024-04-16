import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 소정이
        int K = Integer.parseInt(st.nextToken()); // 상빈이

        Queue<int[]> queue = new LinkedList<>(); // { 소정위치 , 시간 }
        boolean[] visited = new boolean[100_001];

        queue.offer(new int[]{N, 0});
        visited[N] = true; // 이거 체크 안하면 시간 초과!! bfs할 때 꼭 생각하기

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int point = arr[0];
            int time = arr[1];

            if (point == K) {// 상빈이 있는 자리에 갔다면 return
                System.out.print(time);
                return;
            }

            // 이식이 제일 먼저 있어야 최소값이 저장되면서 visited 처리가 된다. 순서 바꾸면 틀림
            if (point <= 50_000 && !visited[point * 2]) { // *2 자리로 갔을 때 범위내에 있다면 queue에 시간 추가 안하고 저장
                visited[point * 2] = true;
                queue.offer(new int[]{point * 2, time});
            }
            if (point >= 1 && !visited[point - 1]) { // 한칸 -1로 갔을 때 범위가 0이상이면 queue에 시간 1 늘려서 저장
                visited[point - 1] = true;
                queue.offer(new int[]{point - 1, time + 1});
            }
            if (point < 100_000 && !visited[point + 1]) { //한칸 +1로 갔을 때 100_000 이하이면 queue에 시간 1 줄여서 저장
                visited[point + 1] = true;
                queue.offer(new int[]{point + 1, time + 1});
            }
        }


    }


}