import java.io.*;
import java.util.*;

public class Main { // 1360 되돌리기
    static List<Word> list; // 명령어가 나올 때 마다 결과물을 차례대로 저장

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        list = new ArrayList<>();
        list.add(new Word("", 0));

        int N = Integer.parseInt(br.readLine()); // 명령의 개수

        for (int idx = 1; idx <= N; idx++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken(); // 명령어

            if (command.equals("type")) { // type이면 글자와 수행 시간을 입력받아 stack에 넣는다.
                String word = st.nextToken(); // 글자
                int t = Integer.parseInt(st.nextToken()); // 수행 시간
                list.add(new Word(list.get(idx - 1).w + word, t));
                continue;
            }

            //undo면
            int returnT = Integer.parseInt(st.nextToken()); // 되돌릴 시간
            int t = Integer.parseInt(st.nextToken()); // 수행 시간

            int returned = t - returnT - 1;

            if (returned <= 0) {
                // 되돌아간 시간이 0 이하이면 공백
                list.add(new Word("", t));

            } else if (returned > list.get(idx - 1).t) {
                // 되돌아간 시간이 이전 idx의 시간보다 크면 이전 idx와 똑같다.
                list.add(new Word(list.get(idx - 1).w, t));

            } else {
                // 되돌릴만한 곳이 있다
                for (int back = idx - 1; back >= 0; back--) {
                    if (list.get(back).t <= returned) {
                        list.add(new Word(list.get(back).w, t));
                        break;
                    }
                }

            }
        }
        System.out.print(list.get(N).w);
    }

    public static class Word { // 글자와 수행 시간 저장하는 클래스
        String w;
        int t;

        public Word(String w, int t) {
            this.w = w;
            this.t = t;
        }
    }
}