import java.util.PriorityQueue;

class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int sum = 0;
        for(int i=0;i<enemy.length;i++){
            pq.offer(enemy[i]); // pq에 적군 수를 저장한다.
            sum+=enemy[i]; // 계속해서 적의 수를 더해나간다.
            answer++; // 한라운드를 진행했으니 ans +1 를한다.
            if(sum>n){ // 만약 sum이 아군수보다 높으면
                if(k>0){ // 무적권이 있다면 priority 큐에 다음 적을 넣고 가장 높은 기록을 뺀다.
                    sum -= pq.poll();
                    k--; // k사용했으니 -1
                }else{// 더이상 무적권이 없으면
                    answer--; // 이번라운드는 못지났으니 ans-1한게 답
                    break;
                }
            }
        }
        return answer;
    }
}