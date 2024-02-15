import java.util.Scanner;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) {

        sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        int len = str1.length();
        sb.append(str2);
        while (sb.length() > len) {

            String tmpstr = sb.toString();
            if (tmpstr.charAt(tmpstr.length() - 1) == 'A') {
                sb.setLength(0);
                sb.append(tmpstr.substring(0, tmpstr.length() - 1));
            } else {
                sb.setLength(0);
                sb.append(tmpstr.substring(0, tmpstr.length() - 1));
                sb = sb.reverse();
            }
        }
        if (sb.toString().equals(str1))
            System.out.println(1);
        else
            System.out.println(0);
    }

}
