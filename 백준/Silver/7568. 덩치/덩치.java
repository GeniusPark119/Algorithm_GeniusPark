//import java.util.Scanner;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.valueOf(br.readLine());
        Person[] arr = new Person[n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new Person(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)continue;
                if(arr[i].weight < arr[j].weight && arr[i].height< arr[j].height){
                    ans[i]++;
                }
            }
            ans[i] +=1;
        }

        for(int x : ans){
            System.out.print(x+" ");
        }

    }

    static class Person{
        int weight;
        int height;

        public Person(int w,int h){
            this.weight = w;
            this.height = h;
        }
    }


}
