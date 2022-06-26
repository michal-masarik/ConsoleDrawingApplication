package masarik.paint;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * Unit tests for {@ link Rectangle}
 * 
 * @author michal masarik
 *
 */
public class RectangleTest {
	
	@Rule
	public TestName name = new TestName();
	
	@Before
	public void printTestName(){
		System.out.println(name.getMethodName());
	}

	@Test
	public void createRectangleInLeftUpCorner() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', 'x', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Rectangle rectangle = new Rectangle(1, 1, 3, 3);
		rectangle.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createRectangleInRightUpCorner() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Rectangle rectangle = new Rectangle(6, 1, 8, 3);
		rectangle.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createRectangleInLeftBottomCorner() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', '|'},
				{ '|', 'x', ' ', ' ', 'x', ' ', ' ', ' ', ' ', '|'},
				{ '|', 'x', ' ', ' ', 'x', ' ', ' ', ' ', ' ', '|'},
				{ '|', 'x', ' ', ' ', 'x', ' ', ' ', ' ', ' ', '|'},
				{ '|', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Rectangle rectangle = new Rectangle(1, 4, 4, 8);
		rectangle.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createRectangleInRightBottomCorner() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Rectangle rectangle = new Rectangle(6, 6, 8, 8);
		rectangle.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createRectangleInMiddle() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', 'x', 'x', 'x', 'x', 'x', ' ', ' ', '|'},
				{ '|', ' ', 'x', ' ', ' ', ' ', 'x', ' ', ' ', '|'},
				{ '|', ' ', 'x', ' ', ' ', ' ', 'x', ' ', ' ', '|'},
				{ '|', ' ', 'x', 'x', 'x', 'x', 'x', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Rectangle rectangle = new Rectangle(2, 3, 6, 6);
		rectangle.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createTwoRectanglesWithoutIntersection() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', 'x', 'x', 'x', 'x', '|'},
				{ '|', 'x', 'x', 'x', ' ', 'x', ' ', ' ', 'x', '|'},
				{ '|', 'x', ' ', 'x', ' ', 'x', ' ', ' ', 'x', '|'},
				{ '|', 'x', ' ', 'x', ' ', 'x', ' ', ' ', 'x', '|'},
				{ '|', 'x', ' ', 'x', ' ', 'x', 'x', 'x', 'x', '|'},
				{ '|', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Rectangle rectangle1 = new Rectangle(1, 3, 3, 7);
		rectangle1.paint();
		Rectangle rectangle2 = new Rectangle(5, 2, 8, 6);
		rectangle2.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createTwoRectanglesWithIntersection() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', 'x', 'x', 'x', 'x', 'x', 'x', '|'},
				{ '|', 'x', 'x', 'x', 'x', 'x', ' ', ' ', 'x', '|'},
				{ '|', 'x', ' ', 'x', ' ', 'x', ' ', ' ', 'x', '|'},
				{ '|', 'x', ' ', 'x', ' ', 'x', ' ', ' ', 'x', '|'},
				{ '|', 'x', 'x', 'x', 'x', 'x', ' ', ' ', 'x', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', 'x', '|'},
				{ '|', ' ', ' ', 'x', 'x', 'x', 'x', 'x', 'x', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Rectangle rectangle1 = new Rectangle(3, 1, 8, 7);
		rectangle1.paint();
		Rectangle rectangle2 = new Rectangle(1, 2, 5, 5);
		rectangle2.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createRectangle1x3() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', 'x', 'x', 'x', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Rectangle rectangle = new Rectangle(2, 1, 4, 1);
		rectangle.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createRectangle3x1() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Rectangle rectangle = new Rectangle(3, 2, 3, 4);
		rectangle.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createRectangle1x1() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Rectangle rectangle = new Rectangle(4, 4, 4, 4);
		rectangle.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createRectangle2x2() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', 'x', 'x', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', 'x', 'x', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Rectangle rectangle = new Rectangle(4, 4, 5, 5);
		rectangle.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void notPossibleDrawRectangleFullyOutsideOfCanvas() {
		Canvas canvas = Canvas.getInstance();
		canvas.init(10, 10);
		assertThrows(IllegalArgumentException.class, () -> {
			Rectangle rectangle = new Rectangle(5, 5, 20, 20);
			rectangle.paint();
		});
	}
	
	@Test
	public void notPossibleDrawRectanglePartiallyOutsideOfCanvas() {
		Canvas canvas = Canvas.getInstance();
		canvas.init(10, 10);
		assertThrows(IllegalArgumentException.class, () -> {
			Rectangle rectangle = new Rectangle(15, 15, 18, 18);
			rectangle.paint();
		});
	}
}
