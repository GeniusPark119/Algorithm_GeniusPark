import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
class Solution {
    List<Integer> list;
    public int solution(int[] people, int limit) {
        int answer = 0;
        list = new ArrayList<>();
        Arrays.sort(people);

        for(int i=0;i<people.length;i++){
            if(people[i]==limit){
                answer+=people.length-i;
                break;
                
            }
            list.add(people[i]);
        }
        
        while(!list.isEmpty()){
            if(list.size()==1){
                answer++;
                break;
            }
            if(list.get(0)+list.get(list.size()-1)<=limit){
                answer++;
                list.remove(0);
                list.remove(list.size()-1);
            }else{
                answer++;
                list.remove(list.size()-1);
            }
        }
        
        return answer;
    }
}