package Tree;

public class basics {
    //Class Node
    static class Node{
        int data;
        Node left;
        Node right;

        //Constructor
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        private int idx;

        public Node buildTree(int nodes[]){
            idx = -1;
            return buildTreeRecursive(nodes);
        }

        private Node buildTreeRecursive(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTreeRecursive(nodes);
            newNode.right = buildTreeRecursive(nodes);

            return newNode;
        }

        public void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

        public void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

        public void postorder(Node root){
            if(root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Preorder Traversal : ");
        tree.preorder(root);
        System.out.println();
        System.out.println("Inorder Traversal : ");
        tree.inorder(root);
        System.out.println();
        System.out.println("Postorder Traversal : ");
        tree.postorder(root);
    }
}
