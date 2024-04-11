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
        int n = Integer.parseInt(br.readLine()); // N개의 수

        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int high = Integer.parseInt(st.nextToken());
            while (!pq.isEmpty() && pq.peek() > high) {
                pq.poll();
                answer++;
            }
            if (!pq.isEmpty() && pq.peek() == high) {
//                System.out.println("i"+i+" pq :  "+ pq);
//                System.out.println("i"+i+" answer : "+ answer);
                continue;
            }
            pq.offer(high);
//            System.out.println("i"+i+" pq :  "+ pq);
//            System.out.println("i"+i+" answer : "+ answer);

        }
//        System.out.println(pq);

        while(!pq.isEmpty() && pq.peek()!=0){
            answer++;
            pq.poll();
        }

        System.out.print(answer);

        br.close();
    } // main
} // class