// a simple implementation for graphs with adjacency lists

// Lab 11 starter file

import java.util.*;

public class AdjGraph implements Graph {

    // is it a directed graph (true or false) :
    private boolean digraph;

    private int totalNodes;
    // all the nodes in the graph:
    private Vector<String> nodeList;

    private int totalEdges;
    // all the adjacency lists, one for each node in the graph:
    private Vector<LinkedList<Integer>>  adjList;

    // all the weights of the edges, one for each node in the graph:
    private Vector<LinkedList<Integer>> adjWeight;

    // every visited node:
    private Vector<Boolean> visited;

    // list of nodes pre-visit:
    private Vector<Integer> nodeEnum;

    public AdjGraph() {
        init();
    }

    public AdjGraph(boolean ifdigraph) {
        init();
        digraph = ifdigraph;
    }

    public void init() {
        nodeList = new Vector<String>();
        adjList = new Vector<LinkedList<Integer>>();
        adjWeight = new Vector<LinkedList<Integer>>();
        visited = new Vector<Boolean>();
        nodeEnum = new Vector<Integer>();
        totalNodes = totalEdges = 0;
        digraph = false;
    }

    // set vertices:
    public void setVertices(String[] nodes) {
        for (int i = 0; i < nodes.length; i ++) {
            nodeList.add(nodes[i]);
            adjList.add(new LinkedList<Integer>());
            adjWeight.add(new LinkedList<Integer>());
            visited.add(false);
            totalNodes ++;
        }
    }

    // add a vertex:
    public void addVertex(String label) {
        nodeList.add(label);
        visited.add(false);
        adjList.add(new LinkedList<Integer>());
        adjWeight.add(new LinkedList<Integer>());
        totalNodes ++;
    }

    public int getNode(String node) {
        for (int i = 0; i < nodeList.size(); i ++) {
            if (nodeList.elementAt(i).equals(node)) return i;
        }
        return -1;
    }

    // return the number of vertices:
    public int length() {
        return nodeList.size();
    }

    // add edge from v1 to v2:
    public void setEdge(int v1, int v2, int weight) {
        LinkedList<Integer> tmp = adjList.elementAt(v1);
        if (adjList.elementAt(v1).contains(v2) == false) {
            tmp.add(v2);
            adjList.set(v1,  tmp);
            totalEdges ++;
            LinkedList<Integer> tmp2 = adjWeight.elementAt(v1);
            tmp2.add(weight);
            adjWeight.set(v1,  tmp2);
        }
    }

    public void setEdge(String v1, String v2, int weight) {
        if ((getNode(v1) != -1) && (getNode(v2) != -1)) {
            // add edge from v1 to v2:
            setEdge(getNode(v1), getNode(v2), weight);
            // for undirected graphs, add edge from v2 to v1 as well:
            if (digraph == false) {
                setEdge(getNode(v2), getNode(v1), weight);
            }
        }
    }

    // keep track whether a vertex has been visited or not,
    //    for graph traversal purposes:
    public void setVisited(int v) {
        visited.set(v, true);
        nodeEnum.add(v);
    }

    public boolean ifVisited(int v) {
        return visited.get(v);
    }


    public LinkedList<Integer> getNeighbors(int v) {
        return adjList.get(v);
    }

    public int getWeight(int v, int u) {
        LinkedList<Integer> tmp = getNeighbors(v);
        LinkedList<Integer> weight = adjWeight.get(v);
        if (tmp.contains(u)) {
            return weight.get(tmp.indexOf(u));
        } else {
            return Integer.MAX_VALUE;
        }
    }



    // clean up before traversing the graph:
    public void clearWalk() {
        nodeEnum.clear();
        for (int i = 0; i < nodeList.size(); i ++)
            visited.set(i, false);
    }

    public void walk(String method) {
        clearWalk();
        // traverse the graph:
        for (int i = 0; i < nodeList.size(); i ++) {
            if (ifVisited(i) == false) {
                if (method.equals("BFS")) {
                    BFS(i);      // i is the start node
                } else if (method.equals("DFS")) {
                    DFS(i); // i is the start node
                } else {
                    System.out.println("unrecognized traversal order: " + method);
                    System.exit(0);
                }
            }
        }
        System.out.println(method + ":");
        displayEnum();
    }

    // Lab 11 TODO:
    //
    // write your method topologicalSortWithQueue() here.
    //
    // TODO: check my types here, not sure whether to use ints, strings, etc for nodes
    public void topologicalSortWithQueue(){
        ArrayList<Integer> sortedVertices = new ArrayList<>(); // List that will contain sorted vertices
        LinkedList<Integer> indegrees = new LinkedList<>(); // List containing indegrees for each of the vertices
        Queue<Integer> q = new LinkedList<>(); // Queue containing eligible (no remaining unaccounted-for indegrees) vertices
        LinkedList<Integer> neighbors;
        // TODO: Initialize relevant ds (queue and indegrees)
        // Initialize indegrees list
        for(int i = 0; i < totalNodes; i++) indegrees.add(i, 0);
        for(int v = 0; v < totalNodes; v++){
            neighbors = getNeighbors(v);
            for(int neighbor : neighbors) {
                try{
                    indegrees.set(neighbor, indegrees.get(neighbor) + 1);
                }
                catch(IndexOutOfBoundsException e){
                    indegrees.set(v, 0);
                }
            }
        }
        for(int v = 0; v < totalNodes; v++){
            if(indegrees.get(v) == 0) q.add(v);
        }
        while(!q.isEmpty()) {
            int v = q.poll();
            sortedVertices.add(v);
            neighbors = getNeighbors(v);
            for (int neighbor : neighbors) {
                indegrees.set(neighbor, indegrees.get(neighbor) - 1);
                if (indegrees.get(neighbor) == 0) {
                    q.add(neighbor);
                }
            }
        }
        if (sortedVertices.containsAll(nodeEnum)) {
            System.out.println("Solution: " + sortedVertices.toString());
        } else {
            System.out.println("No solution.");
        }
    }



