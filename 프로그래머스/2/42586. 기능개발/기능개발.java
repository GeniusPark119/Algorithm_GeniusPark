import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public Queue<Integer> queue;
    public List<Integer> list;
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        queue = new LinkedList<>();
        list = new ArrayList<>();
        for(int i=0;i<progresses.length;i++){
            int start = progresses[i];
            int speed = speeds[i];
            int cnt = 0;
            while(start<100){
                cnt++;
                start+=speed;
            }
            queue.add(cnt);
        }
        
        int out = queue.poll(); // queue 맨 앞에 있는 수를 저장한다
        int cnt = 1; // 배포횟수
        
        
        while(!queue.isEmpty()){
            if(queue.peek()>out){
                list.add(cnt);
                out = queue.poll();
                cnt=1;
            }else{
                queue.poll();
                cnt++;
            }
        }
        list.add(cnt);
        
        answer = new int[list.size()];
        
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}