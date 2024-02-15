import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;


//나이순 정렬

public class Main {
    static Queue<Integer> queue;
    static StringBuilder sb;

    public static void main(String[] args) {

        queue = new LinkedList<>();
        sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int last = 0;

        for (int i = 0; i < n; i++) {
            String todo = sc.next();

            if (todo.equals("push")) {
                last = sc.nextInt();
                queue.offer(last);
            } else if (todo.equals("pop")) {
                if(queue.isEmpty())
                    sb.append(-1);
                else
                    sb.append(queue.poll());
                sb.append("\n");
            } else if (todo.equals("size")) {
                sb.append(queue.size());
                sb.append("\n");
            } else if (todo.equals("empty")) {
                if(queue.isEmpty())
                    sb.append(1);
                else
                    sb.append(0);
                sb.append("\n");
            } else if (todo.equals("front")) {
                if(queue.isEmpty())
                    sb.append(-1);
                else
                    sb.append(queue.peek());
                sb.append("\n");
            } else if (todo.equals("back")) {
                if(queue.isEmpty())
                    sb.append(-1);
                else{
                    sb.append(last);
                }

                sb.append("\n");
            }

        }

        System.out.println(sb.toString());

    }
}
