class Solution {
    
    int[] numbers;
    int[] now;
    int target;
    boolean[] visited; // 양수 방문처리
    boolean[] visited_minus; // 음수 방문처리
    int answer = 0;
    int sum = 0; // 현재 숫자
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        visited = new boolean[numbers.length];
        visited_minus = new boolean[numbers.length];
        now = new int[numbers.length];
        dfs();
        
        return answer;
    }
    
    public void dfs(){
        
        for(int i=0;i<numbers.length;i++){
            if(visited[i] || visited_minus[i]) continue;
            
            now[i] = numbers[i];
            visited[i] = true;
            dfs();
            visited[i] = false;

            now[i] = numbers[i]*(-1);
            visited_minus[i] = true;
            dfs();
            visited_minus[i] = false;
            return;
        }
        
        for(int x : now){
            // System.out.print(x+" ");
            sum +=x;
        }
        // System.out.println();
        // System.out.println("sum "+sum);
        if(sum == target) answer++;
        sum=0;
        
    }
}