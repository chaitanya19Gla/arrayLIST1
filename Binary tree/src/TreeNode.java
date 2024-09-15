//
//public class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNod() {}
//    TreeNod(int val) { this.val = val; }
//    TreeNod(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
//
//class TreeNode {
//    int diameter = 0;
//    public int diameterOfBinaryTree(TreeNode root) {
//        height(root);
//        return diameter - 1;
//    }
//
//    private int height(TreeNode root){
//        if(root == null){
//            return 0;
//        }
//        int leftHeight = height(root.left);
//        int rightHeight = height(root.right);
//
//        int dia = leftHeight + rightHeight + 1;
//        diameter = Math.max(dia, diameter);
//
//        return Math.max(leftHeight, rightHeight) + 1;
//    }
//}