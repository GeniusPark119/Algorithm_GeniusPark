import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
        
        // 큐에 몇번째인지와 숫자 저장
        Queue<int[]> queue = new LinkedList<>();
        
        //우선순위큐에 모든 숫자를 넣고 내림차순으로 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // 숫자가 클 수록 우선순위 높음
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]}); // 0 : 몇번째인지 1 : 숫자
            pq.offer(priorities[i]); 
        }

        int answer = 0;

        while (!queue.isEmpty()) {
            if (pq.peek() != queue.peek()[1]) { // 만약 가장 큰수가 현재 맨 앞에 있지 않으면
                queue.offer(queue.poll()); // 빼고 순서 맨 뒤에 다시 넣는다.
                continue;
            }
            // 만약 가장 큰 수가 현재 맨앞에 있다면
            if (queue.peek()[0] == location) { // 동시에 원하는 순번이라면
                answer++; // 이제까지 빠져나간 횟수에 하나 더하고 break;
                break;
            }
            
            //원하는 순번은 아니면 queue의 맨앞 제거, pq의 맨앞 제거
            queue.poll();
            pq.poll();
            answer++;
        }

        return answer;


    }
}