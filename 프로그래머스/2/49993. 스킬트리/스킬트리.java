// ABC 라고 하면
// B가 나오려면 앞에 A가 나와야하고
// C가 나오려면 앞에 AB가 나와야한다.
// A는 그냥 나올 수 있다. 

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

class Solution{
    public int solution(String skill,String[] skill_trees){
        int answer = 0;
        ArrayList<String> list = new ArrayList<>(Arrays.asList(skill_trees));
        Iterator<String> iterator = list.iterator();
        
        while(iterator.hasNext()){
            if(skill.indexOf(iterator.next().replaceAll("[^"+skill+"]","")) == 0)
                answer++;
        }
        
        return answer;
        
    }
}





// import java.util.Stack;

// class Solution {
//     public Stack<Character> stack;
//     public int solution(String skill, String[] skill_trees) {
//         int answer = 0;
//         String[] removed_trees = new String[skill_trees.length];
        
//         stack = new Stack<>();
        
//         for(int i=0;i<skill_trees.length;i++){
//             removed_trees[i] = skill_trees[i].replaceAll("[^"+skill+"]","");
//         }
        
//         for(String s : removed_trees){
            
//             boolean isRight = true;
            
//             for(int i=0;i<s.length();i++){
//                 char tmp = s.charAt(i);
//                 // System.out.println(tmp);
//                 stack.push(tmp);
//                 // System.out.println(stack);
//                 int seq = 0;
//                 for(int j=0;j<skill.length();j++){
//                     if(skill.charAt(j)==tmp){
//                         seq = j+1;
//                         break;
//                     }
//                 }
//                 if(stack.size()!=seq) {
//                     isRight = false;
//                     break;
//                 }
//             }
//             stack.clear();
//             if(isRight) answer++;
            
//         }
 
//         return answer;
//     }

// }