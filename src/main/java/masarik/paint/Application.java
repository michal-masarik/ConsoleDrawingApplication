package masarik.paint;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Program Console Drawing enables painting of lines, rectangles and filling
 * areas with color represented by characters on canvas. It's trivial paint
 * program, which uses console as user interface. Program accepts user commands
 * through console.
 * 
 * @author michal masarik
 *
 */
public class Application {

	/**
	 * Main method of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Canvas canvas = Canvas.getInstance();
		InputValidator inputValidator = InputValidator.getInstance();
		Scanner scan = new Scanner(System.in);
		Boolean canvasExists = false;

		System.out.println("CONSOLE DRAWING PROGRAM");

		while (true) {
			try {
				System.out.print("enter command: ");
				String inputString = scan.nextLine();
				if (inputValidator.validateInputCommand(inputString)) {
					if (inputString.equals("Q")) {
						System.out.println("Program was terminated by user.");
						scan.close();
						return;
					} else if (inputString.equals("H")) {
						printHelp();
					} else if (inputString.startsWith("C")) {
						canvasExists = processCanvasCommand(canvas, canvasExists, inputString);
					} else if (inputString.startsWith("L")) {
						processLineCommand(canvas, canvasExists, inputString);
					} else if (inputString.startsWith("R")) {
						processRectangleCommand(canvas, canvasExists, inputString);
					} else if (inputString.startsWith("B")) {
						processFillCommand(canvas, canvasExists, inputString);
					}
				} else {
					System.out.println("Error: unknown command. (H for help)");
				}
			} catch (InputMismatchException e) {
				e.printStackTrace();
			}
		}
	}

	private static void processFillCommand(Canvas canvas, Boolean canvasExists, String inputString) {
		if (canvasExists) {
			String[] splitStr = inputString.split("\\s+");
			int x = Integer.valueOf(splitStr[1]);
			int y = Integer.valueOf(splitStr[2]);
			char c = splitStr[3].charAt(0);

			try {
				canvas.fillArea(x, y, c);
				canvas.print();
			} catch (Exception e) {
				System.out.println("Error: Not possible to fill this area: " + e.getMessage());
			}
		} else {
			System.out.println("Error: Not possible to use Filling tool without existing canvas.");
		}
	}

	private static Boolean processCanvasCommand(Canvas canvas, Boolean canvasExists, String inputString) {
		String[] splitStr = inputString.split("\\s+");
		int w = Integer.valueOf(splitStr[1]);
		int h = Integer.valueOf(splitStr[2]);
		try {
			canvas.init(w, h);
			canvasExists = true;
			canvas.print();
		} catch (Exception e) {
			System.out.println("Error: Not possible to drawn canvas: " + e.getMessage());
		}
		return canvasExists;
	}

	private static void processLineCommand(Canvas canvas, Boolean canvasExists, String inputString) {
		if (canvasExists) {
			String[] splitStr = inputString.split("\\s+");
			int x1 = Integer.valueOf(splitStr[1]);
			int y1 = Integer.valueOf(splitStr[2]);
			int x2 = Integer.valueOf(splitStr[3]);
			int y2 = Integer.valueOf(splitStr[4]);
			Line line = null;
			try {
				line = new Line(x1, y1, x2, y2);
				line.paint();
				canvas.print();
			} catch (Exception e) {
				System.out.println("Error: Not possible to drawn Line: " + e.getMessage());
			}
		} else {
			System.out.println("Error: Not possible to draw Line without existing canvas.");
		}
	}

	private static void processRectangleCommand(Canvas canvas, Boolean canvasExists, String inputString) {
		if (canvasExists) {
			String[] splitStr = inputString.split("\\s+");
			int x1 = Integer.valueOf(splitStr[1]);
			int y1 = Integer.valueOf(splitStr[2]);
			int x2 = Integer.valueOf(splitStr[3]);
			int y2 = Integer.valueOf(splitStr[4]);
			Rectangle rectangle = null;
			try {
				rectangle = new Rectangle(x1, y1, x2, y2);
				rectangle.paint();
				canvas.print();
			} catch (Exception e) {
				System.out.println("Error: Not possible to drawn Rectangle: " + e.getMessage());
			}
		} else {
			System.out.println("Error: Not possible to draw Rectangle without existing canvas.");
		}
	}

	private static void printHelp() {
		System.out.println("-HELP-------------------------");
		System.out.println("C 20 4 - creates canvas with width 20 and height 4");
		System.out.println("L 1 2 6 2 - draws line from position [1,1] to position [6,2]");
		System.out.println("R 14 1 18 3 - draws rectangle with left up position [14,1] and right bottom [18,3]");
		System.out.println("B 10 3 o - fills entire area surrounded position [10,3] with color [o]");
		System.out.println("Q - Quit application");
		System.out.println();
		System.out.println("Author: Michal Masarik, Java application");
		System.out.println("------------------------------");
	}
}
