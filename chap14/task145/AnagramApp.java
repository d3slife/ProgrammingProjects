package chap14.task145;

public class AnagramApp {

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0, 1, 91);
        graph.addEdge(0, 2, 62);
        graph.addEdge(0, 3, 55);
        graph.addEdge(1, 4, 31);
        graph.addEdge(1, 2, 44);
        graph.addEdge(2, 4, 45);
        graph.addEdge(2, 3, 52);
        graph.addEdge(3, 4, 83);

        graph.salesmanProblem();

    }
}
