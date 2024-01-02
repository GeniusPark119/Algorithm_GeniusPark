import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Arrays;

class Solution {
    Map<String,Integer> map_time = new TreeMap<>(); // 주차 시간을 저장해 놓는 map_time
    
    static int basicTime,basicFee,standardTime,standardFee;
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        basicTime = fees[0];
        basicFee = fees[1];
        standardTime = fees[2];
        standardFee = fees[3];
        
        for(String x : records){
            String[] record = x.split(" ");
            int inOut = record[2].equals("IN")? -1 : 1;
            map_time.put(record[1],map_time.getOrDefault(record[1],0)+getTime(record[0])*inOut);
        }
        
        for(Entry<String,Integer> entry : map_time.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(value<=0)
            map_time.put(key,value+getTime("23:59"));
                
        }

        answer = new int[map_time.size()];
        int idx = 0;
        for(Entry<String,Integer> entry : map_time.entrySet()){
            answer[idx++] = getFee(entry.getValue());
        }
        
        return answer;
    }
    
    public int getTime(String StrTime){ // 00:00 형태를 분으로 계산하는 메서드
        String[] time = StrTime.split(":");     
        return Integer.valueOf(time[0])*60+Integer.valueOf(time[1]);   
    }
    
    public int getFee(int time){ // 요금 구하는 메서드
        if(time<=basicTime) 
            return basicFee;
        else{
            return basicFee + (int)(Math.ceil((double)(time - basicTime)/standardTime))
                *standardFee;
        }
    }
}