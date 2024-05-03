public class UBST {

    // Data items
    private Bnode root;

    // Constructor
    public UBST(){
        root = null;
    }

    // Functional Methods
    // insert()
    public void insert(int value){
        root = insert_recursive(root, value);
    }

    private Bnode insert_recursive(Bnode stroot, int value){
        if(stroot == null){ // Tree is empty
            stroot = new Bnode(value);
        }
        else{
            // check to see if value is smaller or greater than root
            if(value <= stroot.get_num()){
                // Recurse Left if smaller or equal
                stroot.set_left(insert_recursive(stroot.get_left(), value));
            }else{
                // Recurse Right if greater
                stroot.set_right(insert_recursive(stroot.get_right(), value));
            }
        }
        return stroot;
    }

    // delete()

    // traversals -- very UBST structure is as expected

    // inorder traversal
    public void inorder(){
        System.out.print("Inorder: ");
        inorder_recursive(root);
        System.out.println();
    }

    // Recursive helper function
    private void inorder_recursive(Bnode subroot){
        if(subroot == null){
            return;
        }else{
            // report LST
            inorder_recursive(subroot.get_left());

            // report root
            System.out.print(subroot.get_num() + " ");

            // report RST
            inorder_recursive(subroot.get_right());
        }
    }

    // Preorder traversal
    public void preorder(){
        System.out.print("Preorder: ");
        preorder_recursive(root);
        System.out.println();
    }

    // Recursive helper function
    private void preorder_recursive(Bnode subroot){
        if(subroot == null){
            return;
        }else{

            // report root
            System.out.print(subroot.get_num() + " ");

            // report LST
            preorder_recursive(subroot.get_left());

            // report RST
            preorder_recursive(subroot.get_right());
        }
    }


    public void postorder(){
        System.out.print("Postorder: ");
        postorder_recursive(root);
        System.out.println();
    }

    // Recursive helper function
    private void postorder_recursive(Bnode subroot){
        if(subroot == null){
            return;
        }else{
            // report LST
            postorder_recursive(subroot.get_left());

            // report RST
            postorder_recursive(subroot.get_right());

            // report root
            System.out.print(subroot.get_num() + " ");

        }
    }

    // delete()
    public void delete(int x){
        if (root == null) { // List is empty
            System.out.println("Nothing to delete. List is empty!");
        }
        else
            root = delete_recursive(root, x);
    }

    // delete recursive helper
    private Bnode delete_recursive(Bnode stroot, int x){
        // FIX ME
        if(stroot == null){
            System.out.println("Item not found. Nothing to delete!");
            return stroot;
        }else{
            // I have found the node with value x
            if(stroot.get_num() == x){
                System.err.println("Item found!");
            // Case 1: Deleting a leaf
                if(stroot.get_left() == null && stroot.get_right() == null){
                    return null;
                }
            // Case 2: Deleting a node with 1 child
                else if(stroot.get_left() == null || stroot.get_right() == null){
                    if(stroot.get_left() != null){
                        return stroot.get_left();
                    }else{
                        return stroot.get_right();
                    }
                }
            // Case 3: Deleting a node with 2 children
                else{
                    // Find the replacement: successor or predecessor
                    int s = successor(stroot.get_right());
                    // Ensure that the newNode is in the correct structure of the tree
                    //newNode.set_left(stroot.get_left());
                    //return newNode;
                    //System.out.println(s.get_num());
                    stroot.set_num(s);
                    stroot.set_right(delete_recursive(stroot.get_right(), s));
                    return stroot;
                    
                }
            }else{
            // If I didn't find the node then keep Recursing
                if(x < stroot.get_num()){
                    // recurse left
                    stroot.set_left(delete_recursive(stroot.get_left(), x));
                }
                else{
                    // recurse right
                    stroot.set_right(delete_recursive(stroot.get_right(), x));
                }
            }
            return stroot;
        }

    }

    // successor
    public int successor(Bnode stroot){
        // Leftmost child in sub tree 
        /*if(stroot.get_left()==null){
        }
        else{
            stroot = successor(stroot.get_left());
        }*/
        if(stroot.get_left()!=null)
            successor(stroot.get_left());
        return stroot.get_num();
    }

    // display()
    public void display(){
        display_recursive(root, 0);
    }

    // display recursive helper
    private void display_recursive(Bnode stroot, int level){
        if(stroot != null){
            display_recursive(stroot.get_right(), level+1);
            for(int i=0; i < level; i++){
                System.out.print("     ");
            }
            System.out.println(stroot.get_num());
            display_recursive(stroot.get_left(), level+1);
        }
        //else{
            // if you hit the null do nothing
        //}
    }

    // Accessor methods

    
}
