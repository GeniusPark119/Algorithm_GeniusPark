import java.util.TreeMap;

class Solution {
    public TreeMap<Integer,Integer> map = new TreeMap<>();
    public int[] solution(int[] numlist, int n) {
        int len = numlist.length;
        int[] answer = new int[len]; // 인덱스순으로 정렬한 답
        int[] gaparr = new int[len]; // 거리
        int[] idx = new int[len];    // 각 인덱스
        
        for(int i=0;i<len;i++){ // 순서대로 거리를 저장한다.
            int gap = (int)Math.abs(numlist[i]-n);
            gaparr[i] = gap;
            // System.out.print(gap+" ");
        
        }
        
            // System.out.println();



        for(int i=0;i<len;i++){// 순서대로 거리를 반영한 인덱스를 저장한다.
            int num = 1;
            for(int j=0;j<len;j++){
                if(i==j) continue;
                
                if(gaparr[i]>gaparr[j]) 
                    num++;
                else if(gaparr[i]==gaparr[j] && numlist[i]<numlist[j]) 
                    num++;
  
            }
            idx[i] = num-1;
            // System.out.print(idx[i]+" ");
        }
        
        
        for(int i=0;i<numlist.length;i++){//인덱스에 해당 num을 저장한다.
            answer[idx[i]] = numlist[i];
        }
        
        return answer;
    }
}