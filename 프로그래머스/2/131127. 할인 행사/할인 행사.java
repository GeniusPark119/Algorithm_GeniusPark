import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int dis_len = discount.length; // 전체 할인날의 수
        int start = 0;
        int end = 10;
        int[] checkWant;
        while(end<=dis_len){//전체 할인날을 10일로 끊는 경우의수
            checkWant = new int[want.length];
            String[] arr_ten = Arrays.copyOfRange(discount,start,end);
            boolean isContains = true;
            for(int i=0;i<want.length;i++){
                for(String one : arr_ten) {
                    if(want[i].equals(one)) checkWant[i]++;
                }
            }
            for(int i=0;i<want.length;i++){
                if(number[i] !=checkWant[i]){
                    isContains = false;
                    break;
                }
            }
            start++;
            end++;
            if(!isContains) continue;
            else answer++;
        }
        
        return answer;
    }
}