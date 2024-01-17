// 규칙을 찾아야할 것 같다.

// n=1
// [[1,3]] -> 1만들기

// n=2
// [[1,2], -> 1만들기
// [1,3],[2,3]] -> 2만들기

// n=3
// [[1,3] -> 1만들기
// [1,2],[3,2],  -> 2만들기
// [1,3],[2,1],[2,3],[1,3]] -> 3만들기

// n=4
// [[1,2], -> 1만들기
// [1,3],[2,3], -> 2만들기
// [1,2],[3,1],[3,2],[1,3], -> 3만들기
// [2,3],[2,1],[3,1],[2,3],[1,2][1,3],[2,3]] -> 4만들기

import java.util.List;
import java.util.ArrayList;

class Solution {
    List<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        int[][] answer = {};
        hanoi(1,3,2,n);
        answer = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            answer[i]  = list.get(i);
        }
        return answer;
    }
    public void hanoi(int from,int to,int via,int n){
        int[] way = {from,to};
        if(n==1){
            list.add(way);
        }else{
            hanoi(from,via,to,n-1);
            list.add(way);
            hanoi(via,to,from,n-1);
        }
    }
}