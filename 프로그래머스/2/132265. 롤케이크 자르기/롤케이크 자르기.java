import java.util.Map;
import java.util.HashMap;

class Solution {
    Map<Integer,Integer> mine = new HashMap<>(); // 소정이의 롤케이크
    Map<Integer,Integer> sister = new HashMap<>(); // 소현이의 롤케이크
    
    public int solution(int[] topping) {
        int answer = 0;
        boolean flag = false;
        for(int x : topping){
            mine.put(x,mine.getOrDefault(x,0)+1);
        }
        // System.out.println(mine);
        for(int i=0;i<topping.length;i++){
            int tmp = topping[i];
            mine.put(tmp,mine.get(tmp)-1);
            if(mine.get(tmp)==0) mine.remove(tmp);
            sister.put(tmp,sister.getOrDefault(tmp,0)+1);
            if(mine.size()==sister.size()) {
                flag = true;
                answer++;
            }else{
                if(flag) break;
            }
        }
        return answer;
    }
}