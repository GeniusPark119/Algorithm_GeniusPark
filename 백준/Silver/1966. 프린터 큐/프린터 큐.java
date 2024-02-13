import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
//프린터 큐

public class Main {
    static Queue<File> queue;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {

            queue = new LinkedList<>();
            pq = new PriorityQueue<>((a,b) -> b-a);

            int N = sc.nextInt();//문서의 개수
            int target = sc.nextInt();//궁금한 문서의 순서

            for (int j = 0; j < N; j++) {
                int priority = sc.nextInt();
                queue.offer(new File(j,priority)); // 1 1 9 1 1 1
                pq.offer(priority); // 9 1 1 1 1
            }

            int order = 1;

            while(true){
                File f = queue.poll();
                if(f.priority == pq.peek()){
                    if(target==f.fileNum)
                        break;
                    else{
                        pq.poll();
                        order++;
                    }

                }
                queue.offer(f);
            }
            System.out.println(order);
        }
    }

    static class File { // 문서번호와 우선순위점수를 저장하는 클래스
        int fileNum = 0;
        int priority = 0;

        public File(int f, int p) {
            this.fileNum = f;
            this.priority = p;
        }

    }

}
