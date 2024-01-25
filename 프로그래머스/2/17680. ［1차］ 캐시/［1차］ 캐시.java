import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> list; // list를 만들고 순차적으로 도시를 넣는다.
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        list = new ArrayList<>();
        for(String city : cities){ // cities를 순회한다.
            city = city.toLowerCase(); // 모두 소문자로 바꾼다.
            if(list.size()==0){ // 만약 list에 아무것도 없으면 5를 더하고 list에 추가한다.
                answer+=5;
                if(cacheSize!=0)
                    list.add(city);
                continue;
            }
            if(list.contains(city)){ //만약 list에 city가 있다면
                answer++; //1만 더하고
                list.remove(city); // 해당 city를 빼고 다시 더한다.
                list.add(city);
            }else{
                if(list.size()<cacheSize){ // 만약 city가 없다면 size가 적다면 추가하고 5를 내고
                    list.add(city);
                    answer+=5;
                }else{ // size가 다 찾으면 첫번째를 빼고 지금걸 더한후 5를 더한다.
                    list.remove(0);
                    list.add(city);
                    answer+=5;
                }
            }
        }
        return answer;
    }
}