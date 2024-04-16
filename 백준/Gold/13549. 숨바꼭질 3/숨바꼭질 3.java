import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int bfs(int n, int k) {
        Queue<int[]> queue = new LinkedList<>(); // { 위치 , 시간 }
        boolean[] visited = new boolean[100_001];

        queue.offer(new int[]{n, 0});
        visited[n] = true; // 이거 체크 안하면 시간 초과!! bfs할 때 꼭 생각하기 

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int point = arr[0];
            int time = arr[1];

            if (point == k) // 동생이 있는 자리에 갔다면 return
                return time;

            if (0 <= point * 2 && point * 2 <= 100_000 && !visited[point * 2]) { // *2 자리로 갔을 때 범위내에 있다면 queue에 시간 추가 안하고 저장
                visited[point * 2] = true;
                queue.offer(new int[]{point * 2, time});
            }
            if (point - 1 >= 0 && !visited[point - 1]) { // 한칸 -1로 갔을 때 범위가 0이상이면 queue에 시간 1 늘려서 저장
                visited[point - 1] = true;
                queue.offer(new int[]{point - 1, time + 1});
            }
            if (point + 1 <= 100_000 && !visited[point + 1]) { //한칸 +1로 갔을 때 100_000 이하이면 queue에 시간 1 줄여서 저장
                visited[point + 1] = true;
                queue.offer(new int[]{point + 1, time + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈이
        int K = Integer.parseInt(st.nextToken()); // 동생


        System.out.println(bfs(N, K));


    }


}