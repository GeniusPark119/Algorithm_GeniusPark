import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 지하철 호선의 개수
        int N = Integer.parseInt(br.readLine());

        // 각 호선 idx에 역 저장하는 리스트
        List<List<Integer>> lines = new ArrayList<>();
        // list에 idx 1~N을 만들어준다
        for (int i = 0; i <= N; i++) lines.add(new ArrayList<>());

        // 각 역(Integer) 까지 최소 환승 횟수를 저장
        // 역이 항상 변칙적으로 나오기 때문에 존재하는 역을 모두 Map에 넣어주는 과정이 필수적이다
        Map<Integer, Integer> min = new HashMap<>();
        // {호선 , 역 , 환승횟수}
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            // 이번 호선에 있는 역의 개수
            int K = Integer.parseInt(st.nextToken());

            // 각 호선 idx에 역숫자를 저장한다.
            while (0 < K--) {
                int station = Integer.parseInt(st.nextToken()); // 이번역
                lines.get(i).add(station);
                // 아무리 많이 환승해도 N번보다 많이 환승하지는 않음
                min.put(station, N);
                // 서울역이면 queue에 추가
                if (station == 0) queue.offer(new int[]{i, 0, 0});
            }
        }

        // 서울역은 시작역이므로 환승 횟수는 0번
        min.put(0, 0);

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currL = curr[0]; // 현재 호선
            int currS = curr[1]; // 현재 역
            int currC = curr[2]; // 현재 역까지의 환승 횟수

//            if (min.get(currS) < currC) continue; // 시간을 아낀다

            // 모든 호선에 대해 이번 역을 포함하는지 검사
            for (int line = 1; line <= N; ++line) {
                // 이번 호선이 이번 역을 포함한다면
                if (lines.get(line).contains(currS)) {
                    // 호선에 있는 모든 다음 역들
                    for (int nextS : lines.get(line)) {
                        // 이번 호선과 다음 호선이 같으면 환승횟수는 그대로이지만 다르면 1를 더한다
                        int nextC = line == currL ? currC : currC + 1;
                        // 만약 다음역의 환승횟수가 이미 min 저장된 횟수보다 작아야지만
                        // min을 갱신해주고 queue에 새롭게 넣어준다.
                        if (nextC < min.get(nextS)) {
                            min.put(nextS, nextC);
                            queue.offer(new int[]{line, nextS, nextC});
                        }
                    }
                }
            }

        }

        int res = min.get(Integer.parseInt(br.readLine())); // 목적지 역에 저장된 최소환승 횟수
        System.out.print(res == N ? -1 : res); // 처음 설정한 max값이면 -1이다.
        br.close();
    } // main
} // class