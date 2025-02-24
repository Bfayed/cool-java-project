package hw4;

import java.util.ArrayList;

import api.AbstractElement;

/**
 * A PlatformElement is an element with two distinctive behaviors. First, it can
 * be set up to move horizontally within a fixed set of boundaries. On reaching
 * a boundary, the x-component of its velocity is reversed. Second, it maintains
 * a list of <em>associated</em> elements whose basic motion all occurs relative
 * to the PlatformElement.
 * 
 * @author Bavly Fayed
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class PlatformElement extends MovingElement {
	private double Min;
	private double Max;

	private ArrayList<AbstractElement> associated = new ArrayList<>();

	/**
	 * Constructs a new PlatformElement. Initially the left and right boundaries are
	 * <code>Double.NEGATIVE_INFINITY</code> and
	 * <code>Double.POSITIVE_INFINITY</code>, respectively.
	 * 
	 * @param x      x-coordinate of initial position of upper left corner
	 * @param y      y-coordinate of initial position of upper left corner
	 * @param width  object's width
	 * @param height object's height
	 */
	public PlatformElement(double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	public void addAssoiciated(AttachedElement Element) {
		associated.add(Element);
		Element.setBase(this);
	}
	public void addAssoiciated(FollowerElement Element) {
		associated.add(Element);
		Element.setBase(this);
		Element.setBounds(Min + getHeight() + getDeltaX(), Max - getHeight() + getDeltaX());
	}

	public void deleteMarkedAssociated() {

		for (int i = 0; i < associated.size(); i++) {
			if (associated.get(i).isMarked() == true) {
				associated.remove(associated.get(i));

			}
		}
	}

	public ArrayList<AbstractElement> getAssociated() {
		return associated;
	}

	public double getMin() {
		return Min;

	}

	public double getMax() {
		return Max;
	}

	public void setBounds(double min, double max) {
		Min = min;
		Max = max;

	}

	public void update() {
		super.update();
		setPosition(getXReal() - getDeltaX(), getYReal());
		if (getXReal() + getWidth() + getDeltaX() >= Max) {
			setPosition(Max - getWidth(), getYReal());
			setVelocity(-1 * (getDeltaX()), getDeltaY());
		} else if (getXReal() + getDeltaX() <= Min) {
			setPosition(Min, getYReal());
			setVelocity( - (getDeltaX()), getDeltaY());
		} else {
			setPosition(getXReal() + getDeltaX(), getYReal());

		}
		for (int i = 0; i < associated.size(); i++) {
			associated.get(i).update();
		}

	}

}