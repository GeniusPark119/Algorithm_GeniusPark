import java.util.Scanner;
//import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;


//나이순 정렬

public class Main {
    static StringBuilder sb;
    static Deque<Integer> dq;

    public static void main(String[] args) {

        dq = new ArrayDeque<>();
        sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        for (int i = 0; i < n; i++) {
            String str = sc.next();

            if (str.equals("push_front")) {
                int num = sc.nextInt();
                dq.offerFirst(num);

            } else if (str.equals("push_back")) {
                int num = sc.nextInt();
                dq.offerLast(num);
            } else if (str.equals("pop_front")) {

                if (dq.isEmpty())
                    sb.append(-1);
                else {
                    sb.append(dq.pollFirst());
                }
                sb.append("\n");

            } else if (str.equals("pop_back")) {

                if (dq.isEmpty())
                    sb.append(-1);
                else {
                    sb.append(dq.pollLast());
                }
                sb.append("\n");

            } else if (str.equals("size")) {
                sb.append(dq.size());
                sb.append("\n");

            } else if (str.equals("empty")) {
                if (dq.isEmpty())
                    sb.append(1);
                else
                    sb.append(0);
                sb.append("\n");

            } else if (str.equals("front")) {

                if (dq.isEmpty())
                    sb.append(-1);
                else {
                    sb.append(dq.peekFirst());
                }
                sb.append("\n");

            } else if (str.equals("back")) {

                if (dq.isEmpty())
                    sb.append(-1);
                else {
                    sb.append(dq.peekLast());
                }
                sb.append("\n");

            }
        }

        System.out.println(sb.toString());


    }
}
