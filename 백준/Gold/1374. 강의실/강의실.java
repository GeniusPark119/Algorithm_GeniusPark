import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // N개의 수

        List<int[]> list = new ArrayList<>(); // {시작,끝} 저장

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 강의 번호는 필요 없는 정보이다. 어떤 정보가 필요한지 필요하지 않은지 파악하는 것도 문제 풀이의 일부입니다! 천재!
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }
        list.sort((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]); // 시작 지점을 기준으로 오름차순 정렬 ( 같다면 끝지점을 기준으로 오름차순 정렬)

        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 끝 지점을 담는 pq, 끝 지점이 작은 순서대로 담아야 다음 강의를 비교할 때 완탐을 안해도 된다.

        for (int[] arr : list) { // list에 있는 강의들을 돌면서
            while (!pq.isEmpty() && pq.peek() <= arr[0]) // 다음강의의 시작지점의 pq에 담긴 끝지점보다 크거나 같다면 삭제해준다.
                pq.poll();

            pq.offer(arr[1]); // 그 후 다음 강의를 추가한다.
            answer = Math.max(answer, pq.size()); // 동시에 강의가 제일 많을 때 최대 필요한 강의실 수가 된다.
        }

        System.out.print(answer);

        br.close();
    } // main
} // class