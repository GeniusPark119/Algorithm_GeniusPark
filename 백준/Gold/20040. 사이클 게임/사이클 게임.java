import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 0 ~ n-1 고유번호 3 ≤ n ≤ 500,000
        m = Integer.parseInt(st.nextToken()); // 3 ≤ m ≤ 1,000,000

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i; // 각 부모에 연결된 최소 점, 일단 처음에는 최소가 자기 자신
        }

        int count = 0; // 몇 차례인지 구한다.
        boolean isConnected = false;

        for (int i = 0; i < m; i++) {

            count++; // 차례를 더한다 :  a,b 잇기전에 구하는거라 위에 있어야함

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (findLastChild(a) == findLastChild(b)) { // a b를 이었을때 끝점이 같다면 싸이클 완성!
                isConnected = true;
                break;
            }else{ // 같지 않다면 이어준다.
                unionPoints(a,b);
            }
        }

        if (!isConnected) // 만약 연결이 되어있지 않다면
            System.out.println(0);
        else
            System.out.println(count);

    }

    public static int findLastChild(int num) { // 가장 끝에있는 가장 작은 점 찾기
        if (parent[num] == num)
            return num;
        else
            return findLastChild(parent[num]);
    }

    public static void unionPoints(int a, int b) {
        a = findLastChild(a); // a의 끝점
        b = findLastChild(b); // b의 끝점

        if (a > b) // 큰수가 parent가 되게 이어준다.
            parent[a] = b;
        else
            parent[b] = a;
    }

}