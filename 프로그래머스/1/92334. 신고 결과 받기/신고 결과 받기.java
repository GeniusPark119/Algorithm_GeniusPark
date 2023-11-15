import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


class Solution {
    private Map<String,HashSet<String>> whoreport = new HashMap<>(); // 신고 당한 유저에 신고한 유저들을 저장한다.
    private Map<String,Integer> mailcnt =  new HashMap<>(); // 아이디별로 메일받는 수를 저장한다.
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        for(String rep : report){
            String[] ids = rep.split(" ");
            String reporter = ids[0];
            String reported = ids[1];
            
            whoreport.put(reported,whoreport.getOrDefault(reported, new HashSet<String>(){{
                add(reporter);
            }}));
            whoreport.get(reported).add(reporter);
        }
        for(String id : id_list){
            mailcnt.put(id,0);
        }
        for(Entry<String,HashSet<String>> entry : whoreport.entrySet()){
            String reported = entry.getKey();
            HashSet<String> set = entry.getValue();
            if (set.size()>=k) {
                Iterator<String> iter = set.iterator();
                while(iter.hasNext()){
                    String id = iter.next();
                    mailcnt.put(id,mailcnt.getOrDefault(id,0)+1);
                }
            }
        }
        for(int i=0;i<id_list.length;i++){
            answer[i] = mailcnt.get(id_list[i]);
        }
        return answer;
    }
}