import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}
// import java.util.List;
// import java.util.ArrayList;

// class Solution {

//     public List<Integer> list = new ArrayList<>();
//     public int[] checkProgresses;
//     public int[] solution(int[] progresses, int[] speeds) {
//         int[] answer = {};
//         checkProgresses = new int[progresses.length];
//         int next_idx = 0;
//         while(next_idx<progresses.length){
            
//             for(int i=next_idx;i<progresses.length;i++){
//                 progresses[i] += speeds[i];
//             }
            
//             if(progresses[next_idx]>=100){
//                 int cnt_completed = 0;
//                 for(int i=next_idx;i<progresses.length;i++){
//                     if(progresses[i]>=100) {
//                         cnt_completed++;
//                         next_idx++;
//                     }else{
//                         break;
//                     }
//                 }
//                 list.add(cnt_completed);
//             }
            
//         }
        
//         answer = new int[list.size()];
//         for(int i=0;i<list.size();i++){
//             answer[i] = list.get(i);
//         }
        
        
//         return answer;
//     }
// }