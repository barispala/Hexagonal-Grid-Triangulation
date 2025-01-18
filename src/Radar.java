import java.util.HashSet;
import java.util.Set;

public class Radar {
    private HexCell position; // Position of the radar
    private int radius;       // Radius of the radar

    // Constructor to initialize the radar with a position and radius
    public Radar(HexCell position, int radius) {
        this.position = position;
        this.radius = radius;
    }

    // Getter for the position of the radar
    public HexCell getPosition() {
        return position;
    }

    // Getter for the radius of the radar
    public int getRadius() {
        return radius;
    }

    // Method to calculate the cells affected by the radar's range
    public Set<HexCell> getAffectedCells() {
        Set<HexCell> cells = new HashSet<>();
        // Loop through possible cells within the radius of the radar
        for (int q = -radius; q <= radius; q++) {
            for (int r = -radius; r <= radius; r++) {
                // Create a new cell at the calculated position
                HexCell cell = new HexCell(position.getQ() + q, position.getR() + r);
                // If the cell is within the radar's distance, add it to the set
                if (position.calculateDistance(cell) <= radius) {
                    cells.add(cell); // Add the cell if it is within the radar's range
                }
            }
        }
        return cells; // Return the set of affected cells
    }

    // Method to find the intersection of cells affected by two radars
    public Set<HexCell> findIntersection(Radar other) {
        // Get the affected cells of both radars
        Set<HexCell> thisCells = this.getAffectedCells();
        Set<HexCell> otherCells = other.getAffectedCells();
        // Retain only the cells that are common in both sets (intersection)
        thisCells.retainAll(otherCells);
        return thisCells; // Return the intersection of the cells
    }
}
