// 17 : 00
class Solution{
    int band_time,heal_second,heal_combo;
    int first_attacktime,last_attacktime;
    int[] timeline;
    int health; // 총 체력 
    public int solution(int[] bandage, int health, int[][] attacks){
        int answer = 0;
        
        // health는 총 체력
        this.health = health;
        
        band_time = bandage[0]; // 붕대 감는 시간
        heal_second = bandage[1]; // 1초당 회복량
        heal_combo = bandage[2]; // 콤보 회복량
        
        first_attacktime = attacks[0][0];
        last_attacktime = attacks[attacks.length-1][0]; // 마지막 공격 타이밍
        
        timeline = new int[last_attacktime+1]; // 게임 시간별 피 차감
        
        for(int i=0;i<attacks.length;i++){
            timeline[attacks[i][0]] = attacks[i][1] * (-1);
        }
        
        
        
        return game_result();
    }
    public int game_result(){
        int combo_now = 0; // 현재 콤보로 쌓인 밴드 시간
        int health_now = health; // 현재 체력
        for(int i=first_attacktime;i<timeline.length;i++){
            if(timeline[i] == 0 && health_now<health){
                combo_now++;
                if(combo_now == band_time) {
                    health_now +=heal_combo;
                    combo_now =0;
                    }
                health_now = health_now+heal_second >= health? 
                    health : health_now+heal_second ;
            }else{
                combo_now = 0;
                health_now += timeline[i];
                if(health_now<=0) return -1;
            }
            // System.out.println("halt "+ health_now);
            // System.out.println("com "+combo_now);
        }
        return health_now;
    }
}











// class Solution {
//     public int solution(int[] bandage, int health, int[][] attacks) {
//         int answer = 0;
//         int banding_time = bandage[0]; // 시전시간
//         int cure = bandage[1]; // 초당 회복량
//         int combo = bandage[2]; // 추가 회복량
        
//         int start = attacks[0][0]; // 공격시작시간
//         int end = attacks[attacks.length-1][0]; // 공격끝시간
        
//         int[] attack_arr = new int[end+1]; // 공격 기간
//         for(int[] a : attacks){
//             attack_arr[a[0]] = a[1]; // 공격 시간 idx 에 피해량 저장
//         }
        
//         int now_health = health;
//         int cnt_cure = 0;
        
//         for(int i=start;i<=end;i++){
//             if(attack_arr[i]==0){
//                 if(now_health<health && cnt_cure < banding_time) {
//                     now_health += cure;
//                     cnt_cure++;
//                 }
//                 if(cnt_cure==banding_time) now_health +=combo;
//                 if(now_health>health) now_health = health;
//             }else{
//                 now_health -= attack_arr[i];
//                 cnt_cure = 0;
//                 if(now_health<=0) return -1;
//             }
//         }
        
//         answer = now_health;
            
//         return answer;
//     }
// }