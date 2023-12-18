import java.util.Set;
import java.util.HashSet;

class Solution {
    public Set<Integer> set = new HashSet<>();
    public int solution(int[] elements) {
        int answer = 0;
        for(int i=1;i<=elements.length;i++){// 길이가 1 부터 전체 배열 길이 수까지
            for(int j=0;j<elements.length;j++){//시작 지점
                int cnt = 0;
                int sum = 0;
                while(cnt<i){
                    sum += elements[(j+cnt) % elements.length];
                    cnt++;
                }
                set.add(sum);
            }
            
        }
        answer = set.size();
        // System.out.println(set);

        return answer;
    }
}