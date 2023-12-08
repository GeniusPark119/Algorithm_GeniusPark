import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class Solution{//10:30  ~ 13:00 (231208)
    public Map<String,HashSet<String>> report_map = new HashMap<>(); // ID 별로 신고한 ID들 저장
    public Map<String,Integer> cnt_map = new HashMap<>();
    public List<String> list = new ArrayList<>();
    public int[] solution(String[] id_list,String[] report,int k){
        int[] answer = new int[id_list.length];
        int[] cnt_reported = new int[id_list.length];
        for(String str : report){// ID 별로 신고한 ID들 저장
            String[] arr = str.split(" ");
            String id = arr[0];
            String reported = arr[1];
            if(!report_map.containsKey(id))
                report_map.put(id,new HashSet<String>());
            report_map.get(id).add(reported);
        }
        for(int i=0;i<id_list.length;i++){
            if(report_map.containsKey(id_list[i])){
                for(String str : report_map.get(id_list[i])){
                    cnt_map.put(str,cnt_map.getOrDefault(str,0)+1);
                }
            }
        }//cnt_map에 아이디별 신고당한 횟수를 저장한다.
        
        
        for(int i=0;i<id_list.length;i++){// list에 정지처리된 id 저장
            if(cnt_map.containsKey(id_list[i]) && cnt_map.get(id_list[i])>=k){
                list.add(id_list[i]);
            }
        }
        
        
        for(int i=0;i<id_list.length;i++){
            if(!report_map.containsKey(id_list[i])) continue;
            for(String s : list){
                if(report_map.get(id_list[i]).contains(s)) answer[i]++;
            }
        }
        
        return answer;
    }
}

























// import java.util.Map;
// import java.util.Map.Entry;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Iterator;


// class Solution {
//     private Map<String,HashSet<String>> whoreport = new HashMap<>(); // 신고 당한 유저에 신고한 유저들을 저장한다.
//     private Map<String,Integer> mailcnt =  new HashMap<>(); // 아이디별로 메일받는 수를 저장한다.
//     public int[] solution(String[] id_list, String[] report, int k) {
//         int[] answer = new int[id_list.length];
//         for(String rep : report){
//             String[] ids = rep.split(" ");
//             String reporter = ids[0];
//             String reported = ids[1];
            
//             whoreport.put(reported,whoreport.getOrDefault(reported, new HashSet<String>(){{
//                 add(reporter);
//             }}));
//             whoreport.get(reported).add(reporter);
//         }
//         for(String id : id_list){
//             mailcnt.put(id,0);
//         }
//         for(Entry<String,HashSet<String>> entry : whoreport.entrySet()){
//             String reported = entry.getKey();
//             HashSet<String> set = entry.getValue();
//             if (set.size()>=k) {
//                 Iterator<String> iter = set.iterator();
//                 while(iter.hasNext()){
//                     String id = iter.next();
//                     mailcnt.put(id,mailcnt.getOrDefault(id,0)+1);
//                 }
//             }
//         }
//         for(int i=0;i<id_list.length;i++){
//             answer[i] = mailcnt.get(id_list[i]);
//         }
//         return answer;
//     }
// }