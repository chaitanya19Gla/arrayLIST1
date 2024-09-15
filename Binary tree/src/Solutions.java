public class Solutions {
    static class Node {
        int data;
        leastCommonAncestor.Node left;
        leastCommonAncestor.Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean univalued(FindSubtree.Node root){
        if (root == null){
            return true;
        }
        if (root.left != null&& root.data != root.left.data)
            return false;
        if (root.right != null&& root.data != root.right.data)
            return false;
        return univalued(root.left)&& univalued(root.right);
    }

    public static void main(String[] args) {
        FindSubtree.Node root = new FindSubtree.Node(2);
        root.left = new FindSubtree.Node(3);
        root.right = new FindSubtree.Node(7);
        root.left.left = new FindSubtree.Node(5);
        root.left.right = new FindSubtree.Node(5);
        System.out.println(univalued(root));

    }


}