    public void DFS(int v) {
        setVisited(v);
        LinkedList<Integer> neighbors = adjList.elementAt(v);
        for (int i = 0; i < neighbors.size(); i ++) {
            int v1 = neighbors.get(i);
            if (ifVisited(v1) == false) {
                DFS(v1);
            }
        }
    }

    public void BFS(int s) {
        ArrayList<Integer> toVisit = new ArrayList<Integer>();
        toVisit.add(s);
        while (toVisit.size() > 0) {
            int v = toVisit.remove(0);   // first-in, first-visit
            setVisited(v);
            LinkedList<Integer> neighbors = adjList.elementAt(v);
            for (int i = 0; i < neighbors.size(); i ++) {
                int v1 = neighbors.get(i);
                if ( (ifVisited(v1) == false) && (toVisit.contains(v1) == false) ) {
                    toVisit.add(v1);
                }
            }
        }
    }

    public void display() {
        System.out.println("total nodes: " + totalNodes);
        System.out.println("total edges: " + totalEdges);
    }

    public void displayEnum() {
        for (int i = 0; i < nodeEnum.size(); i ++) {
            System.out.print(nodeList.elementAt(nodeEnum.elementAt(i)) + " ");
        }
        System.out.println();
    }
//    public static void main(String argv[]) {
//        AdjGraph g1 = new AdjGraph(true);
//        String[] nodes1 = {"A", "B", "C", "D", "E"};
//        int weight = 1;
//        g1.setVertices(nodes1);
//        g1.setEdge("A", "B", weight);
//        g1.setEdge("B", "C", weight);
//        g1.setEdge("C", "D", weight);
//        g1.setEdge("A", "C", weight);
//
//        //second example: g2
//        AdjGraph g2 = new AdjGraph(true);
//        String[] nodes2 = {"a", "b", "c", "d", "e", "f"};
//        g2.setVertices(nodes2);
//        g2.setEdge("a", "b", 9);
//        g2.setEdge("a", "f", 5);
//        g2.setEdge("a", "e", 3);
//        g2.setEdge("b", "c", 5);
//        g2.setEdge("b", "f", 4);
//        g2.setEdge("c", "d", 2);
//        g2.setEdge("c", "f", 8);
//        g2.setEdge("d", "f", 7);
//        g2.setEdge("d", "e", 1);
//        g2.setEdge("e", "f", 5);
//    }


    // Lab 11 TODO:

    // write your new main() method here:
    public static void main(String argv[]) {
        //In all my graphs I matched the label to the index to make the output easier to read

        AdjGraph g1 = new AdjGraph(true);
        String[] nodes1 = {"0", "1", "2", "3"};
        int weight = 1;
        g1.setVertices(nodes1);
        g1.setEdge("0", "1", weight);
        g1.setEdge("1", "2", weight);
        g1.setEdge("2", "3", weight);
        g1.setEdge("0", "2", weight);
        g1.walk("BFS");
        g1.topologicalSortWithQueue();

        AdjGraph g2 = new AdjGraph(true);
        String[] nodes2 = {"0", "1", "2", "3", "4"};
        g2.setVertices(nodes2);
        g2.setEdge("0", "1", weight);
        g2.setEdge("1", "2", weight);
        g2.setEdge("2", "3", weight);
        g2.setEdge("0", "2", weight);
        g2.walk("BFS");
        g2.topologicalSortWithQueue();

        // Cycle, has no solution
        AdjGraph g3 = new AdjGraph(true);
        String[] nodes3 = {"0", "1", "2", "3", "4"};
        g3.setVertices(nodes3);
        g3.setEdge("0", "1", weight);
        g3.setEdge("1", "2", weight);
        g3.setEdge("2", "3", weight);
        g3.setEdge("3", "4", weight);
        g3.setEdge("4", "0", weight);
        g3.walk("BFS");
        g3.topologicalSortWithQueue();

        // Also cyclic, no solution
        AdjGraph g4 = new AdjGraph(true);
        String[] nodes4 = {"0", "1", "2", "3", "4"};
        g4.setVertices(nodes4);
        g4.setEdge("0", "1", weight);
        g4.setEdge("1", "2", weight);
        g4.setEdge("2", "3", weight);
        g4.setEdge("3", "4", weight);
        g4.setEdge("4", "2", weight);
        g4.walk("BFS");
        g4.topologicalSortWithQueue();

        // This is the example graph from part 2 of the lab instructions
        AdjGraph exGraph = new AdjGraph(true);
        String[] exNodes = {"0", "1", "2", "3", "4", "5", "6"};
        exGraph.setVertices(exNodes);
        exGraph.setEdge("0", "1", weight);
        exGraph.setEdge("0", "2", weight);
        exGraph.setEdge("1", "5", weight);
        exGraph.setEdge("1", "3", weight);
        exGraph.setEdge("2", "3", weight);
        exGraph.setEdge("3", "4", weight);
        exGraph.setEdge("4", "6", weight);
        exGraph.walk("BFS");
        exGraph.topologicalSortWithQueue();
    }


} // end of class AdjGraph