import java.util.LinkedList;
import java.util.Queue;
// 트럭이 다리를 건너는 시간 bridge_length +1 
// 다리위에 있는 트럭을 queue에 저장해두고 bridge_length +1 지나갈때까지 두고 poll를 한다.
// 각 트럭이 다리에 머물러 있는 시간을 따로 저장해두는 장치가 필요하다 -> map? array?
// 이 queue에 있는 트럭의 무게의 합이 weight을 넘어가면 더이상 큐에 다음 트럭을 올리면 안되겠지?
// 모든 트럭이 이 다리를 건넜다는 확인이 필요하고 확인되면 식을 끝내는 장치가 필요하다.

class Solution {
    public Queue<Integer> queue = new LinkedList<>();// 다리 위에 있는 트럭을 저장해 둔다.
    public int[] seconds; // 각 인덱스 트럭별 다리를 지나는 시간 bridge_length +1 까지만 세야겠지
    public int first_truckidx = 0; // 큐에 있는 첫번째 트럭의 인덱스
    public int last_truckidx = 0; // 큐에 있는 마지막 트럭의 인덱스
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // int[] truck_weights = {2,2,2,2,2,2};
        // weight = 2;
        // bridge_length = 1;
            
            // 테스트중입니다
        int answer = 0;
        seconds = new int[truck_weights.length]; // 각 인덱스의 트럭이 다리를 건너는 시간
        queue.add(0); // 처음 트럭이 다리로 건넌다.
        while(true) {

            answer++; // 초를 센다.
            
            // 큐에 있는 트럭들이 이동한 초를 1씩 늘린다.
            for(int i=first_truckidx;i<=last_truckidx ;i++){
                seconds[i]++;
            }            
            // System.out.println(queue);
            // for(int i=0;i<truck_weights.length;i++){
            //     System.out.print(seconds[i]+" ");
            // }
            // System.out.println();
            
            // 큐 맨앞의 트럭이 나가면 빼준다. 그게 마지막 차면 break 한다.
            if(seconds[first_truckidx] == bridge_length+1) {
                queue.poll(); // 맨앞의 트럭을 뺀다.
                first_truckidx++;// 맨앞의 트럭이 다음 인덱스가된다.
                if(first_truckidx == truck_weights.length) break; 
                //동시에 만약 맨앞 트럭의 인덱스가 트럭의 수와 같다면 while문을 break 해주며 식을 끝낸다.
            }
            // 만약에 1. 아직 다리에 들어가지 않은 트럭이 있다면
            // 2. 다음 트럭이 들어갈수 있다면 queue에 올린다.
            // 트럭이 들어갈 수 있다는 건 1. 다리가 버틸수 있는 무게이다 2. 자리가 있다
            // 이 때 주의할 점은 맨앞 트럭이 나갈 차례인가를 확인하고 적용해야한다.
            if(last_truckidx < truck_weights.length-1){
                int sum_trucks = 0; // 다리에 있는 트럭 무게
                int size_trucks = queue.size(); // 다리에 있는 트럭의 길이
                for(int x : queue)
                    sum_trucks +=truck_weights[x];
                // 맨 앞 트럭의 시간이 다리길이를 다 건넜으면
                if(seconds[first_truckidx]==bridge_length) {
                    sum_trucks -= truck_weights[queue.peek()];
                    size_trucks--;
                }
                // System.out.println("다음 들어갈 자리의 합 " + sum_trucks);
                // 1. 다리가 버틸수 있는 무게이다 2. 자리가 있다 ( 큐 사이즈가 다리 길이보다 작거나 맨앞 큐가 나감)
                if( (sum_trucks + truck_weights[last_truckidx+1]) <= weight 
                   && size_trucks<bridge_length){
                    last_truckidx++;
                    queue.add(last_truckidx); // 트럭 추가 및 last_truckidx + 1
                }
            }
            
        }
        return answer;
    }
}