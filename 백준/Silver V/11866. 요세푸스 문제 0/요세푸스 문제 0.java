import java.util.Scanner;
//import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;


//나이순 정렬

public class Main {
    static StringBuilder sb;
    static Queue<Integer> queue;

    public static void main(String[] args) {

        sb = new StringBuilder();
        queue = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();


        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int[] ans = new int[n];
        int idx = 0;

        while(!queue.isEmpty()){
            for(int i=1;i<k;i++){
                queue.offer(queue.poll());
            }
            ans[idx++] = queue.poll();

        }

        sb.append("<");
        sb.append(ans[0]);

        for(int i=1;i<n;i++){
            sb.append(", ");
            sb.append(ans[i]);
        }
        sb.append(">");

        System.out.println(sb.toString());

    }
}
