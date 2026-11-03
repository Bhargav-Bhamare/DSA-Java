package Tree;
// import java.util.*;

public class diameter {
    //Node class
    public static class Node{
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
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;
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
    }

    //Diameter of a tree is the maximum distance between any two nodes in a tree.
    public static int diameter2(Node root){ //O(n^2)
        if(root == null){
            return 0;
        }
        int leftDiam = diameter2(root.left);
        int leftHt = height(root.left);
        int rightDiam = diameter2(root.right);
        int rightHt = height(root.right);
        
        int selfDiam = leftHt + rightHt + 1;
        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
    }

    public static class Info{
        int diam;
        int ht;

        public Info(int diam,int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter1(Node root){
        if(root == null){
            return new Info(0,0);
        }
        Info leftInfo = diameter1(root.left);
        Info rightInfo = diameter1(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;


        return new Info(diam,ht);
    }

    //Subtree Question

    public static boolean isIdentical(Node node, Node subroot){
        if(node == null && subroot == null){
            return true;
        }else if(node == null  || subroot == null || node.data != subroot.data){
            return false;
        }

        if(!isIdentical(node.left, subroot.left)){
            return false;
        }
        if(!isIdentical(node.right, subroot.right)){
            return false;
        }
        return true;
    }
    public static boolean isSubtree(Node root, Node subroot){
        if(root == null){
            return false;
        }
        if(root.data == subroot.data){
            if(isIdentical(root,subroot)){
                return true;
            }
        }
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    public static void main(String[] args) {
        /*
            1
           / \
          2   3
         / \ / \
        4  5 6  7
    */
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    /*
          2
         / \
        4   5
    */
    Node subRoot = new Node(2);
    subRoot.left = new Node(4);
    subRoot.right = new Node(5);
    
    System.out.println(isSubtree(root, subRoot));
    }

}

