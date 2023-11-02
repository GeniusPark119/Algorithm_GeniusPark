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

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Set;
class Solution {
    public Map<Integer,Integer> map = new HashMap<>();
    public int solution(int[] array) {
        int answer = 0;
        for(int num : array){
            if(map.containsKey(num))
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);
        }
        int maxV = 0;
        int maxK = 0;
        for(Entry<Integer,Integer> entry : map.entrySet()){
            if(maxV<entry.getValue()){
                maxV = entry.getValue();
                maxK = entry.getKey();
            }else if(maxV==entry.getValue()){
                maxK = -1;
            }
        }
        answer = maxK;
        return answer;
    }
}