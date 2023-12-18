class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        answer = new int[arr1.length][arr2[0].length];
        
        for(int i=0;i<arr1.length;i++){ // 세로 열
            for(int j=0;j<arr2[0].length;j++){
                int tmp = 0;
                for(int k=0;k<arr1[0].length;k++){
                    tmp += arr1[i][k]*arr2[k][j];
                }
                answer[i][j] = tmp;
            }
        }
        return answer;
    }
}