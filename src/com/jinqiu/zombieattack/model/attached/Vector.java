package com.jinqiu.zombieattack.model.attached;

/** Present a two dimensional vector. */
public class Vector {
	private float x;
	private float y;

	public Vector() {
		this.x = 0;
		this.y = 0;
	}

	/**
	 * Constructor.
	 * 
	 * @param x
	 *            The x coordinate
	 * @param y
	 *            The y coordinate
	 */
	public Vector(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Create a vector from start to end.
	 * 
	 * @param start
	 *            The start position of the vector
	 * @param end
	 *            The end position of the vector
	 */
	public Vector(Position start, Position end) {
		this.x = end.getX() - start.getX();
		this.y = end.getY() - start.getY();
	}

	/** Get normalized the value to change into unit vector. */
	public void normalize() {
		float mag = getMagnitude();
		x = x / mag;
		y = y / mag;
	}

	/**
	 * Get the x coordinate
	 * 
	 * @return The x coordinate
	 */
	public float getX() {
		return x;
	}

	/**
	 * Set the x coordinate
	 * 
	 * @param x
	 *            The new x coordinate
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Get the y coordinate
	 * 
	 * @return The y coordinate
	 */
	public float getY() {
		return y;
	}

	/**
	 * Set the y coordinate
	 * 
	 * @param y
	 *            The new y coordinate
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Get the magnitude
	 * 
	 * @return The magnitude
	 */
	public float getMagnitude() {
		return (float) Math.sqrt(x * x + y * y);
	}

	/**
	 * Addition for two vectors
	 * 
	 * @param vector
	 */
	public void plus(Vector vector) {
		this.x = this.x + vector.getX();
		this.y = this.y + vector.getY();
	}

	/**
	 * Multiply a number on the x and y coordinate
	 * 
	 * @param d
	 *            The number multiplied on X and Y
	 */
	public void multiply(float d) {
		x = x * d;
		y = y * d;
	}
}