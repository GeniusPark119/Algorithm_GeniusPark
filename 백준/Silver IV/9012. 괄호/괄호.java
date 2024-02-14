import java.util.Scanner;
import java.util.Stack;


//나이순 정렬

public class Main {
    static Stack<Character> stack;
    static StringBuilder sb;

    public static void main(String[] args) {

        stack = new Stack<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            String ans = "YES";

            // stack 이 비워 있을 때 무조건 괄호 '(' 가 나와야함
            // stack 이 안 비워있을때 괄호'('가 나오면 만약 stack.peek 가 ')' 이면 break NO임 아니면 그냥 추가
            // ')'가 나오면 stack.peek가 '('이래야지 pop임, 아니면 break NO임

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (stack.isEmpty()) {
                    if (c == '(')
                        stack.push(c);
                    else {
                        ans = "NO";
                        break;
                    }
                } else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '(' && stack.peek() == '(') {
                    stack.push(c);
                } else {
                    ans = "NO";
                    break;
                }
            }

            if (!stack.isEmpty())
                ans = "NO";
            System.out.println(ans);
            stack.clear();
        }


//        System.out.println(sb.toString());

    }
}
