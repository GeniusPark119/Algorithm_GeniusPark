import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        Node root = new Node(Integer.parseInt(br.readLine()));

       while(true){
           String str = br.readLine();
           if(str == null || str.equals("")) break;
           root.insert(Integer.parseInt(str));
       }

       postOrder(root);


    }

    public static void postOrder(Node node){
        if(node==null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.mid);
    }

    static class Node{
        int mid;
        Node left,right;

        Node(int mid){
            this.mid = mid;
        }

        void insert(int n){
            if(n<this.mid){
                if(this.left == null)
                    this.left = new Node(n);
                else
                    this.left.insert(n);
            }else{
                if(this.right == null)
                    this.right = new Node(n);
                else
                    this.right.insert(n);
            }
        }

    }

}

