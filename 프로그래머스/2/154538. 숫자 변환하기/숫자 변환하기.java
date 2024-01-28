class Solution{
    public int solution(int x,int y,int n){
        int[] dp = new int[y+1];
    
        for(int i=x;i<y+1;i++){
            if(i!=x && dp[i]==0){
                dp[i] = -1;
                continue;
            }
        
            if(i*2 <=y){
                dp[i*2] = (dp[i*2]==0)? dp[i]+1 :Math.min(dp[i]+1,dp[i*2]);
            }
            if(i*3 <=y){
                dp[i*3] = (dp[i*3]==0)? dp[i]+1 : Math.min(dp[i]+1,dp[i*3]);
            }
            if(i+n<=y){
                dp[i+n] = (dp[i+n]==0)? dp[i]+1 : Math.min(dp[i]+1,dp[i+n]);
            }
        }
        return dp[y];
    }
}




//x에 3가지 경우의 수로 나눠서 연산을 한다.
// 연산을 하는 도중 y를 초과하는 값이 나오면 해당 bfs는 중단한다.
// 연산이 y가 되면 종류하고 연산횟수를 return
// 모든 경우의 수가 y를 초과하면 -1 return

// class Solution {
//     int n,y;
//     int answer = Integer.MAX_VALUE;
//     boolean isExist;
//     public int solution(int x, int y, int n) {
//         this.n = n;
//         this.y = y;
//         if(x==y) return 0;
//         makeY(x,0);
//         if(!isExist) return -1;
//         return answer;
//     }
//     public void makeY(int now,int dep){
//         if(now+n==y||now*2==y||now*3==y){
//             isExist = true;
//             answer = Math.min(answer,dep+1);
//         }else{
//             if(now+n<y){
//                 makeY(now+n,dep+1);
//             }
//             if(now*2<y){
//                 makeY(now*2,dep+1);
//             }
//             if(now*3<y){
//                 makeY(now*3,dep+1);
//             }
//         }
//     }
// }