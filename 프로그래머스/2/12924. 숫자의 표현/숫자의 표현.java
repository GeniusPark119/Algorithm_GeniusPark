class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1;i<=n;i++){
            int sum = i;
            int plus = i+1;
            while(sum<n){
                sum += plus;
                plus++;
            }
            if(sum==n)
                answer++;
        }
        return answer;
    }
}