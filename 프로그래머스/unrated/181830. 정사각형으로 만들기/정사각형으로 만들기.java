class Solution {
    public int[][] solution(int[][] arr) {
        int[][] answer = {};
        int leny = arr.length;
        int lenx = arr[0].length;
        answer = new int[Math.max(leny,lenx)][Math.max(leny,lenx)];
        if(leny==lenx){
            answer = arr;
        }else if(leny>lenx){
            for(int i=0;i<leny;i++){
                for(int j=0;j<lenx;j++){
                    answer[i][j] = arr[i][j];
                }
                for(int j=lenx ; j<leny;j++){
                    answer[i][j] = 0;
                }
            }
        }else if(leny<lenx){
            for(int i=0;i<leny;i++){
                for(int j=0;j<lenx;j++){
                    answer[i][j] = arr[i][j];
                }
            }
            for(int i=leny;i<lenx;i++){
                for(int j=0;j<lenx;j++){
                    answer[i][j]=0;
                }
            }
        }
        return answer;
    }
}