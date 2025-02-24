package hw4;

import java.awt.Rectangle;

import api.AbstractElement;

// TODO:
// Special documentation requirement: (see page 11 of documentation)
// you must add a comment to the top of the SimpleElement class
// with a couple of sentences explaining how you decided to organize
// the class hierarchy for the elements.

/**
 * Minimal concrete extension of AbstractElement. The <code>update</code> method
 * in this implementation just increments the frame count.
 * 
 * @author Bavly Fayed.
 */
// TODO: This class must directly or indirectly extend AbstractElement
public class SimpleElement extends AbstractElement {
	private double x; 
	private double y;
	private int width; 
	private int height; 
	private boolean isMarked; 
	private int frameCount; 
    /**
     * Constructs a new SimpleElement with the specified position and size.
     * 
     * @param x      x-coordinate of upper left corner
     * @param y      y-coordinate of upper left corner
     * @param width  element's width
     * @param height element's height
     */
    public SimpleElement(double x, double y, int width, int height) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height; 
      
    }

    @Override
    public int getXInt() {
        return (int) Math.round(getXReal());
    }

    @Override
    public int getYInt() {
        return (int) Math.round(getYReal());
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public Rectangle getRect() {
        return new Rectangle(getXInt(), getYInt(), getWidth(), getHeight());
    }

    @Override
    public void setPosition(double newX, double newY) {
       x = (newX);
       y = (newY);
    }

    @Override
    public double getXReal() {
        return x;
    }

    @Override
    public double getYReal() {
        return y;
    }

    @Override
    public void update() {
        frameCount += 1;
    }

    @Override
    public boolean isMarked() {
        return isMarked;
    }

    @Override
    public void markForDeletion() {
        isMarked = true;
    }

    @Override
    public boolean collides(AbstractElement other) {
        Rectangle rect1 = getRect();
        Rectangle rect2 = other.getRect();
        return rect1.intersects(rect2);
    }

	@Override
	public int getFrameCount() {
		return frameCount;
	}
}