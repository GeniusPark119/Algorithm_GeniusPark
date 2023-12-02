// 요격 미사일은 실수인 x좌표에서도 발사할 수 있습니다.
// 생각나는 방법  1. 요격미사일의 수를 1씩 증가시키면서 모두 막을 수 있는 지 확인하기
// Greedy Algorithm으로 풀어야한다. 최선의 선택

import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(a,b)->a[1]-b[1]); // e를 기준으로 오름차순 정렬
        
        int shortest=-1;
        
        for(int[] target : targets){
            if(target[0]<=shortest) continue;
            shortest = target[1]-1;
            answer++;
        }
        
        
        return answer;
    }
}