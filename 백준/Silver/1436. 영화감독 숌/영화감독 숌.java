import java.util.Scanner;
//영화감독 숌
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int answer = 666;
        int cnt = 1;

        while(cnt!=num){
            answer++;
            if(String.valueOf(answer).contains("666")){
                cnt++;
            }
        }


        System.out.println(answer);

    }
}
