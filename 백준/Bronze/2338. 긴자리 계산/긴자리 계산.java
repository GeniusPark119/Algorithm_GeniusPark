import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    public static void main(String args[]) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());

        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
        System.out.println(a.multiply(b));
    }
}
