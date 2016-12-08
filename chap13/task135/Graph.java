package chap13.task135;

import java.io.IOException;

public class Graph {

    private Knight adjMat[][];
    private int table[][];
    private StackX theStack;
    private int size;

    public Graph(int tableSize) {
        adjMat = new Knight[tableSize][tableSize];
        for(int y = 0; y < tableSize; y++) {
            for(int x = 0; x < tableSize; x++) {
                adjMat[x][y] = null;
            }
        }

        table = new int[tableSize][tableSize];
        for(int y = 0; y < tableSize; y++) {
            for(int x = 0; x < tableSize; x++) {
                table[x][y] = 0;
            }
        }

        size = tableSize;
        theStack = new StackX(tableSize * tableSize);
    }

    public void displayTable() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.print(table[i][j]+ " ");
                }
            System.out.println();
        }
    }


    public void chessProblem() throws IOException {
        boolean trial = false;
        outer:
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                trial = dfs(i, j);
                if (trial) {
                    displayTable();
                    break outer;
                }
            }
        }
        if (!trial) {
            System.out.println("No such possibility");
        }
    }

    public boolean dfs(int x, int y) throws IOException {
        Knight knight = new Knight(this.size);
        knight.setInitialPoint(x, y);
        table[x][y] = 1;
        theStack.push(knight);

        while(!theStack.isEmpty()) {
            /*
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Let's go:");
            String initiate = reader.readLine();
            if(!initiate.equals("")) {
                break;
            }
            displayTable();
            */

            while(true) {
                Vertex tempVertex;
                tempVertex = theStack.peek().getKnightVertex();
                if (tempVertex == null) {
                    Knight tempKnight = theStack.pop();
                    table[tempKnight.initialX][tempKnight.initialY] = 0;
                    break;
                    // That means that current knight have no available move;
                }
                tempVertex = getAvailable(tempVertex.x, tempVertex.y);
                if (tempVertex == null) {
                    continue;
                    // That means that there's a knight at current position;
                } else {
                    Knight tempKnight = new Knight(this.size);
                    tempKnight.setInitialPoint(tempVertex.x, tempVertex.y);
                    table[tempVertex.x][tempVertex.y] = 1;
                    theStack.push(tempKnight);
                    break;
                    // Let's give a current knight one more try;
                }
            }

            if(theStack.isFull()) {
                System.out.println("We are done now!");
                // displayTable();
                return true;
            }
        }
        return false;
    }

    public Vertex getAvailable(int x, int y) {
        if (table[x][y] == 0) {
            return new Vertex(1, x, y);
        } else {
            return null;
        }
    }

    public Vertex getAvailableVertex(int x, int y) {
        int dx = 1;
        int dy = 2;

        if (x + dx < size && y + dy < size && table[x + dx][y + dy] == 0) {
            return new Vertex(1, x + dx, y + dy);

        } else if (x + dx < size && y - dy >= 0 && table[x + dx][y - dy] == 0) {
            return new Vertex(1, x + dx, y - dy);

        } else if (x - dx >= 0 && y - dy >= 0 && table[x - dx][y - dy] == 0) {
            return new Vertex(1, x - dx, y - dy);

        } else if (x - dx >= 0 && y + dy < 0 && table[x - dx][y + dy] == 0) {
            return new Vertex(1, x - dx, y + dy);

        } else if (x + dy < size && y + dx < size && table[x + dy][y + dx] == 0) {
            return new Vertex(1, x + dy, y + dx);

        } else if (x + dy < size && y - dx >= 0 && table[x + dy][y - dx] == 0) {
            return new Vertex(1, x + dy, y - dx);

        } else if (x - dy >= 0 && y - dx >= 0 && table[x - dy][y - dx] == 0) {
            return new Vertex(1, x - dy, y - dx);

        } else if (x - dy >= 0 && y + dx < size && table[x - dy][y + dx] == 0) {
            return new Vertex(1, x - dy, y + dx);

        } else {
            return null;
        }
    }
}
