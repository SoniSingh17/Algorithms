package BST;

public class BST {
    public static class Node{
        int val;
        Node left,right;
        Node(int val){
            this.val = val;
        }
    }
    // to insert as well the time complexity is : O(h)-->'h' stands for height
    public static Node construct(Node root , int num){
        if(root == null){
         root = new Node(num);
         return root;

        }
        if(num<root.val){
            root.left = construct(root.left, num);
        }
        if(num>root.val){
            root.right = construct(root.right, num);
        }
        return root;

    }
    public static void inorder(Node root) {
        if(root == null){
            return;

        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
        
    }
    // to search in the tree
    public static boolean search(Node root,int num){
        if(root == null){
            return false;
        } //Base case
        if(num < root.val){
            return search(root.left, num);

        }
        else if(num > root.val){
            return search(root.right, num);
        }
        else{
            return true;
        }
       
    }
    // Delete a node 
    public static Node delete(Node root , int num){
        if(num < root.val){
            root.left = delete(root.left,num);
        }
        else if(num > root.val){
            root.right = delete(root.right, num);
        }
        else{ //root.val == num(this node has to be deleted)
            // case 1
            if(root.left == null && root.right ==null){
                return null;
            }
            // case 2
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            Node is = inordersucc(root.right);
            root.val = is.val;
            root.right = delete(root.right,is.val);


        }
        return root;
    }
    public static Node inordersucc(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = null;
        
        int arr[] = {5,1,3,4,2,7};
        for(int i=0;i<arr.length;i++){
             root = construct(root, arr[i]);
        }
        System.out.println("BST Tree is : ");
        inorder(root);
        System.out.println();
        System.out.println("4 present in the tree ? "+ search(root, 4));
        System.out.println("Sequence before deleting 1");
        inorder(root);
        delete(root, 1);
        System.out.println();
        System.out.println("after deleting 1");
        inorder(root);
    
        
    
}
}