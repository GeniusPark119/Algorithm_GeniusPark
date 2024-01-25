// n 보다 큰 자연수
// 2진수로 변환했을 때 1의 갯수가 같다.
// 가장 작은수

class Solution {
    public int solution(int n) {
        int answer = 0;
        int cntOne1 = findCntOne(n);
        while(true){
            n++;
            int cntOne2 = findCntOne(n);
            if(cntOne2==cntOne1) {
                answer = n;
                break;
            }
        }
        return answer;
    }
    public int findCntOne(int s){
        int cntOne = 0;
        String bin = Integer.toBinaryString(s);
        for(int i=0;i<bin.length();i++){
            if(bin.charAt(i)=='1') cntOne++;
        }
        return cntOne;
    }
}