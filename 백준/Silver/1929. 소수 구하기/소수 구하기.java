import java.util.Scanner;

//소수구하기

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        loop : for(int i=m;i<=n;i++){
            if(i==1) continue;
            for(int j=2;j<=(int)Math.sqrt(i);j++){
                if(i%j==0)
                    continue loop;
            }
                System.out.println(i);
        }


    }

}
