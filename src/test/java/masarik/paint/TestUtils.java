package masarik.paint;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides utility methods used by other Test classes
 * 
 * @author michal masarik
 *
 */
public final class TestUtils {

	/**
	 * Verifies content (graphical representation) of actual Canvas against content
	 * of expected two-dimensional array of characters (char[][])
	 * 
	 * 
	 * @param expectedCanvas char[][] usually defined in test data as expected state
	 *                       of canvas
	 * @param actualCanvas   content of real instance of canvas represented by
	 *                       {@link Canvas}
	 */
	public static void verifyCanvasContent(char[][] expectedCanvas, char[][] actualCanvas) {
		for (int i = 0; i < expectedCanvas.length; i++) {
			for (int j = 0; j < expectedCanvas[i].length; j++) {
				assertEquals(expectedCanvas[i][j], actualCanvas[i][j],
						"Canvas has unexpected tile on position [" + j + ", " + i + "]");
			}
		}
	}
}
