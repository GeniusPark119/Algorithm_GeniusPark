import java.util.Scanner;

import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
//프린터 큐

public class Main {
    static Stack<Integer> stack;
    static List<Character> list; // 답

    public static void main(String[] args) {
        stack = new Stack<>(); // stack 이용
        list = new ArrayList<>(); // 답 저장

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int start = 0;


        for(int i=0;i<n;i++){
            int num = sc.nextInt();

            if(start < num){
                for(int j=start+1;j<=num;j++){
                    stack.push(j);
                    list.add('+');
                }
                stack.pop();
                list.add('-');
                start = num;
            }else if(!stack.isEmpty() && stack.peek()==num){
                stack.pop();
                list.add('-');
            }else{
                list.clear();
                break;
            }
        }


        if(list.isEmpty()){
            System.out.println("NO");
        }else{
            for(char c : list){
                System.out.println(c);
            }
        }


    }

}
