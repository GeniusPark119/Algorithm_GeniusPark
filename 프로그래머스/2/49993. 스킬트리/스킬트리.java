class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0;i<skill_trees.length;i++){
            if(skill.indexOf(skill_trees[i].replaceAll("[^"+skill+"]",""))==0)
                answer++;
        }
        return answer;
    }
}