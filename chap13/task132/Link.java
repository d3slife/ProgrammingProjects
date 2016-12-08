package chap13.task132;

public class Link {
    public Vertex vertex;
    public Link next;

    public Link(Vertex vertex) {
        this.vertex = vertex;
        next = null;
    }

    public void displayLink() {
        System.out.print(vertex.label);
    }
}
