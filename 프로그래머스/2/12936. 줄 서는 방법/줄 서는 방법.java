import java.util.List;
import java.util.ArrayList;

class Solution {
    List<Integer> list = new ArrayList<>();
    int idx = 0;
    int[] answer;
    public int[] solution(int n, long k) {
        answer = new int[n];
        long cnt = 1;
        for(int i=1;i<=n;i++){ // list에 줄을 세울 사람 번호를 저장해 놓는다.
            // 추후 줄을 세울때마다 해당 번호를 지워 나간다.다 지울때까지 남은 번호를 저장해놓는곳
            // 수가 줄때마다 자동으로 인덱스가 앞당겨져서 오름차순으로 배정하기 좋다.
            list.add(i);// 팩토리얼로 전체 경우의수의 개수를 구한다.
            cnt*=i;
        } 
        
        k--;// 순서로 했을때 0부터 시작한다고 하면 15번째는 0~14번째이다.
        getLine(cnt,n,k);
        return answer;
    }

    public void getLine(long cnt,int n,long k){
        int idx = 0; // answer의 index이다. 
        while(!list.isEmpty()){
            cnt = cnt/(n-idx); // 전체를 나누는 기준
            answer[idx++] = list.remove((int)(k/cnt));
            k %= cnt;
        }
    }
}



// n의 일렬로 줄서는것을 오름차순으로 나열하는 법도 알아두자.
// import java.util.Arrays;
// class Solution {
//     int[] answer;
//     boolean[] visited;
//     long cnt;
//     public int[] solution(int n, long k) {
//         answer = new int[n];
//         visited = new boolean[n];
//         permutation(n, 0,k);
//         return answer;
//     }
//     // n개의 원소를 가진 배열 answer에 차례대로 줄을 세운다.
//     public void permutation(int n, int dep,long k){

//         if(dep==n){
//             cnt++;
//             return;
//         }
        
//         for(int i=0;i<n;i++){
//             if(!visited[i]){
//                 visited[i]= true;
//                 answer[dep] = i+1;
//                 permutation(n,dep+1,k);
//                 if(cnt==k){
//                     return;
//                 }
//                 visited[i] = false;
//             }
//         }
//     }
// }