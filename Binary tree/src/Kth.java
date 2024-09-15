public class Kth {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void kLevel(Node root, int level , int k){
        int count =0;
        if (root==null){
            return;
        }
        if (level==k){
            System.out.print(root.data+" ");
            count+=root.data;
            return;
        }
        int []arr = {};


        kLevel(root.left , level+1,k);
        kLevel(root.right , level+1,k);

    }
        public static void main(String[] args) {
        Node root = new Kth.Node(1);
        root.left = new Kth.Node(2);
        root.right = new Kth.Node(3);
        root.left.left = new Kth.Node(4);
        root.left.right = new Kth.Node(5);
        root.right.left = new Kth.Node(6);
        root.right.right = new Kth.Node(7);


        int k=2;
        kLevel(root,1,k);


    }


}


