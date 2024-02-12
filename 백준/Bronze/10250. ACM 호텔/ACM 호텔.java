import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            int H = sc.nextInt(); //층
            int W = sc.nextInt(); //방
            int N = sc.nextInt(); //번째

            int left = N%H==0? H : N%H;
            int right = N%H==0? N/H : N/H+1;

            if(right<10){
                System.out.println(""+left+"0"+right);
            }else{
                System.out.println(""+left+right);
            }
        }

    }
}
