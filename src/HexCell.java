public class HexCell {
    private int q; // x coordinate (axial coordinate for hexagonal grid)
    private int r; // y coordinate (axial coordinate for hexagonal grid)

    // Constructor to initialize the coordinates
    public HexCell(int q, int r) {
        this.q = q;
        this.r = r;
    }

    // Getter for q coordinate
    public int getQ() {
        return q;
    }

    // Getter for r coordinate
    public int getR() {
        return r;
    }

    // Method to calculate the distance between two HexCells
    public int calculateDistance(HexCell other) {
        // Calculate the absolute difference between the q coordinates
        int dq = Math.abs(this.q - other.q);

        // Calculate the absolute difference between the r coordinates
        int dr = Math.abs(this.r - other.r);

        // Calculate the third axial coordinate difference (s coordinate)
        int ds = Math.abs((-this.q - this.r) - (-other.q - other.r));

        // The distance is the maximum of dq, dr, and ds
        return Math.max(dq, Math.max(dr, ds));
    }
}
