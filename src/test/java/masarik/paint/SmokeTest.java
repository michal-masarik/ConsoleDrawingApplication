package masarik.paint;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * 
 * Test cases for canvas usage with drawing of multiple types of drawable objects.
 * 
 * @author michal masarik
 *
 */
public class SmokeTest {
	
	@Rule
	public TestName name = new TestName();
	
	@Before
	public void printTestName(){
		System.out.println(name.getMethodName());
	}

	@Test
	public void createCanvas20x4() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(20, 4);
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createCanvasDrawHorizontalLine() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(20, 4);
		Line line = new Line(1, 2, 6, 2);
		line.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createCanvasDrawHorizontalLineDrawVerticalLine() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(20, 4);
		Line horizontalLine = new Line(1, 2, 6, 2);
		horizontalLine.paint();
		Line verticalLine = new Line(6, 3, 6, 4);
		verticalLine.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createCanvasDrawHorizontalLineDrawVerticalLineDrawRectangle() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', 'x', 'x', ' ', ' ', '|'},
				{ '|', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', 'x', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', 'x', 'x', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(20, 4);
		Line horizontalLine = new Line(1, 2, 6, 2);
		horizontalLine.paint();
		Line verticalLine = new Line(6, 3, 6, 4);
		verticalLine.paint();
		Rectangle rectangle = new Rectangle(14, 1, 18, 3);
		rectangle.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createCanvasDrawHorizontalLineDrawVerticalLineDrawRectangleFillColor() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'o', '|'},
				{ '|', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', ' ', ' ', ' ', 'x', 'o', 'o', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'o', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(20, 4);
		Line horizontalLine = new Line(1, 2, 6, 2);
		horizontalLine.paint();
		Line verticalLine = new Line(6, 3, 6, 4);
		verticalLine.paint();
		Rectangle rectangle = new Rectangle(14, 1, 18, 3);
		rectangle.paint();
		canvas.fillArea(10, 3, 'o');
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
}
