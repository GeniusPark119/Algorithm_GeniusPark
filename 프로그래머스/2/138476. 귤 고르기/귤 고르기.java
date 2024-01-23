//11:36

import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Arrays;

class Solution {
    Map<Integer,Integer> map;
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        map  = new HashMap<>();
        
        // map에 귤의 크기당 몇개씩 있는 지 구한다.
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        // 크기별로 묶어진 귤의 개수를 담는 배열을 만든다.
        int[] cntArr = new int[map.size()];
        int idx = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            cntArr[idx++] = entry.getValue();
        }
        // 크기별 개수를 오름차순으로 정렬한다.
        Arrays.sort(cntArr);
        // System.out.println(Arrays.toString(cntArr));
        // 오름차순대로 개수를 저장하면서 전체 - minus가 k가 될때까지 한다.
        int minus = 0;
        for(int i=0;i<cntArr.length;i++){
            // System.out.println(i);
            minus += cntArr[i];
            // System.out.println("귤"+(tangerine.length-minus));
            if(tangerine.length-minus<k){
                answer = cntArr.length - i;
                break;
            }else if(tangerine.length-minus==k){
                answer = cntArr.length - i-1;
                break;
            }
        }
        // System.out.println(map);
        
        return answer;
    }
}