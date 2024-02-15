import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static StringBuilder sb;
    static Queue<String> queue;

    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        int len = str1.length();
        queue = new LinkedList<>();

        queue.offer(str2);

        while(!queue.isEmpty()){

//            System.out.println(queue);

            String str = queue.poll();
            if(str.length()==len){
                if(str.equals(str1)){
                    System.out.println(1);
                    return;
                }
                continue;
            }

            if(str.charAt(str.length()-1)=='A'){
                queue.offer(MinusA(str));
            }
            if(str.charAt(0)=='B'){
                queue.offer(MinusB(str));
            }

        }
        System.out.println(0);
    }

    static String MinusA(String str){
        return str.substring(0,str.length()-1);
    }

    static String MinusB(String str){
        sb = new StringBuilder();
        return sb.append(str.substring(1,str.length())).reverse().toString();
    }

}
