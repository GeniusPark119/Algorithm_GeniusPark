// 1번째일 때 1
// 1%3 = 1;  
// 2번째일 때 2
// 2%3 = 2; 
// 3번째일 때 4
// 3%3 = 0;
// 4번째일 때 11
// 4%3 = 1;
// 1%3 = 1;
// 5번째일 때 12
// 5%3 = 2;
// 1%3 = 1;
// 6번째일 때 14
// 6%3 == 0;
// 1%3 == 1;

class Solution {
    static String[] words = {"4","1","2"};
    public String solution(int n) {
        String answer = "";
        int last = 0;
        
        while(n>0){
            last = n%3;
            answer = words[last] +answer;
            n = n%3==0? n/3-1 : n/3;  
        }
        return answer;
    }
}




//     public void oneTwoFour(int dep){
//         if(hadAns) return;
//         if(dep == x){
//             nowSeq++;
//             if(nowSeq==seq){
//                 answer = sb.toString();
//                 hadAns = true;
//                 return;
//             }
//             dep--;
//             return;
//         }
        
//         for(int i=0;i<3;i++){
//             sb.append(words[i]);
//             oneTwoFour(dep+1);
//             if(sb.length()!=0)
//                 sb.deleteCharAt(sb.length()-1);
//         }
//     }