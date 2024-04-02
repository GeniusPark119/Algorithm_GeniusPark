import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isRobot; // 로봇의 유무
    static int[] belt; // 내구도

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 한줄 벨트 길이
        int K = Integer.parseInt(st.nextToken()); // 내구도 빈칸 기준
        int L = N * 2; // 전체 벨트 길이
        isRobot = new boolean[L + 1]; // 로봇 유무
        belt = new int[L + 1]; // 내구도

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <=L; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        // 로봇은 윗줄에만 존재한다는 점을 기억하기 : lift ~ lower 사이만 보면 된다.
        int lift = 1; // 올리는 칸
        int lower = N; // 내리는 칸
        int answer = 0;

        rotate :
        while (true) {
            answer++;
            // 벨트를 돌려준다. -> 올리는 칸과 내리는 칸 사이만 보면 된다.
            lift = lift == 1 ? L : lift - 1;
            lower = lower == 1 ? L : lower - 1;

            isRobot[lower] = false;
            // 로봇을 돌려준다.
            int curr = lower == 1 ? L : lower - 1; // 내리기 직전에 있는 로봇 위 -> lower 부터 lift 까지 확인해야 로봇을 차례대로 옮길 수 있다.

            // 어차피 맨 마지막에는 로봇이 없어서 확인할 필요 없으니 lower 직전부터 lift 시점까지 확인
            while (curr != lift) { //
                if(isRobot[curr]){ // 만약 로봇이 있다면?
                    int next = curr == L? 1 : curr+1; // 그 다음
                    if(!isRobot[next] && 0<belt[next]){ // 그 다음칸에 로봇이 없고 내구도가 있다면
                        if(--belt[next]==0) // 다음칸 내구도 깎고 0인지 확인
                            if(--K==0) // 0이면 k 빼고 k가 다 찾으면 끝
                                break rotate;
                        isRobot[curr] = false; // 현재 로봇 없애줌
                        if(next != lower) // 만약 다음칸이 lower칸이 아니면 로봇이 있다해야함 ( lower 칸에는 로봇이 무조건 없으니)
                            isRobot[next] = true;
                    }
                }
                curr = curr==1? L : curr-1; // 현재칸은 이제 직전칸이 된다.
            }
            if(0<belt[lift]){ // 올리는 칸이 내구도가 있다면
                if(--belt[lift]==0) // 내구도 1 깎고
                    if(--K==0) // 내구도 0이면 k 깎아서 다 찾는지 확인
                        break;
                isRobot[lift] = true; // 올리는 칸에 로봇 올려줌
            }
        }
        System.out.print(answer);
        br.close();
    } // main
} // class