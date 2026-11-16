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


    public static void main(String[] args) {
        int vals[] = {8, 5, 3, 6, 10 ,11, 14};

        Node root = null;

        for(int i = 0;i< vals.length;i++){
            root = insert(root, vals[i]);
        }

        System.out.print("Inorder: ");
        inorderTrav(root);
        System.out.println();

        // root = delete(root,4 );
        
        // System.out.print("Inorder: ");
        // inorderTrav(root);

        rootToLeaf(root, new ArrayList<>());
    }
    
}
