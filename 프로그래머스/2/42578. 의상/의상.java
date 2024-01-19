import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    Map<String,Integer> map;
    public int solution(String[][] clothes) {
        int answer = 1;
        map = new HashMap<>();
        
        for(String[] x : clothes){
            String kind = x[1];
            map.put(kind,map.getOrDefault(kind,0)+1);
        }
        

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            answer *= entry.getValue()+1;
        }
        
        return answer-1;
    }
}