import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
//        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long answer = 0;

        for(int i=0;i<5;i++){
            answer +=Integer.parseInt(br.readLine());
        }

        System.out.println(answer);

    }

}

