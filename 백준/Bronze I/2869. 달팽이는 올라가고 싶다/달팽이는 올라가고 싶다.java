import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();

        int ans = 0;

       if(V==A) ans = 1;
       else{
           ans= (V-B)%(A-B)==0? (V-B)/(A-B) :(V-B)/(A-B)+1;
       }

       System.out.println(ans);

    }

}
