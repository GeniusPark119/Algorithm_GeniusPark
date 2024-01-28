import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    int dep = 0;
    boolean[] visited;
    int[] nums;
    StringBuilder sb;
    Set<Integer> set;
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        
        nums = new int[numbers.length()];
        sb = new StringBuilder();
        set = new HashSet<>();
        
        for(int i=0;i<numbers.length();i++){
            nums[i] = numbers.charAt(i)-'0';
        }
        Arrays.sort(nums);
        
        makeNum(0,"");
        // System.out.println(set);
        
        for(int s : set){
            if(isSosu(s))
                answer++;
        }
        
        return answer;
    }
    public void makeNum(int dep,String str){
        if(dep>nums.length)
            return;
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i] = true;
                set.add(Integer.valueOf(str+nums[i]));
                makeNum(dep++,str+nums[i]);
                visited[i] = false;
                dep--;
            }
        }
    }
    public boolean isSosu(int num){
        
        if(num<=1) return false;
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num%i==0) return false;
        }
        return true;
    }
}