package masarik.paint;

/**
 * Represents color palette. Provides support and methods for working with color.
 * Color is represented by character.
 * 
 * @author michal masarik
 *
 */
public class ColorPaletteManager {

	public static final char DEFAULT_COLOR = 'x';

	private static ColorPaletteManager SINGLETON;
	private static char activeColor = DEFAULT_COLOR;

	private ColorPaletteManager() {
	}

	public static ColorPaletteManager getInstance() {
		if (SINGLETON == null) {
			SINGLETON = new ColorPaletteManager();
		}
		return SINGLETON;
	}

	public char getActiveColor() {
		return activeColor;
	}

	public void setActiveColor(char newColor) {
		activeColor = newColor;
	}

	public void resetActiveColor() {
		activeColor = DEFAULT_COLOR;
	}

}
