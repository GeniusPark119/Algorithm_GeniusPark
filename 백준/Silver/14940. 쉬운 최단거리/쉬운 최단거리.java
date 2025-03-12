import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 세로의 크기
		int m = Integer.parseInt(st.nextToken()); // 가로의 크기

		int[][] board = new int[n][m]; // 지도
		int[][] result = new int[n][m]; // 답
		int endr = 0, endc = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2) { // 목표 지점이면 목표지점의 좌표를 저장하고 result에 0으로 표시한다.
					endr = i;
					endc = j;
					result[i][j] = 0;
				} else if (board[i][j] == 1) { // 1인 지점이면 도달할 수 없는 위치라 가정하에 -1로 통일한다.
					result[i][j] = -1;
				}
			}
		}
		boolean[][] visited = new boolean[n][m];
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		Queue<int[]> queue = new LinkedList<>(); // bfs를 위한 queue : 목표지점으로부터 상하좌우 탐색을 통해 result를 채우는데 쓰일 queue
		queue.add(new int[] { endr, endc, 0 }); // 목표좌표 제일 먼저 queue에 넣기
		visited[endr][endc] = true; // queue에 넣으면 방문처리

		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			int r = arr[0];
			int c = arr[1];
			int dep = arr[2];

			for (int i = 0; i < 4; i++) { // 상하좌우 탐색
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= n || nc < 0 || nc >= m || board[nr][nc] == 0 || visited[nr][nc]) // 좌표를 넘어서거나 원래갈 수 없거나 방문했다면 continue
					continue;
				result[nr][nc] = dep + 1; // 답안에 한칸 더 온 거리를 저장한다.
				queue.add(new int[] { nr, nc, dep + 1 }); 
				visited[nr][nc] = true; // queue에 넣었으면 방문처리
			}
		}
		for (int i = 0; i < n; i++) { // 출력
			for (int j = 0; j < m; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}

}
