import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    int cntCards;
    boolean[] visited;
    List<Integer> list;
    public int solution(int[] cards) {
        cntCards = cards.length;
        visited = new boolean[cards.length];
        list = new ArrayList<>();
        findGroup(cards);
        if(list.size() == 1) return 0;
        else{
            list.sort(Comparator.reverseOrder());
            return list.get(0)*list.get(1);
        }
    }
    public void findGroup(int[] cards){
        int groupCnt = 0;
        int now = 0;
        for(int i=0;i<cards.length;i++){
            groupCnt = 0;
            now = 0;
            if(!visited[i]){
                visited[i] = true;
                groupCnt++;
                now = cards[i]-1;
                while(!visited[now]){
                    groupCnt++;
                    visited[now] = true;
                    now = cards[now]-1;
                }

                list.add(groupCnt);
            }
        }
    }
}