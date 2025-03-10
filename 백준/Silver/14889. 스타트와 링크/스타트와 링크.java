import java.util.*;
import java.io.*;

public class Main { // 스타트와 링크 20250310
    static int N; // 축구를 하기 위해 모인 사람들
    static List<int[]> list; // 능력치 배열
    static boolean[] visited; // 방문체크
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 축구를 하기 위해 모인 사람들
        list = new ArrayList<>(); // 능력치 배열
        StringTokenizer st;
        for (int i = 0; i < N; i++) { // 능력치 배열 입력
            list.add(new int[N]);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                list.get(i)[j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N]; // 방문체크
        dfs(0, 0); // 깊이우선탐색 시작
        System.out.print(answer);
    }

    static void dfs(int depth, int starter) { // starter를 통해 중복되는 팀을 방지한다 ex) (1,3) (3,1)
        if (depth == N / 2) { // 백트래킹 조건 : 인원수의 반만큼 depth가 채워지면
            int start = 0; // 스타트팀 총 능력치
            int link = 0; // 링크팀 총 능력치

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i] && visited[j]) { // 둘다 start 팀이라면
                        start += list.get(i)[j];
                    } else if (!visited[i] && !visited[j]) { // 둘다 link 팀이라면
                        link += list.get(i)[j];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(start - link)); // 두 팀의 총 능력치 차이의 절대값을 기존의 answer와 비교해서 더 작은 값을 저장한다.
            return; // 백트래킹
        }
        for (int i = starter; i < N; i++) { // visited를 통해 같은 사람이 한 팀에 뽑히는걸 방지
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i); // 깊이우선탐색
                visited[i] = false;
            }
        }
    }
}