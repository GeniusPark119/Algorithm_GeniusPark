// 첫번째는 무조건 1번 점프를 한다. 건전지 사용량 1
// 최대한 순간이동으로 이동한다. 1 -> 2 -> 4 -> 8 ....
// 최대한 이동한 시점부터 N까지 점프한 횟수만큼 건전지 사용량 1에서 증가



import java.util.*;

public class Solution {//15:20
    public int solution(int n) {
        int ans = 0;
        while(n!=0){
            if(n%2==0){
                n/=2;
            }else{
                ans++;
                n--;
            }
        }

        return ans;
    }
}