import java.util.Set;
import java.util.HashSet;

class Solution {
    Set<Integer> set;
    public int solution(int[] elements) {
        set  = new HashSet<>();
        for(int i=1;i<=elements.length;i++){
            for(int j=0;j<elements.length;j++){
                int sum=0;
                for(int k=0;k<i;k++){
                    sum +=elements[(j+k)%elements.length];
                }
                set.add(sum);
            }
        }
        int answer = set.size();
        return answer;
    }
}