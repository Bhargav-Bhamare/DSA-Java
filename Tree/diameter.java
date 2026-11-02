package Tree;
// import java.util.*;

public class diameter {
    //Node class
    public class Node{
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

    public Info(int diam, int ht)

    public static void main(String[] args) {
        
    }

}

