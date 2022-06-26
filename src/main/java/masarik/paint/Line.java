package masarik.paint;

/**
 * Represents geometrical object of Line, which can be drawn onto canvas
 * {@link Canvas}
 * 
 * @author michal masarik
 *
 */
public class Line implements IShape {

	private static final Canvas CANVAS = Canvas.getInstance();

	private int x1Pos;
	private int y1Pos;
	private int x2Pos;
	private int y2Pos;

	public Line(int x1, int y1, int x2, int y2) {

		if (y2 < y1) {
			throw new IllegalArgumentException("Illegal input values. [y2 < y1] is not allowed. (Your input was x1="
					+ x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ")");
		}

		if (x2 < x1) {
			throw new IllegalArgumentException("Illegal input values. [x2 < x1] is not allowed. (Your input was x1="
					+ x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ")");
		}

		if ((y1 != y2) && (x1 != x2)) {
			throw new IllegalArgumentException(
					"Illegal input values. It is not allowed to drawn diagonal lines. (Your input was x1=" + x1
							+ ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ")");
		}

		if (x1 > CANVAS.getWidth() || x2 > CANVAS.getWidth() || y1 > CANVAS.getHeight() || y2 > CANVAS.getHeight()) {
			throw new IllegalArgumentException(
					"Illegal input values. Cannot be drawn outside of canvas. (Your input was x1=" + x1 + ", y1=" + y1
							+ ", x2=" + x2 + ", y2=" + y2 + ")");
		}

		this.x1Pos = x1;
		this.y1Pos = y1;
		this.x2Pos = x2;
		this.y2Pos = y2;
	}

	public int getX1() {
		return x1Pos;
	}

	public int getY1() {
		return y1Pos;
	}

	public int getX2() {
		return x2Pos;
	}

	public int getY2() {
		return y2Pos;
	}

	public void setPosition(int x1, int y1, int x2, int y2) {
		x1Pos = x1;
		y1Pos = y1;
		x2Pos = x2;
		y2Pos = y2;
	}

	public void paint() throws ArrayIndexOutOfBoundsException {
		CANVAS.drawLine(x1Pos, y1Pos, x2Pos, y2Pos);
	}

	@Override
	public String toString() {
		return "Line [x1=" + x1Pos + ", y1=" + y1Pos + ", x2=" + x2Pos + ", y2=" + y2Pos + "]";
	}

}
