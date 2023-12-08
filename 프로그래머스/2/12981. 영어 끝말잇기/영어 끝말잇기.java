// n개 단위로 끊어서 words 배열을 2차원배열로 만들어준다.
// 직전의 마지막 문자를 저장하는 char before 변수를 만들고 첫째 문자와 같은지 확인한다.
// 또한 ArrayList를 만들어서 contains로 이미 나온 문자인지 확인하고 아니면 추가해준다.
// 틀린 지점에서의 int[차례][사람번호] 로 구분해서 result배열 {사람번호,차례}를 지정해준다.

// 배열을 n개 단위로 끊는 법? 
import java.util.List;
import java.util.ArrayList;

class Solution { // 13:34(231208) 
    String[][] words_seq;
    List<String> list = new ArrayList<>();
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        words_seq = words.length%n==0? new String[words.length/n][n] : new String[words.length/n+1][n];
        answer = new int[2];
        for(int i=0;i<words.length;i++){
            words_seq[i/n][i%n] = words[i];
        }

        char before = words[0].charAt(words[0].length()-1);
        
        loop:
        for(int i=0;i<words_seq.length;i++){
            for(int j=0;j<n;j++){
                 String str = words_seq[i][j];
                
                if(i==0&&j==0) {
                    list.add(str);
                    continue;
                }
               
                if(str==null) break loop;
                if(str.charAt(0)==before && !list.contains(str)){
                    before = str.charAt(str.length()-1);
                    list.add(str);
                }else{
                    answer[0] = j+1;
                    answer[1] = i+1;
                    break loop;
                }
            }
        }
        

        return answer;
    }
}