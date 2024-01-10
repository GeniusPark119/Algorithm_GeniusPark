// 두번째 행부터 각 행마다 열별로 최대값을 찾는다. 
// 예) 이번 행의 1열이라면 이전행 2~4열중의 최대값을 더한다. 
// 이전 행과 이번행의 합이 최대가 되는 값을 각 열마다 입력하고 마지막행까지 반복한다.
// 마지막행에서 제일 큰 수가 답이다.
class Solution {
    int solution(int[][] land) {
        for(int i=1;i<land.length;i++){
            land[i][0] += Math.max(Math.max(land[i-1][1],land[i-1][2]),land[i-1][3]);
            land[i][1] += Math.max(Math.max(land[i-1][2],land[i-1][0]),land[i-1][3]);
            land[i][2] += Math.max(Math.max(land[i-1][1],land[i-1][0]),land[i-1][3]);
            land[i][3] += Math.max(Math.max(land[i-1][1],land[i-1][2]),land[i-1][0]);
        }
        
        int len = land.length-1;
        
        return Math.max(Math.max(land[len][1],land[len][2]),
                        Math.max(land[len][3],land[len][0]));
    }
}