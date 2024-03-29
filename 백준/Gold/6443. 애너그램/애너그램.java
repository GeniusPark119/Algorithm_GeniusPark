import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb; // 전체 답

    // 테스트마다 갱신할 전역 변수
    static Queue<String> queue;
    static Stack<Character> stack;
    static char[] chars; // 주어진 문자들
    static int length; // 주어진 문자 길이
    static int[] check; // 알파벳 'a'~'z'

    public static void main(String[] args) throws IOException {

        sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            // 반복문 마다 새롭게 준비해놓기
            queue = new PriorityQueue<>();
            stack = new Stack<>(); // 글자를 나열할 stack
            chars = br.readLine().toCharArray(); // 문자 배열
            length = chars.length; // 글자수
            check = new int[26]; // 알파벳 a ~ z

            for (char c : chars) {
                check[c - 'a']++; // 문자들이 총 몇개씩 있는지 담기
            }
            backtracking(0); // 백트래킹
            for(String s : queue){
                sb.append(s).append("\n");
            }
        }



        System.out.print(sb);

    }

    public static void backtracking(int dep) {

        if (dep == length) { // 글자수가 다 차면 return 조건
            StringBuilder str_sb = new StringBuilder();
            for(char c : stack){
                str_sb.append(c);
            }
            queue.offer(str_sb.toString());
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (check[i]>0){
                check[i]--;
                stack.push((char)(i+'a')); //  stack 해당 char 더해준다.
                backtracking(dep+1);
                stack.pop();
                check[i]++;
            }

        }
    }
}