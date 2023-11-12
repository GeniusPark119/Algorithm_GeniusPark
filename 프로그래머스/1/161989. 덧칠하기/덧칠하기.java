class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int start = section[0];
        int end = start + m - 1;
        for(int x : section){
            if(end<x){
                answer++;
                start = x;
                end = x+m-1;
            }
        }

        
        return answer;
    }
}