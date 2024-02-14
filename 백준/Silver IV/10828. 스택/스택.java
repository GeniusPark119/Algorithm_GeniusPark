import java.util.Scanner;
import java.util.Stack;


//나이순 정렬

public class Main {
    static Stack<Integer> stack;
    static StringBuilder sb;

    public static void main(String[] args) {

        stack = new Stack<>();
        sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String todo = sc.next();

            if (todo.equals("push")) {
                stack.push(sc.nextInt());
            } else if (todo.equals("pop")) {
                if(stack.isEmpty())
                    sb.append(-1);
                else
                    sb.append(stack.pop());
                sb.append("\n");
            } else if (todo.equals("size")) {
                sb.append(stack.size());
                sb.append("\n");
            } else if (todo.equals("empty")) {
                if(stack.isEmpty())
                    sb.append(1);
                else
                    sb.append(0);
                sb.append("\n");
            } else if (todo.equals("top")) {
                if(stack.isEmpty())
                    sb.append(-1);
                else
                    sb.append(stack.peek());
                sb.append("\n");
            }

        }

        System.out.println(sb.toString());

    }
}
