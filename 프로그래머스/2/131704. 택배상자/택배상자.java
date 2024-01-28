import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

class Solution {
    static Stack<Integer> stack;
    static Queue<Integer> queue;
    public int solution(int[] order) {
        int answer = 0;
        int cnt = 0;
        stack = new Stack<>();
        queue = new LinkedList<>();
        
        for(int i=0;i<order.length;i++){
            stack.push(i+1);
            
            while(!stack.isEmpty()){
                if(stack.peek()==order[cnt]){
                    queue.offer(stack.pop());
                    cnt++;
                }else 
                    break;
            }
        }
        
        answer = queue.size();
        return answer;
    }
}