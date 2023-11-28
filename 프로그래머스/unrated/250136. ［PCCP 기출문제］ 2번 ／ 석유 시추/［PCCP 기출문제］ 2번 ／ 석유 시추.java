// import java.util.Map;
// import java.util.HashMap;
// import java.util.List;
// import java.util.ArrayList;

// class Solution {
//     public int[][] land;
//     public int[] movea = {1,-1,0,0}; // 사방탐색
//     public int[] moveb = {0,0,1,-1}; // 사방탐색
//     public int area_num = 2; // 지역숫자
//     public Map<Integer,Integer> map = new HashMap<>(); // 땅 숫자에 땅크기 저장
//     public List<Integer> list = new ArrayList<>();
//     public void oil_area(int a,int b){ // 석유 덩어리를 지역숫자로 표기한다. 재귀함수
//         land[a][b] = area_num; // 땅을 땅숫자로 표기한다.
//         map.put(area_num,map.getOrDefault(area_num,0)+1);
//         for(int i=0;i<4;i++){
//             if(a+movea[i]>=0 && a+movea[i]<land.length 
//                && b+moveb[i]>=0&&b+moveb[i]<land[0].length && land[a+movea[i]][b+moveb[i]]==1)
//             oil_area(a+movea[i],b+moveb[i]); // 재귀함수
//         }
//     }
    
//     public int solution(int[][] land) {
//         int answer = 0;
//         this.land = land;
//         for(int i=0;i<land.length;i++){
//             for(int j=0;j<land[0].length;j++){
//                 if(land[i][j]==1) {
//                     oil_area(i,j);
//                     area_num++;
//                 }
                
//             }
//         }
        
//         for(int j=0;j<land[0].length;j++){
//             int sum_oil = 0;
//             for(int i=0;i<land.length;i++){
//                 if(land[i][j]!=0 && !list.contains(land[i][j])) 
//                     sum_oil+=map.get(land[i][j]);
//                     list.add(land[i][j]);
//             }
//             list.clear();
//             answer = Math.max(answer,sum_oil);
//         }
        
        
//         return answer;
//     }
// }


import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] land;
    public int[] movea = {1,-1,0,0}; // 사방탐색
    public int[] moveb = {0,0,1,-1}; // 사방탐색
    public int area_num = 2; // 지역숫자
    public int cnt = 0;
    public Map<Integer,Integer> map = new HashMap<>(); // 땅 숫자에 땅크기 저장
    public List<Integer> list = new ArrayList<>();
    public void oil_area(int a,int b){ // 석유 덩어리를 지역숫자로 표기한다. 재귀함수
        land[a][b] = area_num; // 땅을 땅숫자로 표기한다.
        cnt++;
        // map.put(area_num,map.getOrDefault(area_num,0)+1);
        for(int i=0;i<4;i++){
            if(a+movea[i]>=0 && a+movea[i]<land.length 
               && b+moveb[i]>=0&&b+moveb[i]<land[0].length && land[a+movea[i]][b+moveb[i]]==1)
            oil_area(a+movea[i],b+moveb[i]); // 재귀함수
        }
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        this.land = land;
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(land[i][j]==1) {
                    oil_area(i,j);
                    map.put(area_num,cnt);
                    area_num++;
                    cnt=0;
                }
                
            }
        }
        
        for(int j=0;j<land[0].length;j++){
            int sum_oil = 0;
            for(int i=0;i<land.length;i++){
                if(land[i][j]!=0 && !list.contains(land[i][j])) 
                    sum_oil+=map.get(land[i][j]);
                    list.add(land[i][j]);
            }
            list.clear();
            answer = Math.max(answer,sum_oil);
        }
        
        
        return answer;
    }
}












