package chap14.task141;

public class GraphApp {

    public static void main(String[] args) {

        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');

        theGraph.addEdge(0, 1, 50);
        theGraph.addEdge(0, 3, 80);
        theGraph.addEdge(1, 2, 60);
        theGraph.addEdge(1, 3, 90);
        theGraph.addEdge(2, 4, 40);
        theGraph.addEdge(3, 2, 20);
        theGraph.addEdge(3, 4, 70);
        theGraph.addEdge(4, 1, 50);

        // Let's add a new edge from E to A;
        // And why are we doing so? Cuz if there's no directed edge to A we'll get "There are unreachable vertices";
        // to every vertex except A;
        // theGraph.addEdge(4, 0, 20);

        System.out.println("Shortest paths: ");
        theGraph.anyVertexPath();
        System.out.println();
    }
}
