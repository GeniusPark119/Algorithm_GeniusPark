import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/// limit 이하인 사람들을 따로 모아서 정렬한다.
// 가장작은사람이랑 큰사람을 연결지어본다. 그럼 안될때도 있다.
// 50 50 70 80 작은수부터 더했을때 limit이 되는 수중 가장 큰수 제외

class Solution {
    public List<Integer> list = new ArrayList<>();
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        for(int i=0;i<people.length;i++){
            if(people[i]==limit) {
                answer +=people.length - i;
                break;
            }
            list.add(people[i]);
        }
        // System.out.println(list);//print
        // System.out.println(answer); // print
        
         while(list.size()>0){
              // System.out.println(list);//print
            if(list.size()==1) {
                answer++;
                break;
            }
            int p1 = list.get(0);
            int p2 = list.get(list.size()-1);
        
            if(p1+p2>limit){
                answer+=1;
                list.remove(list.size()-1);
            }else{
                answer+=1;
                list.remove(0);
                list.remove(list.size()-1);
            }
            
        }
        return answer;
    }
    
  
    
}