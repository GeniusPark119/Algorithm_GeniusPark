import java.util.*;

class Solution {
    public int solution(int storey) {
        
        Stack<Integer> stack = new Stack<>();
        
        char[] arr = (storey+"").toCharArray();
        
        
        for(char x : arr){
            stack.push(x-'0');
        }
        
        boolean plusOne = false;
        
        int answer = 0;
        
        while(!stack.isEmpty()){
            int curr = stack.pop(); // 맨 뒤 숫자
            if(plusOne) curr++; // 이전에서 1이 넘어왔으면 1 더해준다.
            
            if(curr>5){
                answer += 10 - curr;
                plusOne = true;
            }else if(curr==5){
                answer += 5;
                plusOne = (!stack.isEmpty()&&stack.peek()>=5);

            }else{
                answer += curr;
                plusOne = false;
            }
        }
        
        if(plusOne) answer++;
        
        return answer;
    }
}