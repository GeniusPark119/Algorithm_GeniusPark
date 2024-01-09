import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution { // 2024/1/9 14:50 시작
    static int depth = 0;
    static boolean[] visited;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];

        nums = new int[numbers.length()];
        for(int i=0;i<numbers.length();i++){
            nums[i] = numbers.charAt(i)-'0';
        }
        
        Arrays.sort(nums);
        
        makeNum(0,"");
        
        // System.out.println(set);
        
        for(int s : set){
            if(isSosu(s)) answer++;
        }
        
        return answer;
    }
    //숫자조합 메서드
    public void makeNum(int depth,String str){
        if(depth > nums.length ) {
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]) {
                visited[i] = true; 
                set.add(Integer.valueOf(str+nums[i]));
                makeNum(depth++,str+nums[i]);
                visited[i] = false; 
                depth--;
                }
        }
    }
    //소수판별 메서드
    public boolean isSosu(int num){
        if(num<=1) return false;
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num%i==0) return false;
        }
        return true;
    }
}