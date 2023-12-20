//231216 5시 30분 (답 보기)
class Solution {
    public int[] arr;
    public int dp(int n){

        if(arr[n] !=0 ) return arr[n];
        arr[n] = (dp(n-2) + dp(n-1))%1234567;
        return arr[n];
    }
    public long solution(int n) {
        if(n==1) return 1;
        arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        int answer = dp(n);
        return answer;
    }
}