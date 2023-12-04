import java.util.PriorityQueue;
import java.util.Arrays;
//하 졸려
class Solution {
    public PriorityQueue<Integer> queue = new PriorityQueue<>();
    int K;
    public int solution(int[] scoville, int K) {
        int answer = 0;

        this.K = K;
        Arrays.sort(scoville);
        
        for(int x : scoville){
            queue.offer(x);
        }
        
        while(!isMoreHot()){
            if(queue.size()==1) return -1;
            mixHot();
            answer++;
        }
        return answer;
    }
    public void mixHot(){
        int min_first = queue.poll();
        int min_second = queue.poll();
        queue.offer(min_first+min_second*2);
    }
    public boolean isMoreHot(){
        for(int x : queue){
            if(x<K) return false;
        }
        return true;
    }
}