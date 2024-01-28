import java.util.PriorityQueue;

class Solution {
    static PriorityQueue<Integer> pq;
    public int solution(int[] scoville, int K) {
        int answer = 0;
        pq = new PriorityQueue<>();
        for(int i : scoville){
            pq.offer(i);
        }
        
        while(pq.size()>1 && pq.peek()<K){
            pq.offer(pq.poll()+pq.poll()*2);
            answer++;
            
            if(pq.size()==1 && pq.poll()<K) 
                return -1;
        }

        return answer;
    }
}