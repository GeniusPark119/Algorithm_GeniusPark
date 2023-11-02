// class Solution {
//     public int[] idxnum;
//     public int solution(int[] array) {
//         int answer = 0;
//         idxnum = new int[1000];
//         for(int a : array){
//             idxnum[a]++;
//         }
//         int max1cnt = 0;
//         int max1num = 0;
//         int max2cnt = 0;
//         int max2num = 0;
//         for(int i=0;i<idxnum.length;i++){
//             if(idxnum[i]>max1cnt){
//                 max1cnt = Math.max(max1cnt,idxnum[i]);
//                 max1num = i;
//             }
//         }
//         idxnum[max1num]-=1;
//         for(int i=0;i<idxnum.length;i++){
//             if(idxnum[i]>max2cnt){
//                 max2cnt = Math.max(max2cnt,idxnum[i]);
//                 max2num = i;
//             }
//         }
//         if(max1cnt==max2cnt){
//             answer = -1;
//         }else{
//             answer = max1num;
//         }
        
        
//         return answer;
//     }
// }

import java.util.*;
class Solution {
    public int solution(int[] array) {
        int maxCount = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int number : array){
            int count = map.getOrDefault(number, 0) + 1;
            if(count > maxCount){
                maxCount = count;
                answer = number;
            }
            else  if(count == maxCount){
                answer = -1;
            }
            map.put(number, count);
        }
        return answer;
    }
}