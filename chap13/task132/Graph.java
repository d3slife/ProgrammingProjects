package chap13.task132;

public class Graph {

    private final int MAX_VERTS = 20;
    private Vertex[] vertexList;
    private LinkedList[] list;
    private int nVerts;
    private StackX theStack;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        list = new LinkedList[MAX_VERTS];
        nVerts = 0;
        theStack = new StackX();
    }

    public void addVertex(char lab) {
        vertexList[nVerts] = new Vertex(lab);
        list[nVerts] = new LinkedList(vertexList[nVerts]);
        nVerts++;
    }

    public void addEdge(int start, int end) {
        list[start].insertFirst(vertexList[end]);
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while(!theStack.isEmpty()) {

            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        for(int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }

    public int getAdjUnvisitedVertex(int v) {
        return list[v].find();
    }
}
