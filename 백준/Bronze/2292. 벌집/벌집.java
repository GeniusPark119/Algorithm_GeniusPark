import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt=1;
        int i = 1;
        while(n>cnt){
            cnt += 6*(i++);
        }
        System.out.println(i);

    }
}