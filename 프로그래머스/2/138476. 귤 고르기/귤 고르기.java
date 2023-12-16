//231216 18:50 ~ 19:30

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public Map<Integer,Integer> map = new HashMap<>();
    public int solution(int k, int[] tangerine) {
        
        int answer = 0;
        int minus = tangerine.length - k;
        
        for(int x : tangerine){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        
        List<Integer> list = new ArrayList(map.keySet());
        list.sort((o1,o2)-> map.get(o2)-map.get(o1));
        
        for(Integer key:list){
            k-=map.get(key);
            answer++;
            if(k<=0){
                break;
            }
        }
        return answer;
    }
}