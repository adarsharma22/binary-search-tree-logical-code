public class BinarySearchTree {
    public  static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
        public static Node Insert(Node root,int val){
            if(root==null){
                root=new Node(val);
                return root;
            }
            if(root.data>val){
                root.left=Insert(root.left,val);
            }else{
                root.right=Insert(root.right,val);
            }
            return root;
        }
        public static void Inorder(Node root){
            if(root==null){
                return;
            }
            Inorder(root.left);
            System.out.print(root.data+" ");
            Inorder(root.right);
        }
        public static boolean Search(Node root,int key){
            if(root==null){
                return false;
            }
            if(root.data>key){
                return Search(root.left,key);
            } else if (root.data==key) {
                return true;
            }else {
                return Search(root.right,key);
            }
        }
        public static Node Delete(Node root,int val){
            if(root.data>val){
                root.left=Delete(root.left,val);
            } else if (root.data<val) {
                root.right=Delete(root.right,val);
            }else{
                //case 1 leaf node
                if(root.left==null&&root.right==null){
                    return null;
                }
                //case 2 one child
                if(root.left==null){
                    return root.right;
                }else if (root.right==null){
                    return root.left;
                }
                //case 3 two children
                Node IS=InorderSuccessor(root.right);
                root.data= IS.data;
                root.right=Delete(root.right, IS.data);
            }
            return root;
        }
        public static Node InorderSuccessor(Node root){
            while (root.left!=null){
                root=root.left;
            }
            return root;
        }

        public static void main(String[] args) {
            int values[]={12,11,23,22,13,18};
            Node root=null;
            for(int i=0;i< values.length;i++){
                root=Insert(root,values[i]);
            }
            root=Insert(root,20);

            Inorder(root);
            System.out.println();


            if(Search(root,1)){
                System.out.println("FOUND");
            }else{
                System.out.println("NOT FOUND");
            }

            //Delete(root,4);
            Inorder(root);



        }
    }
}