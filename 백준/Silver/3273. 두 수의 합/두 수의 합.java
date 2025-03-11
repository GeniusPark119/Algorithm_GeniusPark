import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> numbers = new ArrayList<>(); // 수열
		for (int i = 0; i < n; i++) {
			numbers.add(Integer.parseInt(st.nextToken()));
		}
		int x = Integer.parseInt(br.readLine());
		Collections.sort(numbers);
		int answer = 0;
		int pl = 0; // 왼쪽 포인터
		int pr = n - 1; // 오른쪽 포인터

		while (pl < pr) { // pl이 pr보다 작은 동안에만
			int sum = numbers.get(pl) + numbers.get(pr);
			if (x < sum) { // 두 수의 합이 x보다 크면 pr를 왼쪽으로 한 칸
				pr--;
			} else if (sum < x) { // 두 수의 합이 x보다 작으면 pl을 오른쪽으로 한 칸
				pl++;
			} else { // x와 같으면 answer 늘려주고 pl 오른쪽으로 한 칸
				answer++;
				pl++;
			}
		}
		System.out.print(answer);
	}

}
