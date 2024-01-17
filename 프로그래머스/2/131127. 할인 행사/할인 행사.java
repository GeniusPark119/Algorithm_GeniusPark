// 회원권 지불하면 10일동안 혜택을 받을 수 있음
// 매일 한가지 제품을 할인하는 행사를 한다.
// 내가 원하는거랑 10일동안 할인하는 제품이 정확히 일치해야 회원가입할거임

import java.util.Map;
import java.util.HashMap;

class Solution {
    Map<String , Integer> map = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i=0; i < discount.length ; i++){
            if(i>=10){
                map.put(discount[i-10],map.getOrDefault(discount[i-10],1)-1);
                if(map.get(discount[i-10])==0) map.remove(discount[i-10]);
            }
            map.put(discount[i],map.getOrDefault(discount[i],0)+1);
            // System.out.println(map);
            if(map.size()==want.length){
                boolean join = true;
                for(int j=0;j<want.length;j++){
                    if(!(map.containsKey(want[j]) && map.get(want[j])==number[j])){
                        join = false;
                        break;
                    }
                        
                }
                if(join) answer++;
            }
        }
        return answer;
    }
}