package BST;

public class basic {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
    //Insertion in BST
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    //Inorder Traversal
    public static void inorderTrav(Node root){
        if(root == null){
            return;
        }
        inorderTrav(root.left);
        System.out.print(root.data+"-");
        inorderTrav(root.right);
    }

    //Search in BST
    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(root.data < key){
            return search(root.right, key);
        }else{
            return search(root.left, key);
        }
        
    }

    public static void main(String[] args) {
        int vals[] = {5, 1, 3, 4, 2, 7};

        Node root = null;

        for(int i = 0;i< vals.length;i++){
            root = insert(root, vals[i]);
        }

        System.out.print("Inorder:");
        inorderTrav(root);
        System.out.println();

        System.out.println(search(root, 9));
    }
    
}
