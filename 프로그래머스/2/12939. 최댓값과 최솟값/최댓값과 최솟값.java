import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    public String solution(String s) {
        List<Integer> list = new ArrayList<>();
        String answer = "";
        String[] nums = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(String num : nums){
            int number = 0;
            if(num.charAt(0)=='-'){
                number =Integer.valueOf(num.substring(1,num.length()))*(-1);
            }else{
                number = Integer.valueOf(num);
            }
            min = Math.min(min,number);
            max = Math.max(max,number);
        }
        
        answer = ""+min+" "+max;
        
        return answer;
    }
}