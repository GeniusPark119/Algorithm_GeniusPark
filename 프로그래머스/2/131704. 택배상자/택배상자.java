import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int cnt = 0;
        
        Stack<Integer> assistanceBelt = new Stack<>();
        Queue<Integer> basicBelt = new LinkedList<>();
        
        for(int i=0;i<order.length;i++){
            assistanceBelt.add(i+1);
            
            while(!assistanceBelt.isEmpty()){
                if(assistanceBelt.peek() == order[cnt]){
                    basicBelt.offer(assistanceBelt.pop());
                    cnt++;
                }else break;
            }
        }
        answer = basicBelt.size();
        return answer;
    }
}
   

// import java.util.Stack;

// class Solution {
//     // 보조 컨테이너 벨트
//     public Stack<Integer> assistanceBelt = new Stack<>();
//     public int solution(int[] order) {
//         int answer = 0;
//         int op = 0; // order 배열의 포인터
//         int currentBox = 1; // 컨테이너박스에서 현재 확인중인 번호
        
//         while(op<order.length){
//             //트럭에 실릴 박스의 숫자가 컨테이너 박스의 번호보다 큰 경우
//             if(order[op]>currentBox){
//                 // 보조 벨트에 현재 박스를 보관한다.
//                 assistanceBelt.push(currentBox);
//                 currentBox++;
//             // 트럭에 실릴 박스의 번호가 현재 컨테이너 벨트의 박스 번호와 같다면
//             }else if(order[op]==currentBox){
//                 answer++;
//                 currentBox++;
//                 op++;
//             }else{
//                 while(!assistanceBelt.isEmpty() && 
//                       order[op] == assistanceBelt.peek()){
//                     answer++;
//                     assistanceBelt.pop();
//                     op++;
//                 }
//                 if( op < order.length && order[op]<currentBox ) break;
//             }
//         }
        
//         return answer;
//     }
// }
    