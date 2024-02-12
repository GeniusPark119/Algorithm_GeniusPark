import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            if(num==1) continue;
            boolean isSosu = true;

            for(int j=2;j<=(int)Math.sqrt(num);j++){
                if(num%j==0){
                    isSosu = false;
                    break;
                }

            }
            if(isSosu)
                answer++;

        }
        System.out.println(answer);

    }
}
