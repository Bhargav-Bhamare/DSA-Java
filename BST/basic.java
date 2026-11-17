package BST;

import java.util.ArrayList;

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
        System.out.print(root.data+" ");
        inorderTrav(root.right);
    }
    //preorder Traversal
    public static void preOrderTrav(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        inorderTrav(root.left);      
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

    //Deleting A Node from BST
    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right, val);
        }else if(root.data > val){
            root.left = delete(root.left, val);
        }else{
            //This is the Node we want to Delete
            //Case 1
            if(root.right == null && root.left == null){
                return null;
            }

            //Case 2 : One Child
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            //Case 3: 2 Childrens
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    //Utility Function for deletion
    public static Node findInOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    //Print in range
    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return ;
        }
        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }else if(root.data < k1){
            printInRange(root.left, k1, k2);
        }else{
            printInRange(root.right, k1, k2);
        }
    }

    //Root to leaf Paths
    public static void rootToLeaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        rootToLeaf(root.left, path);
        rootToLeaf(root.right, path);
        path.remove(path.size()-1);        
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i =0;i<path.size();i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println("-Null");
    }

    //Validate a bst
    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){
            return false;
        }else if(max != null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    //Mirror a BST
    public static Node createMirror(Node root){
        if(root == null){
            return null;
        }
        Node leftSubTree = createMirror(root.left);
        Node rightSubTree = createMirror(root.right);
        //Swap
        root.left = rightSubTree;
        root.right = leftSubTree;

        return root;
    }


    public static void main(String[] args) {
        int vals[] = {8, 5, 3, 6, 10 ,11, 14};

        Node root = null;

        for(int i = 0;i< vals.length;i++){
            root = insert(root, vals[i]);
        }

        System.out.print("Preorder: ");
        preOrderTrav(root);
        System.out.println();

        // root = delete(root,4 );
        
        // System.out.print("Inorder: ");
        // inorderTrav(root);

        // if(isValidBST(root, null, null)){
        //     System.out.println("Valid BST");
        // }else{
        //     System.out.println("Invalid BST");
        // }

        root = createMirror(root);
        preOrderTrav(root);
    }
    
}
