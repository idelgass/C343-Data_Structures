import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Testing {
//    Using stack
//    Go all the way to bottom (leaves) and push to stack recursively?
//
//    Preorder stuff
//    levelOrder(Node node){
//        push left to stack
//        push right to stack
//        levelOrder(node.left)
//        levelOrder(node.right)
//        push left to stack
//        push right to stack
//        push root?
    }
    public static void printLevelOrderS(Node root){
        Stack stack = new Stack();
        levelOrderS(root, stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    private static void levelOrderS(Node node,Stack s){
        if(node.right != null) levelOrderS(node.right, s);
        if(node.left != null) levelOrderS(node.left, s);
        s.push(node.data);
    }

    public static void printLevelOrderQ(Node root){
        Queue<Node> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()){
            Node nodeChildrenToEnqueue = q.poll();
            System.out.println(nodeChildrenToEnqueue.data);
            if(nodeChildrenToEnqueue.left != null) q.add(nodeChildrenToEnqueue.left);
            if(nodeChildrenToEnqueue.right != null) q.add(nodeChildrenToEnqueue.right);
        }
    }
    private static void levelOrderQ(Node node, Queue q){

    }

    public static void main(String[] args) {
        Node root = new Node(0);
        Node L = new Node(1);
        Node R = new Node(2);
        Node LL = new Node(3);
        Node LR = new Node(4);
        Node RL = new Node(5);
        Node RR = new Node(6);
        root.left = L;
        root.right = R;
        root.left.left = LL;
        root.left.right = LR;
        root.right.left = RL;
        root.right.right = RR;

        printLevelOrderS(root);
        printLevelOrderQ(root);
    }
}
