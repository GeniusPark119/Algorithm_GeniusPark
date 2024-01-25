import java.util.Stack;
class Solution {
    public Stack<Character> stack;
    boolean solution(String s) {
        boolean answer = true;
        stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && c==')' && stack.peek()=='('){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        if(!stack.isEmpty())
            answer = false;

        return answer;
    }
}