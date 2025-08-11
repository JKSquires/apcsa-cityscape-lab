import javax.swing.JFrame;
import java.awt.Color;

/**
 * Class that contains the main method for the program and creates the frame containing the component.
 * 
 * @author gcschmit
 * @author jksquires
 * @version 1014241615
 */
public class CityscapeViewer
{
    // the cityscape will be animated for a total of n frames
    static final int ANIMATION_LOOP_NUMBER = 120;
   
    /**
     * main method for the program which creates and configures the frame for the program
     * 
     * @param args  not used
     *
     */
    public static void main(String[] args) throws InterruptedException
    {
        // create and configure the frame (window) for the program
        JFrame frame = new JFrame();
        
        frame.setSize(640 /* x */, 480 /* y */);
        frame.setTitle("Cityscape");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // a frame contains a single component; create the Cityscape component and add it to the frame
        CityscapeComponent component = new CityscapeComponent();
        frame.add(component);
        
        // make the frame visible which will result in the paintComponent method being invoked on the
        //  component.
        frame.setVisible(true);
        
        // make the frame non-resazable
        frame.setResizable(false);
        
        // animate the cityscape
        for( int seconds = 0; seconds < ANIMATION_LOOP_NUMBER; seconds++ )
        {
            component.nextFrame();
            Thread.sleep( 100 );
        }
        
    }

}
