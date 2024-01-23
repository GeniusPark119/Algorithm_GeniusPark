import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        int n = 0;
        int cnt = 0;
        
        for(int i=0;i<citations.length;i++){
            n = citations[i];
            cnt = citations.length - i;
            if(cnt<=n){
                answer = cnt;
                break;
            }
        }
        return answer;
    }
}