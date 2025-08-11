import javax.swing.JComponent;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Color;

/**
 * Class that creates instances of the classes that comprise the cityscape and delegates drawing the
 *  cityscape to these object.
 * 
 * @author jksquires
 * @version 1217241430
 */
public class CityscapeComponent extends JComponent
{
    private Sky sky;
    
    private Ground ground;
    
    private Road road;
    
    private RoadLine[] roadLines;
    
    private Building[] buildings;
    
    
    /**
     * Default constructor for CityscapeComponent
     */
    public CityscapeComponent() {
        this.buildings = new Building[8];
        
        Color buildingColor1 = new Color(0,176,255);
        Color buildingColor2 = new Color(75,240,75);
        this.buildings[0] = new Building(true, 0, buildingColor1);
        this.buildings[1] = new Building(true, 1, buildingColor2);
        this.buildings[2] = new Building(true, 2, buildingColor1);
        this.buildings[3] = new Building(true, 3, buildingColor2);
        this.buildings[4] = new Building(false, 0, buildingColor2);
        this.buildings[5] = new Building(false, 1, buildingColor1);
        this.buildings[6] = new Building(false, 2, buildingColor2);
        this.buildings[7] = new Building(false, 3, buildingColor1);
        
        Color sunColor = new Color(255, 255, 0);
        Color[] skyColors = {new Color(255, 200, 0), new Color(255, 100, 32)};
        this.sky = new Sky(315, 225, 50, sunColor, 640, 480, skyColors); // centering is really weird: center of the screen is around (315, 255); JFrame size: (640, 480)
        
        Color groundColor = new Color(100, 180, 80);
        this.ground = new Ground(240, 640, 480, groundColor);
        
        Color roadColor = new Color(63, 63, 63);
        this.road = new Road(0, 50, 70, 1, 166, roadColor); // 166 is set for maxZ: -15=50*(-50/y); y=166.67...; y=166
        
        Color roadLineColor = new Color(242, 224, 61);
        this.roadLines = new RoadLine[6];
        for(int i = 0; i < this.roadLines.length; i++) {
            this.roadLines[i] = new RoadLine(0, 50, (i + 1) * 20, 10, 10, roadLineColor);
        }
    }
    
    /**
     * This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
     * It does not need to be invoked explicitly.
     * 
     * @param g a reference to the Graphics object used for all drawing operations
     */
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        this.sky.draw(g2);
        
        this.ground.draw(g2);
        
        this.road.draw(g2);
        
        for(RoadLine roadLine : roadLines) {
            roadLine.draw(g2);
        }
        
        for(int i = 0; i < 5; i ++) {
            for(int j = 0; j < 8; j ++) {
                Building b = buildings[j];
                if(b.getDrawOrder() == i) {
                    b.draw(g2);
                }
            }
        }
    }
    
    /**
     * Animate the cityscape by updating the objects such that they appear to be animated when
     *      they are next drawn.
     *
     */
    public void nextFrame()
    {
        for(Building building : this.buildings) {
            building.move(-1);
        }
        
        for(RoadLine roadLine : roadLines) {
            roadLine.move(-1);
        }

        repaint();
    }
}
