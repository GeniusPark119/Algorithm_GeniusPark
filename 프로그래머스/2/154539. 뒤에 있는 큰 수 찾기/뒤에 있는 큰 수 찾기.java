import java.util.Stack;

class Solution {
    Stack<Integer> stack = new Stack<>();
    public int[] solution(int[] numbers) {
        int[] answer = {};
        answer = new int[numbers.length];

        stack.push(0);
        for(int i=0;i<numbers.length;i++){ // 스택에 있는 인덱스숫자보다 큰 숫자를 가진 인덱스가 나타나면 
            //해당 스택인덱스를 이번에 숫자로 저장하고 없앤다.
            // 어차피 스택은 앞의수보다 작은수가 저장되기 때문에 한번 작은 숫자가 아니면 그 뒤에도 그보다 큰숫자이다.
            while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i); // 이번 숫자도 스택에 올려서 다음 큰 숫자를 기다린다.
        }
        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}