import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * CS 121 Project 0: Traffic Animation
 *
 * Animates a [put your description here]
 *
 * @author BSU CS 121 Instructors
 * @author [put your name here]
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel
{
	// This is where you declare constants and variables that need to keep their
	// values between calls	to paintComponent(). Any other variables should be
	// declared locally, in the method where they are used.

	/**
	 * A constant to regulate the frequency of Timer events.
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */
	private final int DELAY = 100; //milliseconds

	/**
	 * The anchor coordinate for drawing / animating. All of your vehicle's
	 * coordinates should be relative to this offset value.
	 */
	private int xOffset = 0;

	/**
	 * The number of pixels added to xOffset each time paintComponent() is called.
	 */
	private int stepSize = 10;

	private final Color BACKGROUND_COLOR = new Color(34, 139, 34);

	/* This method draws on the panel's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		// Get the current width and height of the window.
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height

		//this method bounces the car back to the left and right as it hits the side of the screen
		if (xOffset + width / 6 > width || xOffset < 0) 
		{
            stepSize = -stepSize;
        }

        xOffset += stepSize;


		// Fill the graphics page with the background color.
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, width, height);

		// Calculate the new xOffset position of the moving object.
		xOffset  = (xOffset + stepSize) % width;

		// TODO: Use width, height, and xOffset to draw your scalable objects
		// at their new positions on the screen
		
		//this next code draws the line for the road
		int laneH = height / 80; // Lane line height
        int roadGap = height / 4; // Gap between lane lines
        int laneY1 = height / 2 - roadGap / 2 - laneH; // Upper lane Y coordinate
        int laneY2 = height / 2 + roadGap / 2;         // Lower lane Y coordinate

        // Draw the black road
        g.setColor(Color.BLACK);
        g.fillRect(0, laneY1 + laneH, width, laneY2 - laneY1 - laneH);

        // Draw the yellow lane lines
        g.setColor(Color.yellow);
        g.fillRect(0, laneY1, width, laneH);
        g.fillRect(0, laneY2, width, laneH);
		
		//this is the code set for the vehicle
		int bodyW = width / 6;
		int bodyH = height / 8;
		int bodyX = xOffset;
		int bodyY = height / 2 - bodyH / 2;

		g.setColor(Color.RED);
		g.fillRect(bodyX, bodyY, bodyW, bodyH);

		int cabW = bodyW / 2;
		int cabH = bodyH / 2;
		int cabX = bodyX + bodyW / 4;
		int cabY = bodyY - cabH;

		g.setColor(Color.gray);
		g.fillRect(cabX, cabY, cabW, cabH);

		int bumperW = bodyW / 4;
		int bumperH = bodyH / 3;
		int bumperX = bodyX + bodyW;
		int bumperY = bodyY + bodyH - bumperH;

		g.setColor(Color.gray);
		g.fillRect(bumperX, bumperY, bumperW, bumperH);

		int wheelDiameter = bodyH / 2;
		int frontWheelX = bodyX + bodyW / 8;
		int rearWheelX = bodyX + 5 * bodyW / 8;
		int wheelY = bodyH + bodyY;

		g.setColor(Color.WHITE);
		g.fillOval(frontWheelX, wheelY, wheelDiameter, wheelDiameter);
		g.fillOval(rearWheelX, wheelY, wheelDiameter, wheelDiameter);

		// Drawing Avatar
		int avatarRadius = height / 15;
		int avatarX = width / 2; 
		int avatarY = height - (int)(5.5 * avatarRadius);

		// Avatar's head
		g.setColor(Color.WHITE);
		g.fillOval(avatarX, avatarY, avatarRadius, avatarRadius);

		// Avatar's eyes
		int eyeRadius = avatarRadius / 8;
		g.setColor(Color.WHITE);
		g.fillOval(avatarX + avatarRadius / 4, avatarY + avatarRadius / 4, eyeRadius, eyeRadius); // Left eye
		
		// Positioning the left eye
		int leftEyeX = avatarX + avatarRadius / 4;
		int eyeY = avatarY + avatarRadius / 4;
		
		// Positioning the right eye
		int rightEyeX = avatarX + (avatarRadius / 4) * 3;

		//draw eyes
		g.fillOval(leftEyeX, eyeY, eyeRadius, eyeRadius);
		g.fillOval(rightEyeX, eyeY, eyeRadius, eyeRadius);

		// Avatar's mouth
		g.setColor(Color.RED);
		g.drawArc(avatarX + avatarRadius / 4, avatarY + avatarRadius / 2, avatarRadius / 2, avatarRadius / 4, 0, -180); // Smile

		// Avatar's nose
		g.setColor(Color.BLACK);
		g.drawLine(avatarX + avatarRadius / 2, avatarY + avatarRadius / 2, avatarX + avatarRadius / 2, avatarY + avatarRadius / 3); // Nose


		// Avatar Body
		int bodyStartX = avatarX + avatarRadius / 2;
		int bodyStartY = avatarY + avatarRadius;
		int bodyEndY = bodyStartY + avatarRadius * 2;

		g.drawLine(bodyStartX, bodyStartY, bodyStartX, bodyEndY); // Body

		// Avatar Arms
		int armLength = avatarRadius;
		g.drawLine(bodyStartX, bodyStartY + avatarRadius / 2, bodyStartX - armLength, bodyStartY + avatarRadius);
		g.drawLine(bodyStartX, bodyStartY + avatarRadius / 2, bodyStartX + armLength, bodyStartY + avatarRadius); // Arms

		// Avatar Legs
		int legLength = avatarRadius;
		g.drawLine(bodyStartX, bodyEndY, bodyStartX - legLength / 2, bodyEndY + legLength); // Left leg
		g.drawLine(bodyStartX, bodyEndY, bodyStartX + legLength / 2, bodyEndY + legLength); // Right leg

		//this is the custom design part, added the sun
		
		int sunRadius = width / 8;
		int sunX = width - sunRadius - 10;
		int sunY = 20;

		g.setColor(Color.YELLOW);
		g.fillArc(sunX, sunY, sunRadius, sunRadius, 0, 360);


		//display text at the top of the scene
		g.setColor(Color.WHITE);
		
		float fontSize = height * 0.05f;
		g.setFont(g.getFont().deriveFont(fontSize));

		int textX = (int)(width * 0.3);
		int textY = (int)(height * 0.1);

		g.drawString("Watch out for passing cars!!", textX, textY);

		

		// Put your code above this line. This makes the drawing smoother.
		Toolkit.getDefaultToolkit().sync();
	}


	
	
	
	
	//==============================================================
	// You don't need to modify anything beyond this point.
	//==============================================================


	/**
	 * Starting point for this program. Your code will not go in the
	 * main method for this program. It will go in the paintComponent
	 * method above.
	 *
	 * DO NOT MODIFY this method!
	 *
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		// DO NOT MODIFY THIS CODE.
		JFrame frame = new JFrame ("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins. This method also
	 * sets up a Timer that will call paint() with frequency specified by
	 * the DELAY constant.
	 */
	public TrafficAnimation()
	{
		// Do not initialize larger than 800x600. I won't be able to
		// grade your project if you do.
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically.
	 * DO NOT MODIFY this method!
	 */
	private void startAnimation()
	{
		ActionListener timerListener = new TimerListener();
		Timer timer = new Timer(DELAY, timerListener);
		timer.start();
	}

	/**
	 * Repaints the graphics panel every time the timer fires.
	 * DO NOT MODIFY this class!
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}
