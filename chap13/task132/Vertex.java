package chap13.task132;

public class Vertex {

    public char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }

    public int getInt() {
        return (int) (label - 65);
    }
}
