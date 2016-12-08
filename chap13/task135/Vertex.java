package chap13.task135;

public class Vertex {

    public int label;
    public boolean wasVisited;
    public int x;
    public int y;

    public Vertex(int label, int x, int y) {
        this.label = label;
        this.wasVisited = false;
        this.x = x;
        this.y = y;
    }
}
