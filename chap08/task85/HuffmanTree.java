package chap08.task85;

// Decoding routine was intentionally left unsolved due to its simplicity;

public class HuffmanTree {

    private int count;
    private Node[] nArray;
    private TreesQueue trQueue;
    private int minFreq = 0;
    private String enString = "";
    private String deString = "";

    public static void main(String[] args) {

        HuffmanTree hTree = new HuffmanTree();
        String initialString = "susie+says+it+is+easy*";

        hTree.stringToNodes(initialString);
        hTree.freqTable();
        hTree.trArray();
        hTree.createHuffman();

        Tree finalTree = hTree.trQueue.delete();
        finalTree.displayTree();

        hTree.codeTable(finalTree.getRoot(), "");
        hTree.displayCodeTable();

        // Let's encode our string;
        hTree.encode(initialString);
        hTree.decode(hTree.getEnString());

        // Finally printing out decoded string;
        System.out.println(hTree.getDeString());
    }

    public Node[] stringToNodes(String s) {

        this.nArray = new Node[s.length()];     // Presume that each character is unique in a string;
        this.count = 0;                         // It's a good idea to count how many unique characters really are;

        String line = s;
        while (line.length() > 0) {

            String symbol = line.substring(0, 1);
            int freq = line.length() - line.replace(symbol, "").length();
            line = line.replace(symbol, "");    // Replacing existing String with a new one;

            if (freq < this.minFreq) {
                this.minFreq = freq;
            }

            nArray[count] = new Node(symbol, freq);
            count++;
        }

        return nArray;
    }

    // Displays frequency table;
    public void freqTable() {
        for(int i = 0; i < this.count; i++) {
            this.nArray[i].displayNode();
        }
    }

    private void trArray() {

        this.trQueue = new TreesQueue(this.count);

        for(int i = 0; i < this.count; i++) {
            Tree newTree = new Tree(nArray[i]);
            trQueue.insert(newTree);
        }
    }

    private void createHuffman() {

        while (this.trQueue.getElemN() > 1) {
            Tree newTree = new Tree(new Node("!", 0));
            Tree leftTree = trQueue.delete();
            Tree rightTree = trQueue.delete();

            newTree.getRoot().leftChild = leftTree.getRoot();
            newTree.getRoot().rightChild = rightTree.getRoot();
            newTree.totalFreq = leftTree.totalFreq + rightTree.totalFreq;

            this.trQueue.insert(newTree);
        }
    }

    private void codeTable(Node node, String code) {
        if (node == null) {
            return;
        }
        if (node.s.equals("!")) {
            codeTable(node.leftChild, code + "0");
            codeTable(node.rightChild, code + "1");
        } else {
            node.code = code;
        }
    }

    private void displayCodeTable() {
        for(int i = 0; i < this.count; i++) {
            this.nArray[i].displayCode();
        }
    }

    private void encode(String message) {

        String line = message;
        while(line.length() > 0) {

            String symbol = line.substring(0, 1);
            line = line.substring(1);

            for(int i = 0; i < nArray.length; i++) {
                String nSymbol = nArray[i].s;
                if (nSymbol.equals(symbol)) {
                    this.enString += nArray[i].code + " ";
                    break;
                }
            }
        }

        System.out.println("Encoded line: ");
        System.out.println(this.enString);
    }

    private void decode(String codedString) {

        String line = codedString;
        String deString = "";

        while(line.length() > 0) {

            String symbol = line.substring(0, 1);
            deString += symbol;
            line = line.substring(1);

            if (symbol.equals(" ")) {

                for(int i = 0; i < nArray.length; i++) {
                    String initString = deString.substring(0, deString.length() - 1);

                    if (nArray[i].code.equals(initString)) {
                        this.deString += nArray[i].s;
                        deString = "";
                        break;
                    }
                }
            }
        }
    }

    public String getEnString() {
        return this.enString;
    }

    public String getDeString() {
        return this.deString;
    }
}