import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public Set<Integer> set;
    public int[] solution(String s) {
        int[] answer = {};
        set = new HashSet<>();
        String[] nums = s.replaceAll("[{}]"," ").trim().split(" , ");
        Arrays.sort(nums,(o1,o2)->o1.length()-o2.length());
        answer = new int[nums.length];
        
        int idx = 0;
        
        for (String ss : nums){
            String[] tmp = ss.split(",");
            for(String t : tmp){
                if(set.add(Integer.valueOf(t)))
                    answer[idx++] = Integer.valueOf(t);
            }
        }
        
        
        return answer;
    }
}