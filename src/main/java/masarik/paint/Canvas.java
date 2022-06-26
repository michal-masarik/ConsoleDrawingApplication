package masarik.paint;

/**
 * Canvas represents place, where instances of IShape {@link IShape} can be drawn.
 * Canvas doesn't know any instances, which are drawn on it. It just stores imprint of 
 * geometrical object in its character 2-dimensional array.
 * 
 * @author michal masarik
 *
 */
public final class Canvas {

	private static Canvas SINGLETON;
	private ColorPaletteManager palette;

	private int width;
	private int height;
	private char[][] content;

	private Canvas() {
		palette = ColorPaletteManager.getInstance();
	}

	/**
	 * returns singleton instance of Canvas
	 * @return Canvas as singleton
	 */
	public static Canvas getInstance() {
		if (SINGLETON == null) {
			SINGLETON = new Canvas();
		}
		return SINGLETON;
	}

	public char[][] getContent() {
		return content;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	/**
	 * Canvas has to be initialized by calling this method, 
	 * before it can be used for drawing objects.
	 * 
	 * @param w width - number of characters between left and right border of canvas
	 * @param h height - number of characters between up and bottom border of canvas
	 * @return true if canvas was initiated successfully
	 */
	public Boolean init(int w, int h) {

		if (w > 0 && h > 0) {
			width = w + 2;
			height = h + 2;
			content = new char[height][width];
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if (i == 0 || i == height - 1) {
						content[i][j] = '-';
					} else {
						if (j == 0 || j == width - 1) {
							content[i][j] = '|';
						} else {
							content[i][j] = ' ';
						}
					}
				}
			}
			return true;
		} else {
			throw new IllegalArgumentException(
					"Canvas can't have 0 width or height. (Your input was: width=" + w + ", height=" + h + ")");
		}
	}

	/**
	 * Draws Line on Canvas. Only horizontal and vertical lines are supported.
	 * 
	 * @param x1 left or upper x position
	 * @param y1 left or upper y position
	 * @param x2 right or bottom x position
	 * @param y2 right or bottom y position
	 * @throws ArrayIndexOutOfBoundsException when line should be drawn outside of canvas
	 */
	public void drawLine(int x1, int y1, int x2, int y2) throws ArrayIndexOutOfBoundsException {

		// draw horizontal line
		if (y1 == y2) {
			for (int i = x1; i <= x2; i++) {
				content[y1][i] = palette.getActiveColor();
			}

			// draw vertical line
		} else if (x1 == x2) {
			for (int i = y1; i <= y2; i++) {
				content[i][x1] = palette.getActiveColor();
			}

		} else {
			throw new IllegalArgumentException(
					"The argument have illegal values: x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2);
		}
	}

	/**
	 * Print whole content of canvas. It means canvas itself and all objects, which were drawn on it, if any.
	 */
	public void print() {
		for (char[] row : content) {
			for (char element : row) {
				System.out.print(element);
			}
			System.out.println();
		}
	}

	/**
	 * Fill whole area on canvas connected with the same original color by new defined color. 
	 * Similarly as bucket fill tool.
	 * Implementation is using recursive Flood fill algorithm with seed
	 * 
	 * @param x start position
	 * @param y start position
	 * @param c new color
	 */
	public void fillArea(int x, int y, char c) {
		boolean[][] visited = new boolean[content.length][content[0].length];
		char oldColor = content[y][x];

		if (oldColor == c)
			return;

		floodFill(visited, y, x, oldColor, c);
	}

	private void floodFill(boolean[][] visited, int r, int c, char oldColor, char newColor) {
		// quit if off the grid
		if (r < 0 || r >= content.length || c < 0 || c >= content[0].length)
			return;

		// quit if visited
		if (visited[r][c])
			return;

		visited[r][c] = true;

		// quit when hit border of old color area
		if (content[r][c] != oldColor)
			return;

		// change color
		if (content[r][c] == oldColor)
			content[r][c] = newColor;

		// recursively fill in all directions
		floodFill(visited, r + 1, c, oldColor, newColor);
		floodFill(visited, r - 1, c, oldColor, newColor);
		floodFill(visited, r, c + 1, oldColor, newColor);
		floodFill(visited, r, c - 1, oldColor, newColor);
	}
	
	@Override
	public String toString() {
		return this.getClass().getName() + "(" + width + "x" + height + ")";
	}

}
