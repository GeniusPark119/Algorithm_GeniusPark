class Solution {
    int numbers[];
    int target;
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;
        dfs(0,0);
        
        
        return answer;
    }
    public void dfs(int dep,int sum){
        if(dep==numbers.length) {
            if(sum==target)
                answer++;
            return;
        }
        
        int plus = sum +numbers[dep];
        int minus = sum -numbers[dep];
        
        dfs(dep+1,plus);
        dfs(dep+1,minus);
        
    }
}