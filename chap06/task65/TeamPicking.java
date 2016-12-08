package chap06.task65;

public class TeamPicking {

    private int groupSize;
    private int teamSize;
    private String[] array;
    private String current;

    public TeamPicking(int groupSize, int teamSize) {
        this.groupSize = groupSize;
        this.teamSize = teamSize;
        current = "";
        generateGroup(this.groupSize);
        displayGroup();
        showTeams(this.groupSize, this.teamSize, this.current);
    }

    public void showTeams(int groupSize, int teamSize, String current) {
        if (groupSize <= 0 || teamSize <= 0) {
            // System.out.println("If zero or less");
            System.out.println("Possible combination: " + current);
        } else if (groupSize == 1 && teamSize == 1) {
            // System.out.println("GroupSize is: " + groupSize + "; TeamSize is: " + teamSize);
            // System.out.println("Array element: " + array[array.length - groupSize]);
            current += array[array.length - groupSize];
            // System.out.println("If equals one");
            System.out.println("Possible combination: " + current);
        } else if (groupSize < teamSize) {
            // System.out.println("If has no sense");
            System.out.println("Dead end");
        } else {
            // System.out.println("GroupSize is: " + groupSize + "; TeamSize is: " + teamSize);
            // System.out.println("Array element: " + array[array.length - groupSize]);
            // System.out.println("Current is: " + current);
            showTeams(groupSize - 1, teamSize - 1, current + array[array.length - groupSize]);
            showTeams(groupSize - 1, teamSize, current);
        }
    }

    public void generateGroup(int groupSize) {
        array = new String[groupSize];
        for(int i = 0; i < groupSize; i++) {
            array[i] = Character.toString((char) (i + 65));
        }
    }

    public void displayGroup() {
        System.out.print("Group of elements to proceed: ");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "; ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TeamPicking team = new TeamPicking(5, 3);
    }
}
