//3 : 38

// 제곱수가 최소로하려면 골고루 나누는게 좋다?
// 큰수를 많이 줄이는게 좋다?

import java.util.PriorityQueue;

class Solution {
    static PriorityQueue<Integer> pq;
    public long solution(int n, int[] works) {
        long answer = 0;
        pq = new PriorityQueue<>((a,b)->b-a);
        for(int work : works){
            pq.offer(work);
        }
        while(n!=0){
            // System.out.println(pq+" "+n);
            int max = pq.poll();
            if(pq.peek()==0) return 0;
            int gap = max - pq.peek();
            if(n<=gap){
                pq.offer(max-n);
                break;
            }else{
                n -= gap+1;
                pq.offer(max-gap-1);
            }
        }
        while(!pq.isEmpty()){
            answer += (int)Math.pow(pq.poll(),2);
        }
        return answer;
    }
}