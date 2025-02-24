package hw4;

/**
 * Moving element in which the vertical velocity is adjusted each frame by a
 * gravitational constant to simulate gravity. The element can be set to
 * "grounded", meaning gravity will no longer influence its velocity.
 * 
 * @author Bavly Fayed.
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class FlyingElement extends MovingElement {
	private boolean isGrounded;
	private double gravity;

	/**
	 * Constructs a new FlyingElement. By default it should be grounded, meaning
	 * gravity does not influence its velocity.
	 * 
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	public FlyingElement(double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	public void setGrounded(boolean grounded) {
		this.isGrounded = grounded;

		if (isGrounded == true) {
			gravity = 0;
		}
	}

	public boolean isGrounded() {
		return isGrounded;

	}

	public void setGravity(double gravity) {
		this.gravity = gravity;

	}

	@Override
	public void update() {
		super.update();
		setVelocity(getDeltaX(), getDeltaY() + gravity);

	}

}