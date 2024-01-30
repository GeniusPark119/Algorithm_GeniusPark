// 수열을 잘랐을 때 
// 비내림차순이 오름차순이라는 것인지, 순서가 섞여있다는 것인지 확인해봐야한다.

// stack으로 풀어보자 
import java.util.Queue;
import java.util.LinkedList;

class Solution { 
    static Queue<Integer> queue;
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        queue = new LinkedList<>();
        int sum = 0;
        int start = 0; // 시작하는 인덱스
        int len = Integer.MAX_VALUE; // 최소 길이, 이거보다 작아야 답이되는 구조
        for(int i=0;i<sequence.length;i++){
            
            queue.offer(sequence[i]);
            sum += sequence[i];
            
            
            while(sum > k){
                sum -= queue.poll();
                start++;
            }
            
            if(sum == k && len > i - start){
                answer[0] = start;
                answer[1] = i;
                len = i - start;
            }
            
            
        }
        
        // for(Range r : list){
        //     System.out.println("start : "+r.start +", end : " + r.end);
        // }
        
        
        return answer;
    }
    
    static class Range{ // class Range
        
        int start = 0;
        int end = 0;
        int len = 0;
        
        public Range(int start,int end){
            this.start = start;
            this.end = end;
            this.len = end-start+1;
        }
    }
}