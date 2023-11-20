import java.util.Stack;
class Solution {
    Stack<Character> stack = new Stack<>();
    boolean solution(String s) {
        boolean answer = true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') stack.push('(');
            else{
                if(stack.size() == 0) {
                    answer = false;
                    break;
                }else{
                    stack.pop();
                }
                    
            }
        }     
        
        if(stack.size()!=0) answer =false;

        return answer;
    }
}