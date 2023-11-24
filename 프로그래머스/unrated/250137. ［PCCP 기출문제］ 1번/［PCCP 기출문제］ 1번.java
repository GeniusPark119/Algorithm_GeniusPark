class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int banding_time = bandage[0]; // 시전시간
        int cure = bandage[1]; // 초당 회복량
        int combo = bandage[2]; // 추가 회복량
        
        int start = attacks[0][0]; // 공격시작시간
        int end = attacks[attacks.length-1][0]; // 공격끝시간
        
        int[] attack_arr = new int[end+1]; // 공격 기간
        for(int[] a : attacks){
            attack_arr[a[0]] = a[1]; // 공격 시간 idx 에 피해량 저장
        }
        
        int now_health = health;
        int cnt_cure = 0;
        
        for(int i=start;i<=end;i++){
            if(attack_arr[i]==0){
                if(now_health<health && cnt_cure < banding_time) {
                    now_health += cure;
                    cnt_cure++;
                }
                if(cnt_cure==banding_time) now_health +=combo;
                if(now_health>health) now_health = health;
            }else{
                now_health -= attack_arr[i];
                cnt_cure = 0;
                if(now_health<=0) return -1;
            }
        }
        
        answer = now_health;
            
        return answer;
    }
}