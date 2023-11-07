import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<Integer> list = new ArrayList<>();
    public int[] solution(int[] arr) {
        
        int[] answer = {};
        for(int i=0;i<arr.length;i++){
            if(i==0||arr[i]!=arr[i-1]){
                list.add(arr[i]);
            }
        }
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }


        return answer;
    }
}