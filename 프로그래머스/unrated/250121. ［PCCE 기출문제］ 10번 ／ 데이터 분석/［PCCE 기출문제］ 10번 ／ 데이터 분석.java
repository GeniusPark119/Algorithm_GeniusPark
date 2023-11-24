import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<Integer> list = new ArrayList<>();
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        int ext_idx = 0;
        int sort_idx = 0;
        
        if(ext.equals("date")) ext_idx = 1;
        else if(ext.equals("maximum")) ext_idx=2;
        else if(ext.equals("remain")) ext_idx=3;
        
        if(sort_by.equals("date")) sort_idx = 1;
        else if(sort_by.equals("maximum")) sort_idx=2;
        else if(sort_by.equals("remain")) sort_idx=3;
        
        
        for(int[] d :data){
            if(d[ext_idx]<val_ext) list.add(d[sort_idx]);
        }
        
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        answer = new int[list.size()][4];
        int ans_idx = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<data.length;j++){
                if(arr[i]==data[j][sort_idx]) answer[ans_idx++] = data[j];
            }
        }
        
        return answer;
    }
}