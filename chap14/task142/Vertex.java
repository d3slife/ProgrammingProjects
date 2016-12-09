package chap14.task142;

public class Vertex {

    public char label;
    public boolean isInTree;
    private final int MAX_EDGE_NUM = 20;
    private Edge[] edgeList;
    // private int edgeNum;

    public Vertex(char label) {
        this.label = label;
        this.isInTree = false;

        // Just let's assume that a single Vertex cannot be connected more than to 20 vertices;
        this.edgeList = new Edge[MAX_EDGE_NUM];
        // this.edgeNum = 0;
    }

    // New method to add an edge to current vertex list;
    public void setEdge(Edge newEdge, int index) {
        this.edgeList[index] = newEdge;
    }

    public void setEdgeParent(int vertex, int index) {
        this.edgeList[index].setEndVert(vertex);
    }

    public int getEdgeWeight(int index) {
        return edgeList[index].getWeight();
    }

    public int getListLength() {
        return this.edgeList.length;
    }

    public Edge getCurEdge(int index) {
        return edgeList[index];
    }
}
