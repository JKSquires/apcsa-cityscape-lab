import java.awt.Graphics2D;

import java.awt.Color;
import java.awt.RadialGradientPaint;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
/**
 * The sky for the cityscape
 *
 * @author jksquires
 * @version 1015241540
 */
public class Sky
{
    private int sunXPos;
    private int sunYPos;
    private int sunDiam;
    private Color sunColor;
    
    private int skyWidth;
    private int skyHeight;
    private RadialGradientPaint skyColor;
    
    
    /**
     * Constructor with the values for this Sky object.
     * 
     * @param sX x position of the center of the sun
     * @param sY y position of the center of the sun
     * @param sD sun diameter
     * @param sCol sun color
     * @param bgW width of the sky
     * @param bgH height of the sky
     * @param bgCols sky colors (Center and outside)
     */
    public Sky(int sX, int sY, int sD, Color sCol, int bgW, int bgH, Color[] bgCols) {
        int sR = sD / 2;
        this.sunXPos = sX - sR;
        this.sunYPos = sY - sR;
        this.sunDiam = sD;
        this.sunColor = sCol;
        
        this.skyWidth = bgW;
        this.skyHeight = bgH;
        
        float[] fractions = {0.0f, 1.0f};
        this.skyColor = new RadialGradientPaint((float) sX, (float) sY, (float) bgH, fractions, bgCols);
    }
    /**
     * Draw the sun and sky to the graphics 2d.
     * 
     * @param g graphics object
     */
    public void draw(Graphics2D g) {
        g.setPaint(this.skyColor);
        g.fill(new Rectangle2D.Double(0, 0, this.skyWidth, this.skyHeight));
        
        g.setPaint(this.sunColor);
        g.fill(new Ellipse2D.Double(this.sunXPos, this.sunYPos, this.sunDiam, this.sunDiam));
        
        //g.setColor(new Color(100, 180, 80));
        //g.fill(new Rectangle2D.Double(0, this.sunYPos + this.sunDiam / 2, this.skyWidth, this.skyHeight));
    }
}
