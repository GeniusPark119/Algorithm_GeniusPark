// 최소한의 차이로 이기는것이 필승법~
// sort를 하면?
// 1 3 5 7
// 2 2 6 8 
import java.util.PriorityQueue;

class Solution {
    static PriorityQueue<Integer> pqA;
    static PriorityQueue<Integer> pqB;
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        pqA = new PriorityQueue<>();
        pqB = new PriorityQueue<>();
        
        for(int a : A){
            pqA.offer(a);
        }
        for(int b : B){
            pqB.offer(b);
        }
        
        while(!pqA.isEmpty()){
            int numA = pqA.peek();
            while(!pqB.isEmpty() && pqB.peek()<=numA){
                pqB.poll();
            }
            if(pqB.isEmpty())
                break;

            pqB.poll();
            pqA.poll();
            answer++;
        }
        return answer;
    }
}