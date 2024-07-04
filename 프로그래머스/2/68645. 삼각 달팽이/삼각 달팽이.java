import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        
        final int M = n* (n+1)/2; // 달팽이에 채워질 숫자의 개수
        int[][] triangle = new int[n][]; // 숫자를 채워넣을 배열
        for(int i=0;i<n;++i){
            triangle[i] = new int[i+1];
        }
        
        int num = 1; // 현재 채울 숫자
        int mode = 0; // 삼각형의 어느면을 채우고 있는지 (0:왼쪽, 1:아래쪽,2:오른쪽)
        int cnt = n--; // 현재 면에 채울 숫자의 수
        
        int i=0,j=0; // triangle 배열에 수를 채울 위치
        
        while(num<=M){
            triangle[i][j] = num++; // 수를 채우자!
            //이번 숫자를 채우면서 현재 면에 채울 숫자를 다 만족했다면 다른 면을 채우도록 바꿔주자
            if(--cnt==0){
                mode = (mode+1)%3;
                cnt = n--;
            }
        
        // 어느 면을 채울지에 따라서 다음 숫자를 채울 triangle 배열의 위치를 조정
            switch(mode){
                case 0:
                    ++i;
                    break;
                case 1:
                    ++j;
                    break;
                case 2:
                    --i;
                    --j;
                    break;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int[] r : triangle){
            for(int c : r)
                list.add(c);
        }

        return list.stream().mapToInt(x -> x).toArray();
    }
}