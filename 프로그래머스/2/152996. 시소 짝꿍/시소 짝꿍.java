// 오름차순으로 정렬을한다.
// 나==상대 or 나2 상대3 or 나3 상대4 or 나2 상대4
// 4가지의 경우의 수로 나뉜다.
// 처음부터 map에 나를 저장한다.
// 그후 뒤의 수 2/3 3/4 2/4 가 map에 저장되어있으면 그 저장된 개수를 answer에 저장한다.
// 그럼 애초에 앞에 있는 사람들과 현재 나의 쌍을 더해갈 수 있다.

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    static Map<Double,Integer> map; // 나누기를 더해야해서 double
    public long solution(int[] weights) {
        long answer = 0;
        map = new HashMap<>();
        Arrays.sort(weights);
        
        for(int i=0;i<weights.length;i++){
            int now = weights[i];
            
            double a = (double)now*1.0;
            double b = (double)now*2.0/3;
            double c = (double)now*2.0/4;
            double d = (double)now*3.0/4;
            
            // System.out.println(a+" "+b+" "+c+" "+d);
            // System.out.println(map);
            
            
            if(map.containsKey(a)) answer += map.get(a);
            if(map.containsKey(b)) answer += map.get(b);
            if(map.containsKey(c)) answer += map.get(c);
            if(map.containsKey(d)) answer += map.get(d);
            
            map.put(a,map.getOrDefault(a,0)+1);
            
        }
        return answer;
    }
}