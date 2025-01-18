import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Let's define the positions of the radars
        HexCell radar1Position = new HexCell(0, 0); // Position of radar 1
        HexCell radar2Position = new HexCell(2, 2); // Position of radar 2
        HexCell radar3Position = new HexCell(5, 5); // Position of radar 3

        // Create the radars with different radii
        Radar radar1 = new Radar(radar1Position, 3);  // Radar 1 with radius 3
        Radar radar2 = new Radar(radar2Position, 2);  // Radar 2 with radius 2
        Radar radar3 = new Radar(radar3Position, 1);  // Radar 3 with radius 1

        // We store the radars in a grid (set)
        Set<Radar> radars = new HashSet<>();
        radars.add(radar1);
        radars.add(radar2);
        radars.add(radar3);

        // Create a HexGrid to manage radar interactions
        HexGrid grid = new HexGrid(radars);

        // Print the affected cells for each radar
        System.out.println("Radar's Affected Areas:");
        for (Radar radar : radars) {
            Set<HexCell> affectedCells = radar.getAffectedCells(); // Get affected cells for each radar
            System.out.println("Radar (" + radar.getPosition().getQ() + ", " + radar.getPosition().getR() + ") affected cells:");
            for (HexCell cell : affectedCells) {
                System.out.println("Cell: (" + cell.getQ() + ", " + cell.getR() + ")");
            }
        }

        // Print intersections between radars
        System.out.println("\nIntersections Between Radars:");
        grid.calculateIntersections(); // Calculate and print the intersections between radars
    }
}
