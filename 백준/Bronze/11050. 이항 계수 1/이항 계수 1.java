import java.util.Scanner;

//직각삼각형

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int answer = fact(n) / fact(m)/fact(n-m);
        System.out.println(answer);
    }

    public static int fact(int num){
        int ans = 1;
        for(int i=2;i<=num;i++){
            ans *= i;
        }
        return ans;
    }

}
