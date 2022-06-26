package masarik.paint;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * Unit tests for {@ link Line}
 * 
 * @author michal masarik
 *
 */
public class LineTest {
	
	@Rule
	public TestName name = new TestName();
	
	@Before
	public void printTestName(){
		System.out.println(name.getMethodName());
	}

	@Test
	public void createHorizontalLineInLeftUpCorner() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
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
		Line line = new Line(1, 1, 3, 1);
		line.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createHorizontalLineInRightUpCorner() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', '|'},
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
		Line line = new Line(6, 1, 8, 1);
		line.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createHorizontalLineInLeftBottomCorner() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Line line = new Line(1, 8, 3, 8);
		line.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createHorizontalLineInRightBottomCorner() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Line line = new Line(6, 8, 8, 8);
		line.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createHorizontalLineInMiddle() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', 'x', 'x', 'x', 'x', 'x', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Line line = new Line(2, 3, 6, 3);
		line.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createHorizontalLineTouchingLeftCanvasBorder() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Line line = new Line(1, 3, 6, 3);
		line.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createHorizontalLineTouchingRightCanvasBorder() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', 'x', 'x', 'x', 'x', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Line line = new Line(5, 7, 8, 7);
		line.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createHorizontalLineTouchingUpCanvasBorder() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', 'x', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
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
		Line line = new Line(2, 1, 3, 1);
		line.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createHorizontalLineTouchingBottomCanvasBorder() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', 'x', 'x', 'x', 'x', 'x', 'x', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Line line = new Line(2, 8, 7, 8);
		line.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createHorizontalLineWithLength1InMiddleOfCanvas() {
		
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
		Line line = new Line(4, 4, 4, 4);
		line.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createVerticalLineInLeftUpCorner() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', 'x', ' ', ' ', ' ', ' ', '|'},
				{ '|', 'x', ' ', ' ', ' ', ' ', '|'},
				{ '|', 'x', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-'},};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(5, 5);
		Line line = new Line(1, 1, 1, 3);
		line.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createVerticalLineInRightUpCorner() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', 'x', '|'},
				{ '|', ' ', ' ', ' ', ' ', 'x', '|'},
				{ '|', ' ', ' ', ' ', ' ', 'x', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-'},};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(5, 5);
		Line line = new Line(5, 1, 5, 3);
		line.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createVerticalLineInLeftBottomCorner() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', 'x', ' ', ' ', ' ', ' ', '|'},
				{ '|', 'x', ' ', ' ', ' ', ' ', '|'},
				{ '|', 'x', ' ', ' ', ' ', ' ', '|'},
				{ '|', 'x', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-'},};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(5, 5);
		Line line = new Line(1, 2, 1, 5);
		line.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createVerticalLineInRightBottomCorner() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', 'x', '|'},
				{ '|', ' ', ' ', ' ', ' ', 'x', '|'},
				{ '|', ' ', ' ', ' ', ' ', 'x', '|'},
				{ '|', ' ', ' ', ' ', ' ', 'x', '|'},
				{ '-', '-', '-', '-', '-', '-', '-'},};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(5, 5);
		Line line = new Line(5, 2, 5, 5);
		line.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createVerticalLineInMiddle() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-'},};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(5, 5);
		Line line = new Line(3, 2, 3, 4);
		line.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createVerticalLineInMiddleWithLength1() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-'},};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(5, 5);
		Line line = new Line(3, 2, 3, 2);
		line.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void create2HorizontalLinesWithoutIntersection() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', 'x', 'x', 'x', 'x', 'x', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', 'x', 'x', 'x', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Line line1 = new Line(2, 1, 6, 1);
		line1.paint();
		Line line2 = new Line(2, 4, 4, 4);
		line2.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void create2HorizontalLinesWithIntersection() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', 'x', 'x', 'x', 'x', 'x', 'x', 'x', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Line line1 = new Line(2, 4, 5, 4);
		line1.paint();
		Line line2 = new Line(4, 4, 8, 4);
		line2.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void create2VerticalLinesWithoutIntersection() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', 'x', ' ', ' ', ' ', 'x', ' ', ' ', '|'},
				{ '|', ' ', 'x', ' ', ' ', ' ', 'x', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Line line1 = new Line(2, 1, 2, 5);
		line1.paint();
		Line line2 = new Line(6, 4, 6, 6);
		line2.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void create2VerticallLinesWithIntersection() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Line line1 = new Line(3, 1, 3, 4);
		line1.paint();
		Line line2 = new Line(3, 2, 3, 8);
		line2.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void create2VerticallLinesWithFullIntersection() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Line line1 = new Line(3, 1, 3, 8);
		line1.paint();
		Line line2 = new Line(3, 2, 3, 4);
		line2.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createVerticalAndHorizontalLinesWithoutIntersection() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', 'x', ' ', ' ', ' ', 'x', 'x', 'x', '|'},
				{ '|', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Line line1 = new Line(2, 1, 2, 5);
		line1.paint();
		Line line2 = new Line(6, 4, 8, 4);
		line2.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void createVerticalAndHorizontalLinesWithIntersection() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', 'x', 'x', 'x', 'x', 'x', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Line line1 = new Line(2, 4, 6, 4);
		line1.paint();
		Line line2 = new Line(3, 1, 3, 8);
		line2.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void notPossibleDrawLineFullyOutsideOfCanvas() {
		Canvas canvas = Canvas.getInstance();
		canvas.init(10, 10);
		assertThrows(IllegalArgumentException.class, () -> {
			Line line = new Line(20, 20, 40, 20);
			line.paint();
		});
	}
	
	@Test
	public void notPossibleDrawHorizontalLinePartiallyOutsideOfCanvas() {
		Canvas canvas = Canvas.getInstance();
		canvas.init(10, 10);
		assertThrows(IllegalArgumentException.class, () -> {
			Line line = new Line(5, 1, 20, 1);
			line.paint();
		});
	}
	
	@Test
	public void notPossibleDrawVerticallLinePartiallyOutsideOfCanvas() {
		Canvas canvas = Canvas.getInstance();
		canvas.init(10, 10);
		assertThrows(IllegalArgumentException.class, () -> {
			Line line = new Line(1, 5, 1, 20);
			line.paint();
		});
	}
}
