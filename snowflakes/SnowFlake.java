import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 * An individual snowflake
 * @author Barbara Lerner
 * @version Feb 10, 2010
 *
 */
public class SnowFlake {
	// The location of the flake
	private int left;
	private int top;
	
	// The lowest visible point on the screen
	private int screenHeight;
	
	// How much to fall in each frame
	private int fallOffset;

	private int wind; //how strong the wind is
	
	// The picture of the flake
	private ImageIcon snow;
	
	/**
	 * Creates a snowflake just off the top of the window
	 * @param snow the picture of the flake
	 * @param left the left edge of the flake
	 * @param screenHeight the bottom of the window
	 * @param fallOffset how far to fall in each frame.
	 */
	public SnowFlake(ImageIcon snow, int left, int screenHeight, int fallOffset, int wind) {
		this.snow = snow;
		this.left = left;
		this.top = -snow.getIconHeight();
		this.screenHeight = screenHeight;
		this.fallOffset = fallOffset;
		this.wind = wind;
	}
	
	/**
	 * Move the snowflake down a little so that it looks like it is falling on each frame
	 */
	public void nextFrame() {

		if (top < screenHeight) {
			top = top + fallOffset;
		}
		left += wind;
	}
	
	/**
	 * Draw the snowflake at its current location
	 * @param component the Swing component to draw the flake on
	 * @param g the graphics object to draw on
	 */
	public void paint (JComponent component, Graphics g) {
		snow.paintIcon(component, g, left, top);
	}

}

