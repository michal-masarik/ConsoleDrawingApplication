package masarik.paint;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * Unit tests for {@ link Canvas}
 * 
 * @author michal masarik
 *
 */
public class CanvasTest {
	
	@Rule
	public TestName name = new TestName();
	
	@Before
	public void printTestName(){
		System.out.println(name.getMethodName());
	}

	@Test
	public void createCanvas1x1() {

		char[][] expectedCanvas = { 
				{ '-', '-', '-' }, 
				{ '|', ' ', '|' }, 
				{ '-', '-', '-' } };

		Canvas canvas = Canvas.getInstance();
		canvas.init(1, 1);
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}

	@Test
	public void createCanvas3x3() {

		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-' }, 
				{ '|', ' ', ' ', ' ', '|' },
				{ '|', ' ', ' ', ' ', '|' }, 
				{ '|', ' ', ' ', ' ', '|' }, 
				{ '-', '-', '-', '-', '-' } };

		Canvas canvas = Canvas.getInstance();
		canvas.init(3, 3);
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}

	@Test
	public void createCanvas2x4() {

		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-' }, 
				{ '|', ' ', ' ', '|' }, 
				{ '|', ' ', ' ', '|' },
				{ '|', ' ', ' ', '|' }, 
				{ '|', ' ', ' ', '|' }, 
				{ '-', '-', '-', '-' } };

		Canvas canvas = Canvas.getInstance();
		canvas.init(2, 4);
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}

	@Test
	public void createCanvas4x2() {

		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-' }, 
				{ '|', ' ', ' ', ' ', ' ', '|' },
				{ '|', ' ', ' ', ' ', ' ', '|' }, 
				{ '-', '-', '-', '-', '-', '-' } };

		Canvas canvas = Canvas.getInstance();
		canvas.init(4, 2);
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}

	@Test
	public void createCanvas0x1ShouldFail() {
		Canvas canvas = Canvas.getInstance();
		assertThrows(IllegalArgumentException.class, () -> {
			canvas.init(0, 1);
		});
	}

	@Test
	public void createCanvas1x0ShouldFail() {
		Canvas canvas = Canvas.getInstance();
		assertThrows(IllegalArgumentException.class, () -> {
			canvas.init(1, 0);
		});
	}

	@Test
	public void createCanvas0x0ShouldFail() {
		Canvas canvas = Canvas.getInstance();
		assertThrows(IllegalArgumentException.class, () -> {
			canvas.init(0, 0);
		});
	}
}
