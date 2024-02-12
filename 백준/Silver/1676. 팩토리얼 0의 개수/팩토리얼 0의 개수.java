import java.util.Scanner;
//팩토리얼 0의 개수
public class Main {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n>=5){
            answer += n/5;
            n/=5;
        }
//        if(n==0){
//            answer = 1;
//        }
        System.out.println(answer);

    }
}
