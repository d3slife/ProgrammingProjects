package chap13.task134;

public class Graph {

    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private StackX theStack;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int y = 0; y < MAX_VERTS; y++) {
            for(int x = 0; x < MAX_VERTS; x++) {
                adjMat[x][y] = 0;
            }
        }
        theStack = new StackX();
    }

    public void dispMatrix() {
        for(int y = 0; y < nVerts; y++) {
            for(int x = 0; x < nVerts; x++) {
                System.out.print(adjMat[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void dfs(int startingPoint) {
        vertexList[startingPoint].wasVisited = true;
        displayVertex(startingPoint);
        theStack.push(startingPoint);

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

    public void connectTable() {
        for(int i = 0; i < nVerts; i++) {
            dfs(i);
            System.out.println("");
        }
    }

    public void warshAlgor() {

        for(int y = 0; y < nVerts; y++) {
            for(int x = 0; x < nVerts; x++) {
                if (adjMat[y][x] == 1) {
                    for(int z = 0; z < nVerts; z++) {
                        if(adjMat[z][y] == 1) {
                            addEdge(z, x);
                        }
                    }
                }
            }
        }
    }

    public int getAdjUnvisitedVertex(int v) {
        for(int j = 0; j < nVerts; j++) {
            if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
                return j;
            }
        }
        return -1;
    }
}
