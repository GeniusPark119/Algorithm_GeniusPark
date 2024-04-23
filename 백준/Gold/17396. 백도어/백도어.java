import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { // 11 : 30

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 분기점의 수
        int M = Integer.parseInt(st.nextToken()); // 분기점들을 잇는 길의 수

        st = new StringTokenizer(br.readLine());

        int[] points = new int[N]; // 분기점을 0 안보임, 1 보임 저장

        for (int i = 0; i < N - 1; i++) { // points를 입력 받는다.
            points[i] = Integer.parseInt(st.nextToken());
        }

//        int[][] ptop = new int[N][N]; 인접 행렬을 쓰면 안된다!!
        //인접배열로 하면 메모리초과 ( 최대 N^2 = 100,000 * 100,000 = 10,000,000,000개의 저장공간 필요 ) -> 인접리스트로 해야함
        // int형은 4바이트
        // 1KB는 1024바이트
        // 1MB는 1024KB
        // 512MB = 512 * 1024KB = 512 * 1024 * 1024B = int형 512 * 1024 * 1024 / 4 = 134,217,728개

        List<List<int[]>> list = new ArrayList<>(); // 메모리상 인접리스트로 해야한다.

        for (int i = 0; i < N; i++) { // list에 N개 분기점 리스트 선언
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) { //입력을 받으면서 인접리스트를 채워준다.
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if (points[a] == 1 || points[b] == 1)
                continue; // 만약 둘중 하나의 분기점이 이미 보여지는 상태이면 건너뛴다.

            // 인접행렬에 a분기점에서 이어져있는 b분기점과 시간 , 그 반대도 저장
            list.get(a).add(new int[]{b, t});
            list.get(b).add(new int[]{a, t});
        }

        // 큐에 나중에 들어온 길이 더 빠를 수 있기 때문에 Linkedlist로 하면 안됨 -> 우선순위큐 사용
        //N * t = 최대 100,000 * 100,000 = 10,000,000,000 이므로 큐에 int[] 를 넣으면 안됨
        PriorityQueue<long[]> queue = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1])); // { 분기점의 idx , 누적해서 걸리는 시간 t }
        // long 끼리 뺐는데 int로 전환해서 오름차순이 되나? 의문

        //같은 이유로 visited를 사용하면 안되고 필요하지 않음 -> min 배열을 사용해야함
        long[] min = new long[N]; // 해당 분기점까지 가는 최단 거리

        long max = 10_000_000_000L + 1;

        Arrays.fill(min, max); // 초기값을 max로 잡아준다.

        queue.offer(new long[]{0, 0}); // 초기 0 지점과 t 0 저장
        min[0] = 0;


        while (!queue.isEmpty()) {
            long[] curr = queue.poll();
            int currPoint = (int) curr[0];
            long currTime = curr[1];

            // 더 느린 길을 통한 경로가 큐에 새로 들어가지 않도록 큐에서 꺼내고 바로 체크를 해야함 -> min 배열 정보와 currT 비교
            if (min[currPoint] < currTime) continue;


            for (int[] ints : list.get(currPoint)) { // 현재 분기점에서 이어져있는 리스트 내역안에서 큐에 넣기
                long nextTime = currTime + ints[1];
                if (min[ints[0]] > nextTime) { // 다음 포인트의 시간보다 더 짧다면
                    min[ints[0]] = nextTime; // 갱신해주고
                    queue.offer(new long[]{ints[0], nextTime});// 해당 지점에서부터 갈 수 있는 분기점과 누적시간을 queue에 저장
                }
            }
        }

        System.out.print(min[N - 1] == max ? -1 : min[N - 1]);

        br.close();
    } // main
} // class