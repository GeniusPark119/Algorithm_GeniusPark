// 예시를 그려보면 원점으로 부터 d가 넘지 않게 그리면 정사각형의 반이된다.
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        long dd = (long)d*d; // 빗변의 제곱
        
        for(int i=0;i<=d;i+=k){ // x축을 기준으로 잡는다.
            long ii = (long)i*i; // x축 제곱
            
            long top = (long)Math.sqrt(dd-ii); // y축 최대값
            
            answer +=top/k +1; //최댓값을 k로 나눠서 가능한 y축값 구하고 0까지 더해야하니 +1
            
        }
        return answer;
    }
}