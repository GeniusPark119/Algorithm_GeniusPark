// 4시 49분
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int before = arr[0];
        for(int i=1;i<arr.length;i++){
            before = before*arr[i]/gcd(before,arr[i]);
        }
        answer = before;
        return answer;
    }
    public int gcd(int a,int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
}