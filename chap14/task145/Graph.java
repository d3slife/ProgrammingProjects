package chap14.task145;

public class Graph {

    private final int MAX_VERTS = 10;
    private final int INFINITY = 1000000;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private int nTree;
    private DistPar sPath[];
    private int currentVert;
    private int startToCurrent;
    private Anagram anagram;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];

        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        nTree = 0;
        for(int j = 0; j < MAX_VERTS; j++)
            for(int k = 0; k < MAX_VERTS; k++)
                adjMat[j][k] = INFINITY;
        sPath = new DistPar[MAX_VERTS];
    }

    public void displayMatrix() {
        for(int j = 0; j < nVerts; j++) {
            for(int k = 0; k < nVerts; k++) {
                if (adjMat[j][k] < INFINITY) {
                    System.out.print(adjMat[j][k] + " ");
                } else {
                    System.out.print(-1 + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
        // Let's make it non directed;
        adjMat[end][start] = weight;
    }

    public void path() {
        int startTree = 0;
        vertexList[startTree].isInTree = true;
        nTree = 1;

        for(int j = 0; j < nVerts; j++) {
            int tempDist = adjMat[startTree][j];
            sPath[j] = new DistPar(startTree, tempDist);
        }

        while(nTree < nVerts) {
            int indexMin = getMin();
            int minDist = sPath[indexMin].distance;

            if(minDist == INFINITY) {
                System.out.println("There are unreachable vertices");
                break;
            } else {
                currentVert = indexMin;
                startToCurrent = sPath[indexMin].distance;

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
        for(int j=1; j<nVerts; j++) {
            if( !vertexList[j].isInTree &&
                    sPath[j].distance < minDist ) {
                minDist = sPath[j].distance;
                indexMin = j;
            }
        }
        return indexMin;
    }

    public void adjust_sPath() {

        int column = 1;
        while(column < nVerts) {
            if( vertexList[column].isInTree ) {
                column++;
                continue;
            }

            int currentToFringe = adjMat[currentVert][column];
            int startToFringe = startToCurrent + currentToFringe;
            int sPathDist = sPath[column].distance;

            if(startToFringe < sPathDist) {
                sPath[column].parentVert = currentVert;
                sPath[column].distance = startToFringe;
            }
            column++;
        }
    }

    public void displayPaths() {
        for(int j = 0; j < nVerts; j++) {
            System.out.print(vertexList[j].label + "=");
            if(sPath[j].distance == INFINITY) {
                System.out.print("inf");
            } else {
                System.out.print(sPath[j].distance);
            }
            char parent = vertexList[sPath[j].parentVert].label;
            System.out.print("(" + parent + ") ");
        }
        System.out.println("");
    }

    // Task 144. Salesman problem;
    // Task 145. It's almost the same task. weight will be used to indicate whether there's direct connection
    // between vertices. Also output is corrected a little bit;

    public void salesmanProblem() {
        char[] charArray = new char[nVerts];
        for(int i = 0; i < nVerts; i++) {
            charArray[i] = vertexList[i].label;
        }
        anagram = new Anagram(charArray);
        char[][] distanceArr = anagram.getMatrixChar();

        int totalLength = 0;
        int initPoint = 0;
        int termPoint = 0;
        for(int i = 0; i < distanceArr.length; i++) {
            for(int j = 0; j < distanceArr[0].length - 1; j++) {

                int firstVertex = 0;
                int secondVertex = 0;

                for(int k = 0; k < nVerts; k++) {
                    if (distanceArr[i][j] == vertexList[k].label) {
                        firstVertex = k;
                        if (j == 0) {
                            initPoint = firstVertex;
                        }
                    }
                    if (distanceArr[i][j + 1] == vertexList[k].label) {
                        secondVertex = k;
                        if (j == distanceArr[0].length - 2) {
                            termPoint = secondVertex;
                        }
                    }
                }
                totalLength += adjMat[firstVertex][secondVertex];
            }
            totalLength += adjMat[termPoint][initPoint];
            if (totalLength < INFINITY) {
                String s = new String(distanceArr[i]) + String.valueOf(distanceArr[i][0]);
                System.out.println("Existing hamiltonian cycle: " + s);
            }
            totalLength = 0;
        }
    }
}
