import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { // 2024년 4월 30일 분리집합 (Disjoint Set)

    static int[] rep;
    static int n;

    static void makeSet() {
        for (int x = 0; x < n; x++) {
            rep[x] = x; // 자기자신을 대표로 하는 과정
        }
    } // makeSet

    static void union(int x, int y) { // x와 y를 친구 맺는다
        // 일관되게 작은 숫자를 새로운 대표로 하자!
        if (x < y)
            rep[y] = x;
        else
            rep[x] = y;
    } // union

    static int find(int x) {
        if (x != rep[x])
            rep[x] = find(rep[x]);// 내 대표의 대표를 불러온다. ( 경로 압축 (path compression) : 대표의 대표를 찾았을 때 미리 저장해놓는 방식. 시간초과을 막아준다 )
        return rep[x];

        // return (x!=rep[x])? (rep[x]=find(rep[x])) : rep[x] ; // 할당해서 저장까지 해주고 반환할 수도 있다.

    } // find

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine()); // 테스트케이스

        for (int i = 1; i <= tc; i++) {

            sb.append("Scenario ").append(i).append(":").append("\n"); // 출력 첫 줄

            n = Integer.parseInt(br.readLine()); // 유저 수 (1~100만)
            int k = Integer.parseInt(br.readLine()); // 친구관계 수 (1~10만)

            rep = new int[n];
            makeSet();


            for (int j = 0; j < k; j++) {

                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                int A = find(a); // a의 대표
                int B = find(b); // b의 대표

                if (A != B) {
                    union(A, B);
                }
            }

            int m = Integer.parseInt(br.readLine());

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                sb.append(find(u) == find(v) ? 1 : 0).append("\n"); // 둘의 대표가 같으면 친구, 같지 않으면 친구 아님
            }

            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    } // main
} // class