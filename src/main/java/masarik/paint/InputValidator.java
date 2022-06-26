package masarik.paint;

/**
 * Provides support for validating of input commands
 * 
 * @author michal masarik
 *
 */
public class InputValidator {

	private static InputValidator SINGLETON;

	// example of command: "Q"
	public static final String QUIT_PATTERN = "Q";
	// example of command: "C 20 4"
	public static String CANVAS_PATTERN = "C\\s[0-9]*\\s[0-9]*";
	// example of command: "L 1 2 6 2"
	public static String LINE_PATTERN = "L\\s[0-9]*\\s[0-9]*\\s[0-9]*\\s[0-9]*";
	// example of command: "R 14 1 18 3"
	public static String RECTANGLE_PATTERN = "R\\s[0-9]*\\s[0-9]*\\s[0-9]*\\s[0-9]*";
	// example of command: "B 10 3 o"
	public static String FILL_PATTERN = "B\\s[0-9]*\\s[0-9]*\\s.";
	
	public static final String HELP_PATTERN = "H";

	// "Q|C\s[0-9]*\s[0-9]*|L\\s[0-9]*\\s[0-9]*\\s[0-9]*\\s[0-9]*|R\\s[0-9]*\\s[0-9]*\\s[0-9]*\\s[0-9]*|B\s[0-9]*\s[0-9]*\s."
	public static final String ALLOWED_COMMAND_PATTERN = QUIT_PATTERN + "|" + CANVAS_PATTERN + "|" + LINE_PATTERN + "|"
			+ RECTANGLE_PATTERN + "|" + FILL_PATTERN + "|" + HELP_PATTERN;

	private InputValidator() {
	}

	public static InputValidator getInstance() {
		if (SINGLETON == null) {
			SINGLETON = new InputValidator();
		}
		return SINGLETON;
	}

	public Boolean validateInputCommand(String command) {
		if (command.matches(ALLOWED_COMMAND_PATTERN)) {
			return true;
		} else {
			return false;
		}
	}

}
