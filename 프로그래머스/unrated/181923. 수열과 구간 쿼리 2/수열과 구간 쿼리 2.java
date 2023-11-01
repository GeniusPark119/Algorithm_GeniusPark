class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        answer = new int[queries.length];
        int idx = 0;
        for(int[] q : queries){
            int min = -1;
            for(int i= q[0] ; i<= q[1] ; i++){
                if(arr[i]>q[2]){
                    if(min==-1) 
                        min = arr[i];
                    else
                        min = Math.min(arr[i],min);
                }
            }
            answer[idx++] = min;
        }
        return answer;
    }
}