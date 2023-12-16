//231216 18:50

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

class Solution {
    public Map<Integer,Integer> map = new HashMap<>();
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int minus = tangerine.length - k;
        for(int x : tangerine){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int[] size = new int[map.size()];
        int[] cnt = new int[map.size()];
        int idx = 0;
        for(Entry<Integer,Integer> entry : map.entrySet()){
            size[idx] = entry.getKey();
            cnt[idx] = entry.getValue();
            idx++;
        }
        // for(int i=0;i<map.size();i++){
        //     System.out.print("크기 "+size[i]);
        //     System.out.println(" 개수 "+cnt[i]);
        // }
        int tmp = 0;
        while(minus>0){
            int min = Integer.MAX_VALUE;
            int min_idx = -1;
            
            for(int i=0;i<cnt.length;i++){
                if(cnt[i]!=-1 && min>cnt[i]) {
                    min = cnt[i];
                    min_idx = i;
                }
            }
            if(min<=minus)
                cnt[min_idx] = -1;
            else
                cnt[min_idx] -= minus;
            
            minus -= min;
        }
        
        for(int x : cnt){
            // System.out.print(x+" ");
            if(x!=-1) answer++;
        }
        return answer;
    }
}