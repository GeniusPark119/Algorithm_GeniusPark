import java.util.Scanner;
//1259번 : 팰린드롬수

public class Main {
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);

        while(true){
            String num = sc.next();
            if(num.equals("0")) break;

            String answer = "yes";

            for(int i=0;i<num.length()/2;i++){
                if(num.charAt(i) != num.charAt(num.length()-i-1)){
                    answer = "no";
                    break;
                }
            }

            System.out.println(answer);

        }
    }
}