import java.io.*;
import java.util.*;

public class Main {

    static int answer = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int size = (int) Math.pow(2, n);

        find(r, c, size);

        System.out.println(answer);

    }

    public static void find(int r, int c, int size) {
        if (size == 1) return;

        if (r < size / 2 && c < size / 2) {
            find(r,c,size/2);
        }else if( r < size/2 && c >= size/2){
            answer += size*size/4;
            find(r,c%(size/2),size/2);
        }else if(r>= size/2 && c<size/2){
            answer += size*size/4*2;
            find(r%(size/2),c,size/2);
        }else{
            answer += size*size/4*3;
            find(r%(size/2),c%(size/2),size/2);
        }
    }
}
