// 231217 11시 25분
// 2차원 배열 완성하는 함수
// 1차원 배열 완성하는 함수
// left~right 자르는 함수
// 위에 대로 하면 메모리 초과
// left 부터 right 까지 n으로 나눠준다. 몫 과 나머지는 2차원배열의 좌표가 된다.
// n-1부터 0까지 큰 순서대로 몫 혹은 나머지가 해당 수를 가지면 그 좌표는 해당수+1이 된다.

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = {};
        answer = new int[(int)(right-left+1)];
        int idx = 0;
        for(long i=left;i<=right;i++){
            long div = i/n;
            long last = i%n;
            // System.out.println("div "+div+"last "+last);
            answer[idx++] = (int)Math.max(div,last)+1;
        }
        
        return answer;
    }
}