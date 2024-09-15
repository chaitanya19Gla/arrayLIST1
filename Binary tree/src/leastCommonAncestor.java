public class leastCommonAncestor {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node lca(Node root,int n1 ,int n2) {

        if (root==null||root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftLca = lca(root.left, n1, n2);
        Node rightLca = lca(root.right, n1, n2);

        if (leftLca == null) {

            return rightLca;
        }
        if (rightLca == null) {

            return leftLca;
        }
       // System.out.println(root.data);
        return root;
    }
    public static int lcaDist(Node root , int n){
        if (root == null){
            return -1;
        }
        if (root.data==n){
            return 0;
        }
        int leftDist = lcaDist(root.left , n);
        int rightdist = lcaDist(root.right , n);

        if (leftDist==-1 && rightdist==-1){
            return -1;
        } else if (leftDist==-1) {
            return rightdist+1;
        }
        else {
            return leftDist+1;
        }
    }
    public static int MinDis(Node root,int n1 , int n2){
        Node lca = lca(root ,  n1 , n2);
        int dis1 = lcaDist(lca,n1);
        int dis2=lcaDist(lca,n2);

        return dis1+dis2;
    }
    public static int KAncestor(Node root , int n , int k){
        if (root==null){
            return -1;

        }
        if (root.data == n){
            return 0;
        }
        int leftDist = KAncestor(root.left , n , k);
        int rightDist = KAncestor(root.right , n , k);

        if (leftDist ==-1 || rightDist==-1){
            return -1;
        }
        int max = Math.max(leftDist , rightDist);
        if (max+1 ==k){
            System.out.println(root.data);
        }

        return max+1;
    }

    public static int transform(Node root){
        if (root == null){
            return 0;
        }
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0: root.left.data;
        int newRight = root.right == null ? 0: root.right.data;

        root.data =  newLeft + leftChild +newRight + rightChild;
        return data;
    }
    public static void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.data + "-");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        transform(root);
        preOrder(root);

//        int n1=4;
//        int n2=5;

        //System.out.println(lca(root,n1,n2));
        //System.out.println(MinDis(root,n1,n2));
//        int n = 2;
//        int k =1;
//        System.out.println(KAncestor(root , n , k));

    }

}