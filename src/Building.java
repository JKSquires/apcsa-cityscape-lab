import java.awt.Graphics2D;

import java.awt.Color;

import java.awt.geom.Ellipse2D;
import java.awt.Polygon;

/**
 * Building in the city
 *
 * @author jksquires
 * @version 1216241455
 */
public class Building
{
    private Color buildingColor;
    private Color darkBuildingColor;
    
    private Vertex[] verticies;
    
    private int drawOrder;
    
    /**
     * Constructor for objects of class Building
     * 
     * @param leftSide if the building is on the left or right side
     * @param startForward if the building started in the front
     */
    public Building(boolean leftSide, int startOrder, Color col)
    {
        this.verticies = new Vertex[6];
        
        this.buildingColor = col;
        this.drawOrder = startOrder + 1;
        
        this.darkBuildingColor = col.darker();
        
        if(leftSide) {
            this.verticies[0] = new Vertex(-50,50,90);
            this.verticies[1] = new Vertex(-50,-50,90);
            this.verticies[2] = new Vertex(-100,-50,90);
            this.verticies[3] = new Vertex(-100,50,90);
            this.verticies[4] = new Vertex(-50,50,105);
            this.verticies[5] = new Vertex(-50,-50,105);
        } else { // building on right side; just mirrored over y-axis (x = -x)
            this.verticies[0] = new Vertex(50,50,90);
            this.verticies[1] = new Vertex(50,-50,90);
            this.verticies[2] = new Vertex(100,-50,90);
            this.verticies[3] = new Vertex(100,50,90);
            this.verticies[4] = new Vertex(50,50,105);
            this.verticies[5] = new Vertex(50,-50,105);
        }
        
        // arrange starting order for the building(-30 is spacing)
        for(Vertex vertex : this.verticies) {
            vertex.zMove(-30 * startOrder);
        }
    }
    /**
     * Resets the position of the building
     */
    public void resetBuilding() {
        this.move(120);
    }
    /**
     * Draw the building to the graphics 2d.
     * 
     * @param g graphics object
     */
    public void draw(Graphics2D g) {
        g.setPaint(this.buildingColor);
        
        int[][] allPoints = {verticies[0].pointDrawPos(),verticies[4].pointDrawPos(),verticies[5].pointDrawPos(),verticies[1].pointDrawPos(),verticies[2].pointDrawPos(),verticies[3].pointDrawPos()};
        
        int[] sideX = {allPoints[0][0],allPoints[1][0],allPoints[2][0],allPoints[3][0]};
        int[] sideY = {allPoints[0][1],allPoints[1][1],allPoints[2][1],allPoints[3][1]};
        int[] frontX = {allPoints[0][0],allPoints[3][0],allPoints[4][0],allPoints[5][0]};
        int[] frontY = {allPoints[0][1],allPoints[3][1],allPoints[4][1],allPoints[5][1]};
        
        Polygon buildingSide = new Polygon(sideX, sideY, 4);
        Polygon buildingFront = new Polygon(frontX, frontY, 4);
        
        g.fill(buildingSide);
        
        g.setPaint(this.darkBuildingColor);
        g.fill(buildingFront);
    }
    /**
     * Returns the order in which this building should be drawn
     * 
     * @return the draw order for this building
     */
    public int getDrawOrder() {
        return this.drawOrder;
    }
    /**
     * Moves the building according to the given amount
     * 
     * @param amount the amount to move the building by.
     */
    public void move(int amount) {
        for(Vertex vertex : this.verticies) {
            vertex.zMove(amount);
        }
        
        int v6Z = this.verticies[5].getPos()[2];
        if(v6Z <= 0) { // includes < just in case
            this.drawOrder = 0; // move to the back
            this.resetBuilding();
        } else if(v6Z == 15) {
            this.drawOrder = 4;
        } else if(v6Z == 45) {
            this.drawOrder = 3;
        } else if(v6Z == 75) {
            this.drawOrder = 2;
        }
    }
    /**
     * Returns all of the verticies for this Building
     * 
     * @return an array containing all of the verticies for this Building
     */
    public Vertex[] getVerticies() {
        return this.verticies;
    }
}
