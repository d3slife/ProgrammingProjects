package chap14.task142;

public class Graph {

    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex vertexList[];
    // private int adjMat[][];
    private int nVerts;
    private int nTree;
    private int sPath[];
    private int currentVert;
    private int startToCurrent;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        nVerts = 0;
        nTree = 0;
        sPath = new int[MAX_VERTS];
    }

    public void addVertex(char lab) {
        vertexList[nVerts] = new Vertex(lab);
        for(int i = 0; i < vertexList[nVerts].getListLength(); i++) {
            Edge tempEdge = new Edge();
            tempEdge.setWeight(INFINITY);
            vertexList[nVerts].setEdge(tempEdge, i);
        }
        nVerts++;
    }

    public void addEdge(int start, int end, int weight) {
        Edge tempEdge = new Edge();
        tempEdge.setWeight(weight);
        tempEdge.setEndVert(start);
        vertexList[start].setEdge(tempEdge, end);
        // sPath[end] = weight;
    }

    public void path() {
        int startTree = 0;
        vertexList[startTree].isInTree = true;
        nTree = 1;

        for(int j = 0; j < nVerts; j++) {
            int tempDist = vertexList[startTree].getEdgeWeight(j);
            sPath[j] = tempDist;
        }

        while(nTree < nVerts) {
            int indexMin = getMin();
            int minDist = sPath[indexMin];

            if(minDist == INFINITY) {
                System.out.println("There are unreachable vertices");
                break;
            } else {
                currentVert = indexMin;
                startToCurrent = sPath[indexMin];
            }
            vertexList[currentVert].isInTree = true;
            nTree++;
            adjust_sPath();
        }

        displayPaths();

        nTree = 0;
        for(int j = 0; j < nVerts; j++) {
            vertexList[j].isInTree = false;
        }
    }

    public int getMin() {
        int minDist = INFINITY;
        int indexMin = 0;
        for(int j = 1; j < nVerts; j++) {
            if(!vertexList[j].isInTree &&
                    sPath[j] < minDist) {
                minDist = sPath[j];
                indexMin = j;
            }
        }
        return indexMin;
    }

    public void adjust_sPath() {

        int column = 1;
        while(column < nVerts) {
            if(vertexList[column].isInTree) {
                column++;
                continue;
            }

            int currentToFringe = vertexList[currentVert].getEdgeWeight(column);
            int startToFringe = startToCurrent + currentToFringe;
            int sPathDist = sPath[column];

            if(startToFringe < sPathDist) {
                sPath[column] = startToFringe;
                vertexList[0].setEdgeParent(currentVert, column);
            }
            column++;
        }
    }

    public void displayPaths() {
        for(int j = 0; j < nVerts; j++) {
            System.out.print(vertexList[j].label + "=");
            if(sPath[j] == INFINITY) {
                System.out.print("inf");
            } else {
                System.out.print(sPath[j]);
            }
            char parent = vertexList[vertexList[0].getCurEdge(j).getEndVert()].label;
            System.out.print("(" + parent + ") ");
        }
        System.out.println("");
    }
}
