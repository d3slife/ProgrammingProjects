package chap13.task131;

public class GraphApp {

    public static void main(String[] args) {

        Graph graph = new Graph();

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addVertex('I');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(0, 6);
        graph.addEdge(0, 7);
        graph.addEdge(7, 8);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 6);
        graph.addEdge(3, 8);

        System.out.print("Minimum spanning tree: ");
        graph.mst();
    }
}
