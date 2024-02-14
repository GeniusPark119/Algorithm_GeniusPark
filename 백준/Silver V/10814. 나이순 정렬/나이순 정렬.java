import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


//나이순 정렬

public class Main {
    static List<User> list;
    static StringBuilder sb;
    public static void main(String[] args) {

        list = new ArrayList<>();
        sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            int age = sc.nextInt();
            String name = sc.next();
            list.add(new User(age,name));
        }

        Collections.sort(list,(a,b)->(a.age-b.age));

        for(User s : list){
            sb.append(s.age);
            sb.append(" ");
            sb.append(s.name);
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    static class User{
        int age=0;
        String name="";

        public User(int age,String name){
            this.age = age;
            this.name = name;
        }
    }

}
