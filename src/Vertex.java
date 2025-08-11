
/**
 * A vertex point in a 3d plane (3 values: x, y, z)
 *
 * @author jksquires
 * @version 1212241717
 */
public class Vertex
{
    private double scale = 50.0;

    private int[] pos;
    
    /**
     * Constructor for the vertex
     * 
     * @param x x position
     * @param y y position
     * @param z z position
     */
    public Vertex(int x, int y, int z) {
        this.pos = new int[] {x, y, z};
    }
    /**
     * Change z position by given amount
     * 
     * @param amount the amount to change the z position by
     */
    public void zMove(int amount) {
        this.pos[2] += amount;
    }
    /**
     * Returns an array with the coordinates of the Vertex
     * 
     * @return array containing x,y,z coordinates
     */
    public int[] getPos() {
        int[] pos = {this.pos[0], this.pos[1], this.pos[2]};
        
        return pos;
    }
    /**
     * Calculates where the vertex should be drawn with depth included
     * 
     * @return the x and y position on the screen where the point should be drawn
     */
    public int[] pointDrawPos() {
        int[] pos = {-1,-90}; // upper left corner (y=-90 was picked because it worked)
        
        int[] vPos = this.getPos(); // no need to keep calling v.getPos()
        
        if(vPos[2] > 0) { // check if the vertex is in front of view (z > 0)
            pos[0] = (int) (scale * (1.0 * vPos[0] / vPos[2])); // X = 50 * (x / z)
            pos[1] = (int) (scale * (1.0 * vPos[1] / vPos[2])); // Y = 50 * (y / z)
        } else { // if the vertex is behind the view, then visual vertex position is calculated for a z position very close to the camera
            pos[0] = (int) (scale * (0.2 * vPos[0])); // X = 50 * (0.2 * x)
            pos[1] = (int) (scale * (0.2 * vPos[1])); // Y = 50 * (0.2 * y)
        }
        
        // centering is really weird: center of the screen is around (315, 255); JFrame size: (640, 480)
        pos[0] += 315;
        pos[1] += 225;
        
        return pos;
    }
}
