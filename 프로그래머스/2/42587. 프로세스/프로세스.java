import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Solution {//231225 4시 30분 
    public Queue<Integer> queue = new LinkedList<>();
    public List<Integer> list = new ArrayList<>();
    public int solution(int[] priorities, int location) {
        int answer = 0;
        for(int i=0;i<priorities.length;i++){
            queue.add(i);
        }

        for(int i=0;i<priorities.length;i++){
            // System.out.println("s"+queue);
            int max = -1;
            int max_seq = 0;
            int seq = 1;
            for(int x : queue){
                // System.out.println(x);
                if(priorities[x]>max){
                    max = priorities[x];
                    max_seq = seq;
                }
                seq++;
            }
            for(int j=1;j<max_seq;j++){
                queue.add(queue.poll());
            }
            // System.out.println(queue);
            list.add(queue.poll());
        }
        // System.out.println(list);
        for(int i=0;i<list.size();i++){
            if(list.get(i)==location) return i+1;
        }
        return answer;
    }
}