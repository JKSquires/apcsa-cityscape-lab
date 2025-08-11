import java.awt.Graphics2D;

import java.awt.Color;

import java.awt.geom.Rectangle2D;

/**
 * The ground for the cityscape
 *
 * @author jksquires
 * @version 1015241435
 */
public class Ground
{
    private Color gndColor;
    private int topPos;
    private int width;
    private int height;
    
    /**
     * Constructor to create the ground
     * 
     * @param t the y value for where the ground reaches to
     * @param w the width of the window
     * @param h the height of the window
     * @param col the color of the ground
     */
    public Ground(int t, int w, int h, Color col)
    {
        this.gndColor = col;
        this.topPos = t;
        this.width = w;
        this.height = h;
    }
    /**
     * Draw the ground to the graphics 2d.
     * 
     * @param g graphics object
     */
    public void draw(Graphics2D g) {
        g.setPaint(this.gndColor);
        g.fill(new Rectangle2D.Double(0, this.topPos, this.width, this.height - this.topPos));
    }
}
