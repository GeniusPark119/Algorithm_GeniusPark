import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

//2164번 : 카드2
public class Main {
    static Queue<Integer> queue;
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        queue = new LinkedList<>();
        for(int i=1;i<=num;i++){
            queue.add(i);
        }
        while(queue.size()>1){
            queue.poll();
            queue.offer(queue.poll());

        }

        answer = queue.poll();

        System.out.println(answer);
    }
}
