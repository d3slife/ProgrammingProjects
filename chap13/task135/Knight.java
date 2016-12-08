package chap13.task135;

public class Knight {

    private Vertex[][] knightTable;
    private int size;
    public int initialX;
    public int initialY;

    public Knight(int tableSize) {
        this.size = tableSize;
        knightTable = new Vertex[tableSize][tableSize];
        for(int i = 0; i < tableSize; i++) {
            for(int j = 0; j < tableSize; j++) {
                knightTable[i][j] = new Vertex(0, -1, -1);
            }
        }
    }

    public void setInitialPoint(int x, int y) {
        knightTable[x][y].label = 1;
        knightTable[x][y].x = x;
        knightTable[x][y].y = y;
        initialX = x;
        initialY = y;
        knightTable[x][y].wasVisited = true;
    }

    public boolean wasVisited(int x, int y) {
        return knightTable[x][y].wasVisited;
    }

    public void setVisitedVertex(int x, int y) {
        knightTable[x][y].wasVisited = true;
    }

    public Vertex getKnightVertex() {
        int dx = 1;
        int dy = 2;
        int x = initialX;
        int y = initialY;

        if (x + dx < size && y + dy < size && knightTable[x + dx][y + dy].wasVisited == false) {
            knightTable[x + dx][y + dy].wasVisited = true;
            return new Vertex(1, x + dx, y + dy);

        } else if (x + dx < size && y - dy >= 0 && knightTable[x + dx][y - dy].wasVisited == false) {
            knightTable[x + dx][y - dy].wasVisited = true;
            return new Vertex(1, x + dx, y - dy);

        } else if (x - dx >= 0 && y - dy >= 0 && knightTable[x - dx][y - dy].wasVisited == false) {
            knightTable[x - dx][y - dy].wasVisited = true;
            return new Vertex(1, x - dx, y - dy);

        } else if (x - dx >= 0 && y + dy < 0 && knightTable[x - dx][y + dy].wasVisited == false) {
            knightTable[x - dx][y + dy].wasVisited = true;
            return new Vertex(1, x - dx, y + dy);

        } else if (x + dy < size && y + dx < size && knightTable[x + dy][y + dx].wasVisited == false) {
            knightTable[x + dy][y + dx].wasVisited = true;
            return new Vertex(1, x + dy, y + dx);

        } else if (x + dy < size && y - dx >= 0 && knightTable[x + dy][y - dx].wasVisited == false) {
            knightTable[x + dy][y - dx].wasVisited = true;
            return new Vertex(1, x + dy, y - dx);

        } else if (x - dy >= 0 && y - dx >= 0 && knightTable[x - dy][y - dx].wasVisited == false) {
            knightTable[x - dy][y - dx].wasVisited = true;
            return new Vertex(1, x - dy, y - dx);

        } else if (x - dy >= 0 && y + dx < size && knightTable[x - dy][y + dx].wasVisited == false) {
            knightTable[x - dy][y + dx].wasVisited = true;
            return new Vertex(1, x - dy, y + dx);

        } else {
            return null;
        }
    }
}
