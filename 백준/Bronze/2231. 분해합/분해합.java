import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = String.valueOf(n).length();


        for(int i=1;i<n;i++){
            String str = String.valueOf(i);
            if(str.length()<len-1) continue;
            int sum = i;
            for(int j=0;j<str.length();j++){
                sum += str.charAt(j)-'0';
            }
//            System.out.println(str);
            if(sum==n){
                answer = i;
                break;
            }
        }
        System.out.println(answer);

    }
}
