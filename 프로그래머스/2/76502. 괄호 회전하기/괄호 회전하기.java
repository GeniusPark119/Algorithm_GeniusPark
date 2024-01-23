import java.util.Stack;

class Solution {
    Stack<Character> stack;
    public int solution(String s) {
        int answer = 0;
        stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(i==0){
                if(check(s)) answer++;
                continue;
            }
            char tmp = s.charAt(0);
            s = s.substring(1,s.length()) + tmp;
            if(check(s)) {
                // System.out.println("i "+i+" s "+s);
                answer++;
            }
        }

        return answer;
    }
    public boolean check(String s){
        stack.clear();
        for(int i=0;i<s.length();i++){
            char tmp = s.charAt(i);
            
                if(!stack.isEmpty() && (
                   (tmp==')' && stack.peek()=='(') ||
                   (tmp=='}' && stack.peek()=='{')  ||
                   (tmp==']' && stack.peek()=='[')
                   )){
                    stack.pop();
                }else{
                stack.push(tmp);
                }
            
        }
        if(stack.isEmpty()) 
            return true;
        else
            return false;
        
    }
}