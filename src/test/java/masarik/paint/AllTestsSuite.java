package masarik.paint;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	CanvasTest.class, 
	LineTest.class, 
	RectangleTest.class, 
	FloodFillTest.class,
	SmokeTest.class, 
	ColorPaletteManagerTest.class,
	InputValidatorTest.class
	})

/**
 * Main test suite. This starts all implemented tests at once.
 * 
 * @author michal masarik
 *
 */
public class AllTestsSuite {
}
