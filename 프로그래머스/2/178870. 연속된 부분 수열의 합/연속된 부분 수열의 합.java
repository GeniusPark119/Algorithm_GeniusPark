class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int N = sequence.length;
        int left = 0, right = N; // 답이될 왼쪽 오른쪽
        int tmpL = 0, tmpR = 0; // 탐색중 왼쪽 오른쪽
        
        int sum = 0;

        while(true){
            if(tmpL >= N) break;
            while(tmpR<N && sum<k){
                sum += sequence[tmpR++];
            }
            if(sum==k){
                if(tmpR - tmpL-1 < right - left){
                    right = tmpR-1;
                    left = tmpL;
                }
            }
            sum -= sequence[tmpL];
            tmpL++;
        }
        
        answer = new int[2];
        answer[0] = left;
        answer[1] = right;
        return answer;
    }
}

// class Solution {
//     public int[] solution(int[] sequence, int k) {
        
//         int N = sequence.length;
//         int left = 0, right = N;
//         int sum = 0;
//         for(int L = 0, R = 0; L < N; L++) {
//             while(R < N && sum < k) {
//                 sum += sequence[R++];
//             }
            
//             if(sum == k) {
//                 int range = R - L - 1;
//                 if((right - left) > range) {
//                     left = L;
//                     right = R - 1;
//                 }
//             }
            
//             sum -= sequence[L];
//         }
        
//         int[] answer = {left, right};
        
//         return answer;
//     }
// }