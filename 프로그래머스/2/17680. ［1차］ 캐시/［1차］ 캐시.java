import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public Queue<String> queue = new LinkedList<>();
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize==0){
            return 5*cities.length;
        }
        for(String city : cities){
            
            city = city.toUpperCase();
            
            if(queue.contains(city)){
                answer +=1;
                queue.remove(city);
            }else
                answer+=5;
            
            if(queue.size()==cacheSize) 
                queue.poll();
            
            queue.add(city);
        }
        return answer;
    }
}