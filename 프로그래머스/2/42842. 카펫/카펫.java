class Solution {
    int sum,mul;
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        sum = (brown+4)/2;
        mul = yellow-4+2*(sum);
        answer = new int[2];
        for(int i=1;i<sum;i++){
            if(i*(sum-i)==mul){
                answer[0] = sum-i;
                answer[1] = i;
                break;
            }
        }
        return answer;
    }
}