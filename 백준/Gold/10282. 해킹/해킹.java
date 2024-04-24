import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { // 2024년 2월 24일 13 : 00 ~ 14 : 51

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine()); // 테스트케이스 수


        while (tc-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터의 번호

            List<List<int[]>> list = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) { // a 인덱스에 b로부터 전염되는 시간을 list 추가
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // a는 b에게 전염된다.
                int b = Integer.parseInt(st.nextToken()); // b는 a에게 전염시킨다.
                int s = Integer.parseInt(st.nextToken()); // s초 후 a 감염

                list.get(b).add(new int[]{a, s}); // b가 감염되면 전염되는 a와 시간 저장
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0])); // 큐에 나중에 들어온 전염시간이 더 빠를 수 있을 수 있기 때문
            pq.offer(new int[]{c, 0}); // 전염 시작 컴과 시작시간 0

            int[] min = new int[n + 1]; // min 시간을 통해 최소값을 저장해서 visited 필요 없다
            int max = 10_000_000; // 처음에는 max값으로 저장한 후 최소값을 이후로 저장한다.
            Arrays.fill(min, max);
            min[c] = 0; // 처음 출발하는 min은 0으로


            while (!pq.isEmpty()) {
                int[] arr = pq.poll();

                int currCom = arr[0]; // 현지점 컴퓨터
                int currTime = arr[1]; // 현지점 누적 시간

                if (min[currCom] < currTime) // min 이 더 빠르면 패스
                {
                    continue;
                }

                for (int[] currA : list.get(currCom)) { // 해당 컴에게 전염되는 컴 확인
                    int nextCom = currA[0];
                    int nextTime = currA[1] + currTime;

                    if (min[nextCom] > nextTime) { // 경로가 더 빠르면 갱신해주고 pq에 추가
                        min[nextCom] = nextTime;
                        pq.offer(new int[]{nextCom, nextTime});
                    }
                }
            }

            int cnt = 0; // 감염되는 컴퓨터 수
            int time = 0; // 전체 감염되는데 걸리는 시간

            for (int i = 1; i <= n; i++) {
                if (min[i] != max) {
                    cnt++;
                    time = Math.max(time, min[i]);
                }
            }
            sb.append(cnt).append(" ").append(time).append("\n");
        }

        System.out.print(sb);

        br.close();
    } // main
} // class