package masarik.paint;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * Unit tests for bucket tool using flood fill algorithm
 * 
 * @author michal masarik
 *
 */
public class FloodFillTest {
	
	@Rule
	public TestName name = new TestName();
	
	@Before
	public void printTestName(){
		System.out.println(name.getMethodName());
	}
	
	@Test
	public void fillInnerPartOf1x1Canvas() {

		char[][] expectedCanvas = { 
				{ '-', '-', '-' }, 
				{ '|', '*', '|' }, 
				{ '-', '-', '-' } };

		Canvas canvas = Canvas.getInstance();
		canvas.init(1, 1);
		canvas.fillArea(1, 1, '*');
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void fillInnerPartOfCanvasInLeftUpCorner() {

		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};

		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		canvas.fillArea(1, 1, '*');
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void fillInnerPartOfCanvasInRigthUpCorner() {

		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};

		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		canvas.fillArea(8, 1, '*');
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void fillInnerPartOfCanvasInLeftBottomCorner() {

		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};

		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		canvas.fillArea(1, 8, '*');
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void fillInnerPartOfCanvasInRightBottomCorner() {

		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '|', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};

		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		canvas.fillArea(8, 8, '*');
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void fillWholeCanvasIncludingBorders() {

		char[][] expectedCanvas = { 
				{ '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
				{ '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
				{ '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
				{ '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
				{ '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
				{ '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
				{ '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
				{ '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
				{ '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
				{ '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'}};

		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		canvas.fillArea(5, 5, '*');
		canvas.fillArea(0, 0, '*');
		canvas.fillArea(0, 5, '*');
		canvas.fillArea(9, 6, '*');
		canvas.fillArea(7, 9, '*');
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void fillAllNarrowPathsInLabyrinthSeedFromLeftUpperPosition() {

		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', '@', 'x', 'x', 'x', 'x', '@', '@', '@', '|'},
				{ '|', '@', 'x', ' ', ' ', 'x', '@', 'x', '@', '|'},
				{ '|', '@', 'x', ' ', ' ', 'x', '@', 'x', '@', '|'},
				{ '|', '@', 'x', 'x', 'x', 'x', '@', 'x', '@', '|'},
				{ '|', '@', '@', '@', '@', '@', '@', 'x', '@', '|'},
				{ '|', '@', 'x', 'x', 'x', 'x', 'x', 'x', '@', '|'},
				{ '|', '@', 'x', '@', '@', '@', '@', '@', '@', '|'},
				{ '|', '@', 'x', '@', 'x', 'x', 'x', '@', '@', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};

		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Rectangle rectangle = new Rectangle(2, 1, 5, 4);
		rectangle.paint();
		Line line1 = new Line(2, 6, 7, 6);
		line1.paint();
		Line line2 = new Line(4, 8, 6, 8);
		line2.paint();
		Line line3 = new Line(2, 6, 2, 8);
		line3.paint();
		Line line4 = new Line(7, 2, 7, 6);
		line4.paint();
		canvas.fillArea(1, 2, '@');
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void fillAllNarrowPathsInLabyrinthSeedFromLeftBottomPosition() {

		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', '@', 'x', 'x', 'x', 'x', '@', '@', '@', '|'},
				{ '|', '@', 'x', ' ', ' ', 'x', '@', 'x', '@', '|'},
				{ '|', '@', 'x', ' ', ' ', 'x', '@', 'x', '@', '|'},
				{ '|', '@', 'x', 'x', 'x', 'x', '@', 'x', '@', '|'},
				{ '|', '@', '@', '@', '@', '@', '@', 'x', '@', '|'},
				{ '|', '@', 'x', 'x', 'x', 'x', 'x', 'x', '@', '|'},
				{ '|', '@', 'x', '@', '@', '@', '@', '@', '@', '|'},
				{ '|', '@', 'x', '@', 'x', 'x', 'x', '@', '@', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};

		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Rectangle rectangle = new Rectangle(2, 1, 5, 4);
		rectangle.paint();
		Line line1 = new Line(2, 6, 7, 6);
		line1.paint();
		Line line2 = new Line(4, 8, 6, 8);
		line2.paint();
		Line line3 = new Line(2, 6, 2, 8);
		line3.paint();
		Line line4 = new Line(7, 2, 7, 6);
		line4.paint();
		canvas.fillArea(1, 7, '@');
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void fillAllNarrowPathsInLabyrinthSeedFromRightPosition() {

		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', '@', 'x', 'x', 'x', 'x', '@', '@', '@', '|'},
				{ '|', '@', 'x', ' ', ' ', 'x', '@', 'x', '@', '|'},
				{ '|', '@', 'x', ' ', ' ', 'x', '@', 'x', '@', '|'},
				{ '|', '@', 'x', 'x', 'x', 'x', '@', 'x', '@', '|'},
				{ '|', '@', '@', '@', '@', '@', '@', 'x', '@', '|'},
				{ '|', '@', 'x', 'x', 'x', 'x', 'x', 'x', '@', '|'},
				{ '|', '@', 'x', '@', '@', '@', '@', '@', '@', '|'},
				{ '|', '@', 'x', '@', 'x', 'x', 'x', '@', '@', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};

		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Rectangle rectangle = new Rectangle(2, 1, 5, 4);
		rectangle.paint();
		Line line1 = new Line(2, 6, 7, 6);
		line1.paint();
		Line line2 = new Line(4, 8, 6, 8);
		line2.paint();
		Line line3 = new Line(2, 6, 2, 8);
		line3.paint();
		Line line4 = new Line(7, 2, 7, 6);
		line4.paint();
		canvas.fillArea(8, 5, '@');
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void fillAllNarrowPathsInLabyrinthSeedFromBottomPosition() {

		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', '@', 'x', 'x', 'x', 'x', '@', '@', '@', '|'},
				{ '|', '@', 'x', ' ', ' ', 'x', '@', 'x', '@', '|'},
				{ '|', '@', 'x', ' ', ' ', 'x', '@', 'x', '@', '|'},
				{ '|', '@', 'x', 'x', 'x', 'x', '@', 'x', '@', '|'},
				{ '|', '@', '@', '@', '@', '@', '@', 'x', '@', '|'},
				{ '|', '@', 'x', 'x', 'x', 'x', 'x', 'x', '@', '|'},
				{ '|', '@', 'x', '@', '@', '@', '@', '@', '@', '|'},
				{ '|', '@', 'x', '@', 'x', 'x', 'x', '@', '@', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};

		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		Rectangle rectangle = new Rectangle(2, 1, 5, 4);
		rectangle.paint();
		Line line1 = new Line(2, 6, 7, 6);
		line1.paint();
		Line line2 = new Line(4, 8, 6, 8);
		line2.paint();
		Line line3 = new Line(2, 6, 2, 8);
		line3.paint();
		Line line4 = new Line(7, 2, 7, 6);
		line4.paint();
		canvas.fillArea(3, 8, '@');
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void fillRectanglesIntersections() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', '4', '4', '4', '4', '4', '4', '4', '4', '4', '|'},
				{ '|', '4', '4', '4', 'x', 'x', 'x', 'x', 'x', '4', '|'},
				{ '|', '4', '4', '4', 'x', '3', '3', '3', 'x', '4', '|'},
				{ '|', '4', 'x', 'x', 'x', 'x', 'x', '3', 'x', '4', '|'},
				{ '|', '4', 'x', '1', 'x', '2', 'x', '3', 'x', '4', '|'},
				{ '|', '4', 'x', '1', 'x', '2', 'x', '3', 'x', '4', '|'},
				{ '|', '4', 'x', '1', 'x', '2', 'x', '3', 'x', '4', '|'},
				{ '|', '4', 'x', '1', 'x', '2', 'x', '3', 'x', '4', '|'},
				{ '|', '4', 'x', '1', 'x', '2', 'x', '3', 'x', '4', '|'},
				{ '|', '4', 'x', '1', 'x', 'x', 'x', 'x', 'x', '4', '|'},
				{ '|', '4', 'x', '1', '1', '1', 'x', '4', '4', '4', '|'},
				{ '|', '4', 'x', 'x', 'x', 'x', 'x', '4', '4', '4', '|'},
				{ '|', '4', '4', '4', '4', '4', '4', '4', '4', '4', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(9, 13);
		Rectangle rectangle1 = new Rectangle(4, 2, 8, 10);
		rectangle1.paint();
		Rectangle rectangle2 = new Rectangle(2, 4, 6, 12);
		rectangle2.paint();
		canvas.fillArea(3, 5, '1');
		canvas.fillArea(5, 7, '2');
		canvas.fillArea(7, 5, '3');
		canvas.fillArea(2, 2, '4');
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void fillUncenteredCrossSeedFromTop() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(9, 13);
		Line line1 = new Line(3, 2, 3, 6);
		line1.paint();
		Line line2 = new Line(1, 4, 5, 4);
		line2.paint();
		canvas.fillArea(3, 2, '#');
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void fillUncenteredCrossSeedFromBottom() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(9, 13);
		Line line1 = new Line(3, 2, 3, 6);
		line1.paint();
		Line line2 = new Line(1, 4, 5, 4);
		line2.paint();
		canvas.fillArea(3, 6, '#');
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void fillUncenteredCrossSeedFromLeft() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(9, 13);
		Line line1 = new Line(3, 2, 3, 6);
		line1.paint();
		Line line2 = new Line(1, 4, 5, 4);
		line2.paint();
		canvas.fillArea(1, 4, '#');
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void fillUncenteredCrossSeedFromRight() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(9, 13);
		Line line1 = new Line(3, 2, 3, 6);
		line1.paint();
		Line line2 = new Line(1, 4, 5, 4);
		line2.paint();
		canvas.fillArea(5, 4, '#');
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void notPossibleToFillAreaWithSeedOutsideOfCanvas() {
		Canvas canvas = Canvas.getInstance();
		canvas.init(10, 10);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			canvas.fillArea(15, 15, '#');
		});
	}
}
