import java.util.*;
import java.util.Map.*;

class Solution {

    static HashMap<String, Integer> map;

    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) { // orders 에 있는 메뉴조합들을 오름차순으로 만듦
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }

        for (int i = 0; i < course.length; i++) { // course 길이 만큼 만듦
            map = new HashMap<>();

            int max = Integer.MIN_VALUE;

            for (int j = 0; j < orders.length; j++) {
                StringBuilder sb = new StringBuilder();
                if (course[i] <= orders[j].length()) { // 만약 시킨메뉴들의 길이가 필요길이보다 같거나 크면
                    combi(orders[j], sb, 0, 0, course[i]); // 메뉴조합의 경우의 수를 map에 추가하는 combi
                }
            }

            for (Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());
            } // 가장 많이 주문된 횟수 max에 저장

            for (Entry<String, Integer> entry : map.entrySet()) {
                if (max >= 2 && entry.getValue() == max) {
                    answer.add(entry.getKey()); // 최소 2번이상 주문된 조합
                }
            }
            Collections.sort(answer);


        }
        return answer;
    }

    public static void combi(String str, StringBuilder sb, int idx, int cnt, int n) {
        if (cnt == n) { // 요리 개수만큼 조합이 완성되면 map에 해당 조합을 넣는다.
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = idx; i < str.length(); i++) {
            sb.append(str.charAt(i));
            combi(str, sb, i + 1, cnt + 1, n);
            sb.delete(cnt, cnt + 1);
        }
    }

}