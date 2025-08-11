import java.awt.Graphics2D;

import java.awt.Color;

import java.awt.Polygon;

/**
 * Lines in the road!
 *
 * @author jksquires
 * @version 1217241430
 */
public class RoadLine
{
    private Vertex[] verticies;
    
    private Color color;
    
    /**
     * Constructor for a road line
     * 
     * @param x x position of the center of the line
     * @param y y position of the center of the line
     * @param z z position of the center of the line
     * @param width width of the line
     * @param length length of the line
     * @param lnColor the line color
     */
    public RoadLine(int x, int y, int z, int width, int length, Color lnColor) {
        this.verticies = new Vertex[4]; // 0 - NE; 1 - SE; 2 - SW; 3 - NW
        
        int sideWidth = width / 2;
        int sideLength = length / 2;
        this.verticies[0] = new Vertex(x + sideWidth, y, z + sideLength);
        this.verticies[1] = new Vertex(x + sideWidth, y, z - sideLength);
        this.verticies[2] = new Vertex(x -   sideWidth, y, z - sideLength);
        this.verticies[3] = new Vertex(x - sideWidth, y, z + sideLength);
        
        this.color = lnColor;
    }
    
    /**
     * Moves the road line according to the given amount
     * 
     * @param amount the amount to move the road line by.
     */
    public void move(int amount) {
        for(Vertex vertex : this.verticies) {
            vertex.zMove(amount);
        }
        
        if(verticies[0].getPos()[2] < 0) {
            this.resetRoadLine();
        }
    }
    
    /**
     * Resets the position of the road line
     */
    public void resetRoadLine() {
        this.move(120);
    }
    
    /**
     * Draw the road line to the graphics 2d.
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
