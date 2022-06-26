package masarik.paint;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class ColorPaletteManagerTest {
	
	@Rule
	public TestName name = new TestName();
	
	@Before
	public void printTestName(){
		System.out.println(name.getMethodName());
	}
	
	@After
	public void resetColorToDefault(){
		ColorPaletteManager palette = ColorPaletteManager.getInstance();
		palette.resetActiveColor();
	}
	

	@Test
	public void drawObjectWithNotDefaultColor() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', '%', '%', '%', '%', '%', '%', '%', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		ColorPaletteManager palette = ColorPaletteManager.getInstance();
		palette.setActiveColor('%');
		Line line = new Line(2, 4, 8, 4);
		line.paint();
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
		
	}
	
	@Test
	public void drawLinesWithMultipleColors() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', '%', '@', '%', '%', '%', '%', '%', '|'},
				{ '|', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', '*', '*', '*', '*', '*', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		ColorPaletteManager palette = ColorPaletteManager.getInstance();
		
		palette.setActiveColor('%');
		Line line = new Line(2, 4, 8, 4);
		line.paint();
		
		palette.setActiveColor('@');
		Line line2 = new Line(3, 2, 3, 8);
		line2.paint();
		
		palette.setActiveColor('*');
		Line line3 = new Line(1, 7, 5, 7);
		line3.paint();
		
		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
	
	@Test
	public void resetPalleteToDefaultColor() {
		
		char[][] expectedCanvas = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', '%', 'x', '%', '%', '%', '%', '%', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|'},
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};
	
		Canvas canvas = Canvas.getInstance();
		canvas.init(8, 8);
		ColorPaletteManager palette = ColorPaletteManager.getInstance();
		
		palette.setActiveColor('%');
		Line line = new Line(2, 4, 8, 4);
		line.paint();
		
		palette.resetActiveColor();
		Line line2 = new Line(3, 2, 3, 8);
		line2.paint();

		canvas.print();
		TestUtils.verifyCanvasContent(expectedCanvas, canvas.getContent());
	}
}
