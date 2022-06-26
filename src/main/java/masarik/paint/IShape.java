package masarik.paint;

/**
 * Instances of interface {@code IShape} represents geometrical shapes which are
 * drawn on canvas. The position of a shape is defined as the position of the
 * upper left and bottom right corner of its circumscribe rectangle.
 *
 * @author michal masarik
 */
public interface IShape {

	/**
	 * Returns the left horizontal coordinate.
	 *
	 * @return The left horizontal coordinate, left canvas border has x=0,
	 *         coordinate increases to the right
	 */

	public int getX1();

	/**
	 * Returns the upper vertical coordinate.
	 *
	 * @return The vertical coordinate, upper canvas border has y=0, coordinate
	 *         increases to the down
	 */

	public int getY1();

	/**
	 * Returns the right horizontal coordinate.
	 *
	 * @return The right horizontal coordinate, left canvas border has x=0,
	 *         coordinate increases to the right
	 */

	public int getX2();

	/**
	 * Returns the bottom vertical coordinate.
	 *
	 * @return The bottom vertical coordinate, upper canvas border has y=0,
	 *         coordinate increases to the down
	 */

	public int getY2();

	/**
	 * Set a new position of the instance. The position of a shape is defined as the
	 * position of the upper left and bottom right corner of its circumscribe
	 * rectangle.
	 *
	 * @param x1 The newly set left horizontal coordinate, Left canvas border has
	 *           x=0, coordinate increases to the right
	 * @param y1 The newly set upper vertical coordinate, upper canvas border has
	 *           y=0, coordinate increases to the down
	 * @param x2 The newly set right horizontal coordinate, Left canvas border has
	 *           x=0, coordinate increases to the right
	 * @param y3 The newly set bottom vertical coordinate, upper canvas border has
	 *           y=0, coordinate increases to the down
	 */
	public void setPosition(int x1, int y1, int x2, int y2);

	/**
	 * Paints the represented shape on the canvas.
	 */
	public void paint();

}
