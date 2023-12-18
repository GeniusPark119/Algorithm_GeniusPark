import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// 입지 않는 경우의수 1를 더한 값의 곱 -1 이다.
// 예를 들어 얼굴-2 상의-3 하의-2 라면 각 입지않는 경우1를 더해 3*4*2를하고 다 안입는경우 1를뺀다

class Solution {
    public Map<String,Integer> map = new HashMap<>();
    public List<Integer> list = new ArrayList<>();
    public int solution(String[][] clothes) {
        int answer = 1;
        for(String[] cloth : clothes){
            String name = cloth[0];
            String kind = cloth[1];
            map.put(kind,map.getOrDefault(kind,1)+1);
        }
        for(Entry<String,Integer> entry : map.entrySet()){
            list.add(map.get(entry.getKey()));
        }
        
        for( int x : list){
            answer*=x;
        }
        
        return answer-1;
    }

}