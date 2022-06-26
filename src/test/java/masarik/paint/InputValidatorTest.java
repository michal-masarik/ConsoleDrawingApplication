package masarik.paint;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class InputValidatorTest {
	private String input;
	private Boolean expectedResult;
	InputValidator inputValidator = InputValidator.getInstance();

	public InputValidatorTest(String input, Boolean expectedResult) {
		this.input = input;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> inputCommands() {
		return Arrays.asList(new Object[][] { 
			{ "Q", true }, 
			{ "C 20 4", true }, 
			{ "L 1 2 6 2", true },
			{ "R 14 1 18 3", true }, 
			{ "B 10 3 o", true },
			{ "q", false }, 
			{ "qq", false },
			{ "q1", false }, 
			{ "q1 2", false },
			{ "L", false }, 
			{ "L 1 1", false },
			{ "L 1 2 3 4 5", false }, 
			{ "L 1 B 1 2", false },
			{ "not bad place to hide some easter egg here", false },
			{ "R 1 2 3 4 5", false }, 
			{ "R 1 B 1 2", false },
			{ "R 1 2 3 4 5", false }, 
			{ "R 1 B 1 2", false },
			{ "B 1 2 3 4 ", false }, 
			{ "B @ B 1 2", false },
		});
	}

	@Test
	public void testInputCommand() {	
		assertEquals(expectedResult, inputValidator.validateInputCommand(input));
	}
}
