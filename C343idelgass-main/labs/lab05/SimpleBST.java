// C343 / Spring 2022
//
// a very simple, starting BST class;
// it's so simple, it's named SimpleBST.


public class SimpleBST <K extends Comparable<?super K>> {
    BinaryNode<K> root;
    BinaryNode<K> current;

    // TODO for Lab 05 Task B
    // "unbalanced" is used for balance checking:
    //    if a node is unbalanced, the tree will be unbalanced
    BinaryNode<K> unbalanced = null;
    
    public SimpleBST() {
        root = null;
        current = null;
    }
    public void build(K[] keys) {
        for (int i = 0; i < keys.length; i ++)
            insert(keys[i]);
    }
    public void insert(K k) {
        BinaryNode<K> tmpNode = new BinaryNode<K>(k);
        if (root == null) {
            root = current = tmpNode;
        } else {
            current = search(root, k);
            if (k.compareTo(current.getKey()) < 0)
                current.setLeft(tmpNode);
            else
                current.setRight(tmpNode);
        }
    }
    public BinaryNode<K> search(BinaryNode<K> entry, K k) {
        if (entry == null) {
            return null;
        } else {
            // update the size of the subtree by one:
            entry.setSize(entry.getSize() + 1);
            if (entry.isLeaf())
                return entry;
            if (k.compareTo(entry.getKey()) < 0) {
                if (entry.getLeft() != null)
                    return search(entry.getLeft(), k);
                else
                    return entry;
            } else {
                if (entry.getRight() != null)
                    return search(entry.getRight(), k);
                else
                    return entry;
            }
        }
    }
    public void display() {
        if (root == null) {
            return;
        }
        System.out.print("Pre-order traversal: ");
        traversePreOrder(root);
        System.out.println();
        //System.out.print("In-order traversal: ");
        //traverseInOrder(root);
        //System.out.println();
        //System.out.print("Post-order traversal: ");
        //traversePostOrder(root);
    }
    public void traversePreOrder(BinaryNode<K> entry) {
        System.out.print(entry.getKey() + " ");
        if (entry.getLeft() != null) traversePreOrder(entry.getLeft());
        if (entry.getRight() != null) traversePreOrder(entry.getRight());
    }

    // TODO for Lab 05 Task B
    // implement balanceCheck(),
    //   and you may write heightAtNode(node) as helper function
    int heightAtNode(BinaryNode node){ //Not really a helper function but I cant change the signature of balanceCheck to accept a node arg so had to do this
        if (node == null) return 0;
        int heightLeft = heightAtNode(node.getLeft());
        int heightRight = heightAtNode(node.getRight());
        if(Math.abs(heightLeft - heightRight) > 1)  return -1;
        else if(heightLeft == -1) return -1;
        else if(heightRight == -1) return -1;
        else return 1 + Math.max(heightAtNode(node.getLeft()), heightAtNode(node.getRight()));
    }
    boolean balanceCheck(){
        if(heightAtNode(root) == -1) {return false;} //-1 is a dummy value to indicate tree is unbalanced
        else {return true;}
    }

    // TODO for Lab 05 Task C
    // implement traverseInOrder()
    public void traverseInOrder(BinaryNode<K> entry){
        if (entry.getLeft() != null) traverseInOrder(entry.getLeft());
        System.out.print(entry.getKey() + " ");
        if (entry.getRight() != null) traverseInOrder(entry.getRight());
    }
    // implement traversePostOrder()
    public void traversePostOrder(BinaryNode<K> entry){
        if (entry.getLeft() != null) traversePostOrder(entry.getLeft());
        if (entry.getRight() != null) traversePostOrder(entry.getRight());
        System.out.print(entry.getKey() + " ");
    }

    public static void main(String[] argv) {
        SimpleBST<Integer> tree = new SimpleBST<Integer>();
        Integer[] keys = {2, 4, 6, 8, 10, 3, 5, 7, 9, 11, 12, -10, -20, 100};
        tree.build(keys);
        tree.display();


        // TODO for Lab Task 05 Task B and C
        // see instructions
        System.out.println(tree.balanceCheck());

        SimpleBST<Integer> myTreeBalanced = new SimpleBST<>();
        Integer[] myKeysBalanced = {10, 12, 11, 13, 8, 7, 9, 6, 14};
        myTreeBalanced.build(myKeysBalanced);

        System.out.println(myTreeBalanced.balanceCheck());
        myTreeBalanced.traversePreOrder(myTreeBalanced.root);
        System.out.println();
        myTreeBalanced.traverseInOrder(myTreeBalanced.root);
        System.out.println();
        myTreeBalanced.traversePostOrder(myTreeBalanced.root);
        System.out.println();

        SimpleBST<Integer> myTreeUnbalanced = new SimpleBST<>();
        Integer[] myKeysUnbalanced = {1,2,3,4,3,5,6,7};
        myTreeUnbalanced.build(myKeysUnbalanced);

        System.out.println(myTreeUnbalanced.balanceCheck());
        myTreeUnbalanced.traversePreOrder(myTreeUnbalanced.root);
        System.out.println();
        myTreeUnbalanced.traverseInOrder(myTreeUnbalanced.root);
        System.out.println();
        myTreeUnbalanced.traversePostOrder(myTreeUnbalanced.root);
        System.out.println();
    }
}
