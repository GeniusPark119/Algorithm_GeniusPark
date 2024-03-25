// 한 곡괭이당 5번 사용이 가능하다. ( 다이아몬드 철 돌)
// 한번 시작한 곡괭이는 5번 연달아 사용해야한다.
// 광물은 순서대로 캘 수 있다.
// 될때까지만 광물을 캔다.다 캘수도 있다.

// 곡갱이의 수 picks 광물들의 순서 minerals
// 최소한의 피로도?


// 내생각
// 다이아몬드 다이아몬드 -> 철 -> 돌
// 철은 최대한 다이아몬드 -> 철 -> 돌 
// 돌은 최대한 돌 -> 철 -> 다이아

// minerals를 앞에서부터 5개씩 끊는다. 가치가 높은 순서대로 다이아->철->돌 곡갱이를 쓴다.
// 가치는 다이아3 철2 돌1 이렇게 임의로 대도 된다.
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    int[][] needed;
    List<SomoPick> list;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        needed = new int[][]{{1,1,1},{5,1,1},{25,5,1}};
        list = new ArrayList<>();
        int holeP = picks[0]+picks[1]+picks[2]; // 전체 곡갱이 수

        // list에 각 소모량을 담은 클래스 SomoPick을 저장한다.
        for(int i=0;i<minerals.length;i+=5){
            holeP--;
            int dia = 0;
            int iro = 0;
            int sto = 0;
            for(int j=i;j<i+5;j++){
                if (j>= minerals.length) break;
                int idx = minerals[j].equals("diamond")? 0:
                        minerals[j].equals("iron")? 1:2;
                dia += needed[0][idx];
                iro += needed[1][idx];
                sto += needed[2][idx];

            }
            list.add(new SomoPick(dia,iro,sto));
            if(holeP==0) break;
        }
        // 돌 기준으로 소모량이 높은것부터 우선순위로 정렬한다.
        Collections.sort(list,(o1,o2)-> o2.sto - o1.sto);
        // 리스트에 있는 소모량이 높은 순서대로 dia , iron , stone 곡갱이를 소모한다.
        for(int i =0;i<list.size();i++){
            if(picks[0]>0){
                picks[0]--;
                answer += list.get(i).dia;
            }else if(picks[1]>0){
                picks[1]--;
                answer +=list.get(i).iro;
            }else{
                picks[2]--;
                answer+=list.get(i).sto;
            }
        }



        return answer;
    }
    class SomoPick{ // 각 5번마다 각 곡갱이의 소모량
        int dia = 0;
        int iro = 0;
        int sto = 0;

        public SomoPick(int dia,int iro,int sto){
            this.dia = dia;
            this.iro = iro;
            this.sto = sto;
        }
    }
}
