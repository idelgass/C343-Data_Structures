// C343 / Spring 2022
//
// a very simple, starting binary node class;
// it's so simple, it's named SimpleBinaryNode.

public class SimpleBinaryNode <E extends Comparable<?super E>> {
    private E value;                     // value-only, no key
    private SimpleBinaryNode<E> left;    // left child
    private SimpleBinaryNode<E> right;   // right child

    public SimpleBinaryNode(E e) {
        value = e;
        left = right = null;
    }

    public void setLeft(SimpleBinaryNode<E> node) {
        left = node;
    }

    public void setRight(SimpleBinaryNode<E> node) {
        right = node;
    }

    public boolean find(E q) {
        // TODO for Lab Task 05 Task A
        if(q.compareTo(value) == 0) {return true;} //Originally had q == value which DOES NOT WORK
        else if(left != null && right != null) {return left.find(q) || right.find(q);}
        else if(left != null) {return left.find(q);}
        else if(right != null) {return right.find(q);}
        else {return false;}
    }

    public static void main(String[] argv) {

        // TODO for Lab Task 05 Task A
        // see instructions

        SimpleBinaryNode<Integer> root = new SimpleBinaryNode<Integer>(7);
        SimpleBinaryNode<Integer> node1 = new SimpleBinaryNode<Integer>(29);
        SimpleBinaryNode<Integer> node2 = new SimpleBinaryNode<Integer>(36);
        SimpleBinaryNode<Integer> node3 = new SimpleBinaryNode<Integer>(69);
        SimpleBinaryNode<Integer> node4 = new SimpleBinaryNode<Integer>(706);
        SimpleBinaryNode<Integer> node5 = new SimpleBinaryNode<Integer>(500);
        SimpleBinaryNode<Integer> node6 = new SimpleBinaryNode<Integer>(301);
        SimpleBinaryNode<Integer> node7 = new SimpleBinaryNode<Integer>(2);
        SimpleBinaryNode<Integer> node8 = new SimpleBinaryNode<Integer>(366);
        SimpleBinaryNode<Integer> node9 = new SimpleBinaryNode<Integer>(290);

        root.setLeft(node1);
        root.setRight(node2);
        root.left.setLeft(node3);
        root.left.setRight(node4);
        root.right.setLeft(node5);
        root.right.setRight(node6);
        root.left.left.setLeft(node7);
        root.left.left.setRight(node8);
        root.left.right.setRight(node9);

        // find() needs to be implemented
        System.out.println("is 36 found in the tree: " + root.find(36));
        // find(36) should return true
        System.out.println("is 103 found in the tree: " + root.find(103));
        // find(103) should return false
        System.out.println("is 7 found in the tree: " + root.find(7));
        // find(7) should return true
        System.out.println("is 301 found in the tree: " + root.find(301));
        // find(301) should return true
        System.out.println("is 290 found in the tree: " + root.find(290));
        // find(290) should return true

        // TODO for Lab Task 05 Task A
        // Task 1 from part A, building tree with 10 nodes
        SimpleBinaryNode<Integer> myRoot = new SimpleBinaryNode<Integer>(0);
        SimpleBinaryNode<Integer> myNode1 = new SimpleBinaryNode<Integer>(1);
        SimpleBinaryNode<Integer> myNode2 = new SimpleBinaryNode<Integer>(2);
        SimpleBinaryNode<Integer> myNode3 = new SimpleBinaryNode<Integer>(3);
        SimpleBinaryNode<Integer> myNode4 = new SimpleBinaryNode<Integer>(4);
        SimpleBinaryNode<Integer> myNode5 = new SimpleBinaryNode<Integer>(5);
        SimpleBinaryNode<Integer> myNode6 = new SimpleBinaryNode<Integer>(6);
        SimpleBinaryNode<Integer> myNode7 = new SimpleBinaryNode<Integer>(7);
        SimpleBinaryNode<Integer> myNode8 = new SimpleBinaryNode<Integer>(8);
        SimpleBinaryNode<Integer> myNode9 = new SimpleBinaryNode<Integer>(9);

        myRoot.setLeft(myNode1);
        myRoot.setRight(myNode2);
        myRoot.left.setLeft(myNode3);
        myRoot.left.setRight(myNode4);
        myRoot.right.setLeft(myNode5);
        myRoot.right.setRight(myNode6);
        myRoot.left.left.setLeft(myNode7);
        myRoot.left.left.setRight(myNode8);
        myRoot.left.right.setLeft(myNode9);

        System.out.println("");
        System.out.println("Now testing my tree...");
        System.out.println("is 0 found in the tree: " + myRoot.find(0)); //T
        System.out.println("is 1 found in the tree: " + myRoot.find(1)); //T
        System.out.println("is 2 found in the tree: " + myRoot.find(2)); //T
        System.out.println("is 3 found in the tree: " + myRoot.find(3)); //T
        System.out.println("is 4 found in the tree: " + myRoot.find(4)); //T
        System.out.println("is 5 found in the tree: " + myRoot.find(5)); //T
        System.out.println("is 6 found in the tree: " + myRoot.find(6)); //T
        System.out.println("is 7 found in the tree: " + myRoot.find(7)); //T
        System.out.println("is 8 found in the tree: " + myRoot.find(8)); //T
        System.out.println("is 9 found in the tree: " + myRoot.find(9)); //T
        System.out.println("is 9 found in the tree: " + myRoot.find(9)); //T
        System.out.println("is 100 found in the tree: " + myRoot.find(100)); //F
    } // end of main()
} // end of SimpleBinaryNode class