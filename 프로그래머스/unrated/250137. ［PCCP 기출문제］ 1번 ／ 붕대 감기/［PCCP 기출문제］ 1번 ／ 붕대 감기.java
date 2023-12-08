// 17 : 00
class Solution{
    int band_time,heal_second,heal_bonus; // 시전시간, 1초당 회복량 , 추가 회복량
    int first_attack,last_attack; // 첫번째와 마지막 공격시간
    int health; // 총 체력 
    int[] timeline;
    public int solution(int[] bandage, int health, int[][] attacks){
        int answer = 0;
        
        // health는 총 체력
        this.health = health;
        
        band_time = bandage[0]; // 시전 시간
        heal_second = bandage[1]; // 1초당 회복량
        heal_bonus = bandage[2]; // 추가 회복량
        
        first_attack = attacks[0][0]; // 첫번째 공격 타이밍
        last_attack = attacks[attacks.length-1][0]; // 마지막 공격 타이밍
        
        timeline = new int[last_attack+1];
        
        for(int[] atk : attacks){
            timeline[atk[0]] = atk[1];
        }
        
        
        
        
        return game_result();
    }
    public int game_result(){
        int cnt_band = 0; // 현재 누적으로 쌓인 밴드 시간
        int health_now = health; // 현재 체력
        for(int i=first_attack;i<=last_attack;i++){
            if(timeline[i] == 0 && health_now<health){
                cnt_band++;
                if(cnt_band == band_time) {
                    health_now +=heal_bonus;
                    cnt_band =0;
                    }
                health_now = health_now+heal_second >= health? 
                    health : health_now+heal_second ;
            }else{
                cnt_band = 0;
                health_now -= timeline[i];
                if(health_now<=0) return -1;
            }
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