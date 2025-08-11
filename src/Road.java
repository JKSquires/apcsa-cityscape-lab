import java.awt.Graphics2D;

import java.awt.Color;

import java.awt.Polygon;

/**
 * Road with 4 corners
 *
 * @author jksquires
 * @version 1216241455
 */
public class Road
{
    private Vertex[] verticies;
    
    private Color color;
    
    /**
     * Road constructor
     * 
     * @param x x position of the center of the road
     * @param y y position of the road
     * @param w width of the road
     * @param minZ minimum value for the z direction of the road
     * @param maxZ maximum value for the z direction of the road
     * @param rdColor the road color
     */
    public Road(int x, int y, int w, int minZ, int maxZ, Color rdColor)
    {
        verticies = new Vertex[4]; // 0 - NE; 1 - SE; 2 - SW; 3 - NW
        
        int sideWidth = w / 2;
        this.verticies[0] = new Vertex(sideWidth, y, maxZ);
        this.verticies[1] = new Vertex(sideWidth, y, minZ);
        this.verticies[2] = new Vertex(-sideWidth, y, minZ);
        this.verticies[3] = new Vertex(-sideWidth, y, maxZ);
        
        this.color = rdColor;
    }
    /**
     * Draw the building to the graphics 2d.
     * 
     * @param g graphics object
     */
    public void draw(Graphics2D g) {
        g.setPaint(this.color);
        
        int[][] allPoints = {this.verticies[0].pointDrawPos(), this.verticies[1].pointDrawPos(), this.verticies[2].pointDrawPos(), this.verticies[3].pointDrawPos()};
        
        int[] xPoints = {allPoints[0][0], allPoints[1][0], allPoints[2][0], allPoints[3][0]};
        int[] yPoints = {allPoints[0][1], allPoints[1][1], allPoints[2][1], allPoints[3][1]};
        
        g.fill(new Polygon(xPoints, yPoints, 4));
    }
}
