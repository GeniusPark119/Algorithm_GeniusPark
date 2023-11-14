class Solution {
    public String solution(String new_id) {
        String answer = "";
        answer = new KAKAOID(new_id).
                replaceToLowerCase().
                filter().
                toSingleDot().
                noStartEndDot().
                noBlank().
                noGreaterThan15().
                noLessThan3().
                getResult();
                        
        return answer;
    }
    
    private static class KAKAOID{
        private String s;
        
        KAKAOID(String s){
            this.s = s;
        }
        
        private KAKAOID replaceToLowerCase(){
            s = s.toLowerCase();
            return this;
        }
        
        private KAKAOID filter(){
            s = s.replaceAll("[^a-z0-9._-]","");
            return this;
        }
        private KAKAOID toSingleDot(){
            s = s.replaceAll("[.]{2,}",".");
            return this;
        }
        private KAKAOID noStartEndDot(){
            s = s.replaceAll("^[.]|[.]$","");
            return this;
        }
        private KAKAOID noBlank(){
            if(s.isEmpty()) s = "a";
            return this;
        }
        private KAKAOID noGreaterThan15(){
            if(s.length()>15) {
                s = s.substring(0,15);
                s = s.replaceAll("[.]$","");
            }
            return this;
        }
        private KAKAOID noLessThan3(){
            StringBuilder sb = new StringBuilder(s);
            while(sb.length()<3){
                sb.append(sb.charAt(sb.length()-1));
            }
            s = sb.toString();
            return this;
            
        }
        private String getResult(){
            return s;
        }
    }
}