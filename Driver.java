public class Driver {
    public static void main(String[] args) throws Exception {
        UBST mytree = new UBST(); // Create Empty Unbalance BST

        mytree.insert(5);
        mytree.insert(6);
        mytree.insert(-7);
        mytree.insert(8325);
        mytree.insert(3);
        mytree.insert(1);
        mytree.insert(-60);
        mytree.insert(-452);
        mytree.insert(870);

        mytree.inorder();
        mytree.preorder();
        mytree.postorder();

        mytree.display();

        // delete something that doesn't exist
        mytree.delete(355);

        // delete leaf node
        mytree.delete(-452);

        mytree.display();

        // delete node with one child
        mytree.delete(8325);

        mytree.display();

        // delete node with one child
        mytree.delete(5);

        mytree.display();
    }
}
