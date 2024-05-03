public class Bnode {
    
    // Data items
    private int num;
    private Bnode left;
    private Bnode right;

    // Constructor
    public Bnode(int value){
        num = value;
        left = null;
        right = null;
    }


    // Accessor methods - getters/seeters
    public Bnode get_left(){
        return left;
    }

    public Bnode get_right(){
        return right;
    }

    public int get_num(){
        return num;
    }

    public void set_left(Bnode lnode){
        left = lnode;
    }

    public void set_right(Bnode rnode){
        right = rnode;
    }

    public void set_num(int value){
        num = value;
    }
}
