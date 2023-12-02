// 맨앞 k+1개 중에서 가장 큰 수 앞의 숫자만 제외하고
// 제외한 수의 개수만큼 k서 빼준다.
// 다음 숫자부터 위의 과정을 반복

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] arr = number.toCharArray();
        int start = 0;
        while(k>0){
            int max = -1;
            int max_idx = -1;
            if(start+k == arr.length){ // 만약에 남아있는게 다 지워야하는거면
                for(int i= start ; i<arr.length;i++){
                    arr[i] = ' ';
                }
                break;
            }
            for(int i=start;i<=start+k;i++){
                if(max<arr[i]-'0'){
                    max = arr[i]-'0';
                    max_idx = i;
                }
            } // k+1개 중에 제일큰수와 그 인덱스를 구한다.
            
            for(int i=start;i<max_idx;i++){
                arr[i] = ' ';
            }
            k-=max_idx-start;
            start = max_idx+1;
        }
        for(char c : arr)
            if(c!=' ') sb.append(c);
        answer = sb.toString();
        return answer;
    }
}