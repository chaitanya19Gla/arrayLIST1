public class preOrder {
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
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if (nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
            }
            public static void preorder(Node root){
            if (root == null){
                return;
            }
                System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
            }
        public static void Inorder(Node root){
            if (root == null){
                return;
            }
            Inorder(root.left);
            System.out.println(root.data);
            Inorder(root.right);
        }
        public static void postorder(Node root){
            if (root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);

        }

        }


    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(" ");
        System.out.println(root.data);

        System.out.println("preorder");
        tree.preorder(root);
        System.out.println("inorder ");
        tree.Inorder(root);
        System.out.println("post");
        tree.postorder(root);

    }
    }

