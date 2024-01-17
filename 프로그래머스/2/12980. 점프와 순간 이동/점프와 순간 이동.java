// 완전탐색을 하는것 같기도하고 규칙을 찾는것 같기도하다. 더 확률이 높은건 규칙찾기인데

public class Solution {
    public int solution(int n) {
        int ans = 0;
        int num = n;
        
        while(num!=0){
            if(num%2!=0){
                ans += 1;
                num-=1;
            }
            while(num!=0 && num%2==0){
                num /=2;
            }
        }


        return ans;
    }
}