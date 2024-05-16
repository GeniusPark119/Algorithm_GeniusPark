import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main { // 1238 파티

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken()); // 마을(사람) 수
        int M = Integer.parseInt(st.nextToken()); // 도로의 수
        int X = Integer.parseInt(st.nextToken()); // 파티가 열리는 마을
        int MAX = 100000; // 최대시간

        List<List<int[]>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++) { // 1~N 마을에 대한 idx를 만든다.
            list.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 출발
            int B = Integer.parseInt(st.nextToken()); // 도착
            int T = Integer.parseInt(st.nextToken()); // 시간

            list.get(A).add(new int[]{B, T});
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {

            int holeT = 0; // 파티에 다녀오는데 걸리는 시간

            // 집에서 파티로 가는 길

            Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1])); // 시간이 빠른 순
            int[] min = new int[N + 1]; // 마을까지 최소 시간 저장
            Arrays.fill(min, MAX); // 최대 시간 저장
            min[i] = 0; // 출발하는 마을은 시간이 0

            pq.offer(new int[]{i, 0});

            while (!pq.isEmpty()) {

                int[] arr = pq.poll();
                int currP = arr[0]; // 마을
                int currT = arr[1]; // 시간

                if (currP == X) {
                    holeT += currT;
                    break;
                }

                for (int[] next : list.get(currP)) {
                    int nextT = currT + next[1]; //다음 마을까지 시간
                    if (nextT < min[next[0]]) { // 다음 마을까지 시간이 min에 저장된 값보다 작은지 확인
                        pq.offer(new int[]{next[0], nextT}); // 다음 마을까지 가는 시간 저장
                        min[next[0]] = nextT; // min 업데이트
                    }
                }
            }

            // 이제는 파티에서 집으로 돌아오는 길

            pq.clear(); // pq 남은것 지우기

            Arrays.fill(min, MAX); // 최대 시간 저장
            min[X] = 0; // 출발하는 파티마을은 시간 0

            pq.offer(new int[]{X, 0});

            while (!pq.isEmpty()) {

                int[] arr = pq.poll();
                int currP = arr[0]; // 마을
                int currT = arr[1]; // 시간

                if (currP == i) {
                    holeT += currT;
                    break;
                }

                for (int[] next : list.get(currP)) {
                    int nextT = currT + next[1]; //다음 마을까지 거리
                    if (nextT < min[next[0]]) { // 다음 마을까지 거리가 min에 저장된 값보다 작은지 확인
                        pq.offer(new int[]{next[0], nextT}); // 다음 마을까지 가는 시간 저장
                        min[next[0]] = nextT; // min 업데이트
                    }
                }
            }

            answer = Math.max(answer, holeT);

        }

        System.out.print(answer);
        br.close();


    }
}