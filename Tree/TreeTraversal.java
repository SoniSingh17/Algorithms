import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
    public static class node {
        int data;
        node left,right;
        node(int data){
            this.data=data;
            left = right = null;

        }
    }
    public static class BinaryTree {
        static int idx = 0;
        public static node buildTree(int arr[]){
            if(arr[idx]==-1){
                idx++;
                return null;
            }
            node Newnode = new node(arr[idx++]);
            Newnode.left=buildTree(arr);
            Newnode.right=buildTree(arr);
            return Newnode;
        }
    }
    public static void preorder(node node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(node node){
        if(node == null){
            return;

        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
    public static void postOrder(node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
    public static void levelorder(node node){
        if(node == null) return;
        Queue<node> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                node temp = q.poll();
                System.out.print(temp.data + " ");
                if(temp.left !=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);

            }
            System.out.println();
        }

    }

        public static void main(String[] args) {
        int[] arr={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        node Tree = tree.buildTree(arr);
        System.out.println("The tree root is : "+Tree.data);
        //the preoder traversal is : Time Comp : O(n)
        System.out.print("Preoder Traversal is : ");
        preorder(Tree);
        //inoder traversal is : Time Comp : O(n)
        System.out.println();
        System.out.print("Inoder Traversal is : ");
        inorder(Tree);
        //post order traversal : Time Comp : O(n)
        System.out.println();
        System.out.print("Postorder traversal is : ");
        postOrder(Tree);
        //Level order traversal : Time Comp : O(n)
        System.out.println();
        System.out.println("Level order Traversal of the tree ");
        levelorder(Tree);
    }


    
}
