import java.io.*;
import java.util.*;

public class Main { // 17471 게리맨더링
    static int N;
    static int[] people;
    static List<List<Integer>> list;
    static boolean[] selected;
    static boolean[] visited;
    static int gap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 구역의 개수
        people = new int[N + 1]; // 구역별(idx) 인구수
        list = new ArrayList<>(); // 구역별(idx) 인접한 다른 구역
        selected = new boolean[N + 1];

        final int MAX = 100 * N + 1;
        gap = MAX;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= N; i++) { // list 입력받기
            list.add(new ArrayList<>());
            if (i == 0) continue;
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            while (cnt-- > 0) { // 인접한 다른 구역 개수만큼 입력을 받는다.
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        } // 입력 끝

        divideZone(0); // 0부터 시작, 구역을 나누고 차이를 구하는 식

        System.out.print(gap == MAX ? -1 : gap); //MAX값과 같으면 나눌 수 없기에 -1

        br.close();

    }

    public static int getGap(List<Integer> areaA, List<Integer> areaB) {
        // 두 지역의 인구수 차이를 구한다.

        int sumA = 0;
        int sumB = 0;

        for (int zone : areaA) {
            sumA += people[zone];
        }
        for (int zone : areaB) {
            sumB += people[zone];
        }

        return Math.abs(sumA - sumB);
    }

    public static void divideZone(int idx) { // 백트래킹, 두 구역으로 나누어 인구수 차이를 확인한다.

        if (idx > N) { // 모두 골랐으면
            List<Integer> areaA = new ArrayList<>();
            List<Integer> areaB = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                if (selected[i])
                    areaA.add(i);
                else
                    areaB.add(i);
            }

            if (!areaA.isEmpty() && !areaB.isEmpty() &&
                    isNear(areaA) && isNear(areaB)) { // 두 지역에 최소한 하나의 구역이 있는지와 구역끼리 붙어있는지 확인
                gap = Math.min(gap, getGap(areaA, areaB));
            }
            return;
        } // 종료 조건


        selected[idx] = true; // true로 바꿔주고 다음단계, 다시 false로 바꿔주고 다음단계
        divideZone(idx + 1);
        selected[idx] = false;
        divideZone(idx + 1);

    }

    public static boolean isNear(List<Integer> zones) { // 주어진 구역 번호들이 인접해있는지 확인
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1];
        queue.offer(zones.get(0));
        visited[zones.get(0)] = true;
        int cnt = 1;
        while (!queue.isEmpty()) { // list에서 zones에 있는 구역과 연결되면 cnt를 늘리고 이를 zones의 size와 비교한다.
            int curr = queue.poll();
            for (int i = 0; i < list.get(curr).size(); i++) {
                int next = list.get(curr).get(i);
                if (zones.contains(next) && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }
        return cnt == zones.size();
    }
}