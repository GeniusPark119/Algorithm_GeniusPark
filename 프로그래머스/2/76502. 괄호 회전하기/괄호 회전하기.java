import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public Queue<Character> queue = new LinkedList<>();
    public Stack<Character> stack = new Stack<>();
    public int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length();i++){
            queue.offer(s.charAt(i));
        }
        int x = 0;
        while(x<s.length()){
            for(Character c : queue){
                if(!stack.isEmpty() && ((c==')' && stack.peek()=='(')
                    ||(c=='}' && stack.peek()=='{')
                    ||(c==']' && stack.peek()=='['))){
                    stack.pop();
                }else 
                    stack.push(c);
            }
            if(stack.isEmpty()) answer++;
            stack.clear();
            
            char front = queue.poll();
            queue.offer(front);
            x++;
        }
        return answer;
    }
}