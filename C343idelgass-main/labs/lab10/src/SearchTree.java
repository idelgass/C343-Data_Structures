import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SearchTree <K extends Comparable<?super K>> {
    BinaryNode<K> root;
    BinaryNode<K> current;

    public SearchTree() {
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
        System.out.println("Depth first search (rec): " + DFSRec(root));
        System.out.println("Depth first search (iter): " + DFSIter(root));
        System.out.println("Breadth first search: " + BFS(root));
        System.out.println("Breadth first level search: " + BFSLevel(root));
    }
    public void traversePreOrder(BinaryNode<K> entry) {
        System.out.print(entry.getKey() + " ");
        if (entry.getLeft() != null) traversePreOrder(entry.getLeft());
        if (entry.getRight() != null) traversePreOrder(entry.getRight());
    }

    public ArrayList<K> DFSRec (BinaryNode<K> entry) {
        //TODO Task A
        //Implement DFS through recursion
        ArrayList<K> list = new ArrayList<>();
        list.add(entry.getKey());
        if(entry.getLeft() != null) list.addAll(DFSRec(entry.getLeft()));
        if(entry.getRight() != null) list.addAll(DFSRec(entry.getRight()));
        return list;
    }

    public ArrayList<K> DFSIter (BinaryNode<K> entry) {
        //TODO Task B
        //Implement DFS through iteration
        // Results in preorder traversal, how to modify for inorder/postorder?
        ArrayList<K> list = new ArrayList<>();
        Stack<BinaryNode<K>> stack = new Stack();
        stack.push(entry);
        BinaryNode<K> currentNode;
        while(!stack.isEmpty()){
            currentNode = stack.pop();
            list.add(currentNode.getKey());
            // Invert right left order when pushing to get correct order when popping
            if(currentNode.getRight() != null) stack.push(currentNode.getRight());
            if(currentNode.getLeft() != null) stack.push(currentNode.getLeft());
        }
        return list;
    }

    public ArrayList<K> BFS (BinaryNode<K> entry) {
        //TODO Task C
        //Implement BFS
        //NOTE: This is the same thing as level-order traversal
        ArrayList<K> list = new ArrayList<>();
        Queue<BinaryNode<K>> queue = new LinkedList<>();
        BinaryNode<K> currentNode;
        queue.add(entry);
        while(!queue.isEmpty()){
            currentNode = queue.poll();
            list.add(currentNode.getKey());
            if(currentNode.getLeft() != null) queue.add(currentNode.getLeft());
            if(currentNode.getRight() != null) queue.add(currentNode.getRight());
        }
        return list;
    }

    public ArrayList<ArrayList<K>> BFSLevel (BinaryNode<K> entry){
        //TODO Task D
        //This is a more challenging way of showing BFS. Copy your code from above and modify to have each line of the BST be its own list
        //You will return the list of lists
        ArrayList<ArrayList<K>> masterList = new ArrayList<>();
        ArrayList<K> levelKeys;
        BinaryNode<K> currentNode;
        Queue<BinaryNode<K>> level = new LinkedList<>();
        level.add(entry);
        Queue<BinaryNode<K>> nextLevel;
        do{
            levelKeys = new ArrayList<>();
            nextLevel = new LinkedList<>();
            while(!level.isEmpty()){
                currentNode = level.poll();
                levelKeys.add(currentNode.getKey());
                if(currentNode.getLeft() != null) nextLevel.add(currentNode.getLeft());
                if(currentNode.getRight() != null) nextLevel.add(currentNode.getRight());
            }
            masterList.add(levelKeys);
            level = new LinkedList<>(nextLevel);
        } while(!nextLevel.isEmpty());
        return masterList;
    }


    public static void main(String[] argv) {

        SearchTree<Integer> tree = new SearchTree<Integer>();
        Integer[] keys = {2, 4, 6, 8, 10, 3, 5, 7, 9, 11, 12, -10, -20, 100};
        tree.build(keys);
        tree.display();
        String str = "Beep";

        //TODO Task E
        //Create two original trees to test your functions on. Make one tree complete, and one incomplete(feel free to make this one a little crazy to prove your functions work).
    }
}