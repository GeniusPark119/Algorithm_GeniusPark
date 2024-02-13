import java.util.Scanner;
import java.util.PriorityQueue;


//직각삼각형

public class Main {
    static PriorityQueue<Integer> pq;
    static StringBuilder sb;
    public static void main(String[] args) {
        pq = new PriorityQueue<>();
        sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            pq.offer(sc.nextInt());
        }

        while(!pq.isEmpty()){
            sb.append(pq.poll());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
