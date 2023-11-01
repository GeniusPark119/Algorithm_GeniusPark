import java.util.Stack;

class Solution {
    public Stack<Integer> stk = new Stack<>();
    public int[] solution(int[] arr) {
        int[] answer = {};
        int i=0;
        while(i<arr.length){
            if(stk.isEmpty()) {
                stk.push(arr[i]);
                i++;
            }else{
                if(stk.peek()==arr[i]){
                    stk.pop();
                    i++;
                }else{
                    stk.push(arr[i]);
                    i++;
                }
            }
        }
        if(stk.isEmpty()) answer = new int[] {-1};
        else{
            answer = new int[stk.size()];
            int idx = stk.size()-1;
            while(!stk.isEmpty()){
                answer[idx--] = stk.pop();
            }
        }
        return answer;
    }
}