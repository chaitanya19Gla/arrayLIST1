import java.util.LinkedList;
import java.util.Queue;

public class topView {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }


        static class Info{
            Node node;
            int hd;

            public Info(Node node , int hd){
                this.node = node;
                this.hd = hd;
            }
        }
        public static  void topView(Node root){
            Queue<Info> q = new LinkedList<>();
        }


    }

        public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);


            Node subRoot = new Node(2);
            subRoot.left = new Node(4);
            subRoot.right = new Node(9);


        }



}