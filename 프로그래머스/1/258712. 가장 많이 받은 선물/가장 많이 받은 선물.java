import java.util.*;

class Solution { // 20240610 12:20
    public int solution(String[] friends, String[] gifts) {
        int cntF = friends.length;
        
        Map<String,Integer> friendIdx = new HashMap<>(); // 친구 이름과 idx 저장
        
        for(int i=0;i<cntF;i++){
            friendIdx.put(friends[i],i);
        }
        
        int[][] board = new int[cntF][cntF]; // 주는 친구 idx 에서 받는 친구 idx에게 주는 선물 저장
        int[] giftPer = new int[cntF]; // 선물지수 저장
        for(String gift : gifts){ 
            String[] giveNTake = gift.split(" ");
            int giverIdx = friendIdx.get(giveNTake[0]); 
            int takerIdx = friendIdx.get(giveNTake[1]);
            
            board[giverIdx][takerIdx]++; // board
            giftPer[giverIdx]++; // 주는사람 선물지수 1 상승
            giftPer[takerIdx]--; // 받는사람 선물지수 1 하락
        }
        
        int answer = 0; // 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수
        
        // boolean[][] visited = new boolean[cntF][cntF];
        
        for(int i=0;i<cntF;i++){
            
            int nextTake = 0;
            
            for(int j=0;j<cntF;j++){
                if(i==j) continue; // 자기 자신은 넘어간다.
                // 내가 친구보다 더 많이 줬거나 선물지수가 높으면 받는다.
                if((board[i][j]>board[j][i])||(board[i][j]==board[j][i] && giftPer[i]>giftPer[j])) nextTake++;
                    
            }
            
            answer = Math.max(answer,nextTake);
        }
        
        return answer;
    }
}

// 선물 지수를 저장해야함 , 서로 어떻게 주고 받았는지 저장해야함
// a b c d 

// a b
// a c
// a d
// b c
// b d
// c d 
// 2차원배열을 만들어서 friends의 idx를 기준으로 c 준 사람 r 받은 사람 으로 선물을 저장한다.
// 1차원배열을 만들어서 선물지수를 저장한다.
// 2차원배열을 기반으로 받은거 준거를 계산하고 선물지수를 확인해서 받을 선물을 차곡차곡 저장한다.
// visited로 방문처리하면 될듯?