// 3시 42분 시작 
// cdab? 그럼 숫자가 같으면 뒤에부터 우선순위를 가지는거야?
// 아니 우선순위 다음부터 시작하네

// 그럼 queue를 만들어서 앞에서 부터 뺀다고 생각해보자
// 2132 이라고 하면 2 빼고 1보다 2가 높으니까 
// 2  // 2 1 // 3 -- 2 1 // 3 2 -- 2 1 // 3 2 2 // 3 2 2 1
// 1232라고한다면
// 1 // 2 -- 1 // 3 -- 1 2 // 3 2 -- 1 2// 3 2 1 -- 2 // 3 2 2 -- 1 // 3 2 2 1

// queue 를 두개 만들어야한다. process될 큐랑 우선순위를 위해 다시 보류하는 큐
// 그렇다면 location에 해당하는 곳인지 어떻게 알 수 있지?
//  1 2 3 4 ... 인 로케이션을 위한 배열을 만들고 같이 움직여준다면?

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public Queue<Integer> queue;
    public List<Integer> list;
    public int solution(int[] priorities, int location) {
        int answer = 0;
        queue = new LinkedList<>();
        list = new ArrayList<>();
        
        for(int i=0;i<priorities.length;i++){
            queue.offer(i);
        }
        // queue 0,1,2,3,4,5
        
        for(int i=0;i<priorities.length;i++){
            int max = 0;
            int max_seq = 0;
            
            for(int x : queue){
                if(priorities[x]>max){
                    max = priorities[x];
                    max_seq = x;
                }
            }
            while(queue.peek()!=max_seq){
                queue.offer(queue.poll());
            }
            list.add(queue.poll());
        }
        System.out.println(list);
        for(int i =0;i<list.size();i++){
            if(location == list.get(i)){
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}