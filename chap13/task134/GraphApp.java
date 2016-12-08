package chap13.task134;

public class GraphApp {

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0, 2);
        graph.addEdge(1, 0);
        graph.addEdge(1, 4);
        graph.addEdge(4, 2);
        graph.addEdge(3, 4);
        graph.dispMatrix();

        graph.warshAlgor();
        graph.dispMatrix();
    }
}
