import java.util.Set;

public class HexGrid {
    private Set<Radar> radars; // Set of radar objects in the grid

    // Constructor to initialize the grid with radars
    public HexGrid(Set<Radar> radars) {
        this.radars = radars;
    }

    // Method to calculate intersections between radars' affected areas
    public void calculateIntersections() {
        // Iterate over each pair of radars in the grid
        for (Radar radar1 : radars) {
            for (Radar radar2 : radars) {
                // Skip checking the intersection of the same radar with itself
                if (radar1 != radar2) {
                    // Find the common cells (intersection) between radar1 and radar2
                    Set<HexCell> commonCells = radar1.findIntersection(radar2);
                    // If there are common cells (intersection), print the information
                    if (!commonCells.isEmpty()) {
                        System.out.println("Radar (" + radar1.getPosition().getQ() + ", " + radar1.getPosition().getR() + ") and Radar ("
                                + radar2.getPosition().getQ() + ", " + radar2.getPosition().getR() + ") are intersecting.");
                        // Print the coordinates of each common cell
                        commonCells.forEach(cell ->
                                System.out.println("Cell: (" + cell.getQ() + ", " + cell.getR() + ")"));
                    }
                }
            }
        }
    }
}
