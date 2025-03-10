import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken()); // 건물의 전체 층
		int S = Integer.parseInt(st.nextToken()); // 강호가 지금 있는 층
		int G = Integer.parseInt(st.nextToken()); // 이동하려는 층
		int U = Integer.parseInt(st.nextToken()); // 위로 U층을 가는 버튼
		int D = Integer.parseInt(st.nextToken()); // 아래로 D층을 가는 버튼
		if(S==G) {
			System.out.print(0);
			return;
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { S, 0 }); // 현재 층과 버튼을 누른 횟수
		int answer = 0;
		boolean hasAnswer = false;
		boolean[] visited = new boolean[F+1];

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowNum = now[0]; // 층
			int cnt = now[1]; // 누른 횟수
			int up = nowNum + U; // 올라갈때 층
			int down = nowNum - D; // 내려갈때 층
			if (up <= F && !visited[up]) { // 전체층 이하라면,탐색하지 않은 층이라면
				visited[up] = true;
				if (up == G) { // 이동하려는 층이면
					answer = cnt + 1;
					hasAnswer = true;
					break;
				} else {
					queue.offer(new int[] { up, cnt + 1 });
				}
			}
			if (down >= 1&& !visited[down]) { // 전체층 이하라면,탐색하지 않은 층이라면
				visited[down] = true;
				if (down == G) { // 이동하려는 층이면
					answer = cnt + 1;
					hasAnswer = true;
					break;
				} else {
					queue.offer(new int[] { down, cnt + 1 });
				}
			}
		}
		if (!hasAnswer) {
			System.out.print("use the stairs");
		} else {
			System.out.print(answer);
		}
		br.close();
	}

}
