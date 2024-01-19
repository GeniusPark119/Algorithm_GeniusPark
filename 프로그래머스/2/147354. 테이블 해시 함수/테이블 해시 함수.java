// 문제 이해 못함
// 첫번째 컬럼은 기본키로서 모든 튜플에 대해 그 값이 중복되지 않도록 보장된다. 
// -> 각 배열의 1번째 원소가 안겹친다는말
// 튜플 정렬 오름차순 "col번째 컬럼(오름)", 동일시 "기본키 컬럼(내림)" 기준
// 정렬 후 i번째 튜플의 각 컬럼값을 i로 나눈 나머지들의 합으로 정의
// row_begin <= i <= row_end
import java.util.Arrays;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int[][] table = new int[data.length][data[0].length];
        Arrays.sort(data,(o1,o2)->o1[col-1]!=o2[col-1]? o1[col-1]-o2[col-1] : 
                                    o2[0]-o1[0]); // 나 개멋있어
        // for(int i=0;i<data.length;i++){
        //     System.out.print(Arrays.toString(data[i]));
        //     System.out.println();
        // }
        for(int i=row_begin ; i<=row_end;i++){
            int sum = 0;
            for(int x : data[i-1]){
                sum += x%i;
            }
            answer ^=sum;
        }
        // for()
        
        return answer;
    }
}