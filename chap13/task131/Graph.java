package chap13.task131;

public class Graph {

    private final int MAX_VERTS = 20;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private Queue theQueue;

    public Graph() {
        this.vertexList = new Vertex[this.MAX_VERTS];
        this.adjMat = new int[this.MAX_VERTS][this.MAX_VERTS];
        this.nVerts = 0;

        for(int j = 0; j < this.MAX_VERTS; j++) {
            for(int k = 0; k < this.MAX_VERTS; k++) {
                this.adjMat[j][k] = 0;
            }
        }
        this.theQueue = new Queue();
    }

    public void addVertex(char lab) {
        this.vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        this.adjMat[start][end] = 1;
        this.adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(this.vertexList[v].label);
    }

    public void bfs() {
        this.vertexList[0].wasVisited = true;
        displayVertex(0);
        this.theQueue.insert(0);
        int v2;

        while(!this.theQueue.isEmpty()) {
            int v1 = this.theQueue.remove();

            while((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                this.vertexList[v2].wasVisited = true;
                displayVertex(v2);
                this.theQueue.insert(v2);
            }
        }

        for(int j = 0; j < nVerts; j++) {
            this.vertexList[j].wasVisited = false;
        }
    }

    // Task 131. Minimum spanning tree;
    public void mst() {
        this.vertexList[0].wasVisited = true;
        this.theQueue.insert(0);
        int v2;

        while(!this.theQueue.isEmpty()) {
            int v1 = this.theQueue.remove();

            while((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                this.vertexList[v2].wasVisited = true;
                displayVertex(v1);
                displayVertex(v2);
                System.out.print(" ");
                this.theQueue.insert(v2);
            }
        }
    }

    public int getAdjUnvisitedVertex(int v) {
        for(int j = 0; j < this.MAX_VERTS; j++) {
            if(this.adjMat[v][j] == 1 && this.vertexList[j].wasVisited == false) {
                return j;
            }
        }
        return -1;
    }
}
