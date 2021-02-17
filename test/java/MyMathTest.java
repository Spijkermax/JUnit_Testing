import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MyMathTest {
	private double firstNumber;
	private double secondNumber;
	private double expectedResult;
	private Type type;
	private MyMath mymath;

	enum Type {
		ADD, SUBTRACT, MULTIPLY, DIVIDE
	}; //Represent some constant fields for the types of test cases using enums, rather than use array of string

	public MyMathTest(Type type, double firstParameter, double secondParameter, double expectedResult) {
		super();
		this.type = type;
		this.firstNumber = firstParameter;
		this.secondNumber = secondParameter;
		this.expectedResult = expectedResult;
	}

	@Before
	public void initialize() {
		mymath = new MyMath();
	}

	@Parameterized.Parameters
	public static Collection input() {
		return Arrays.asList(new Object[][] {
				// Multiply Test cases e.g. [0] to => [6]:
				{ Type.MULTIPLY, 5, 2, 10 },{Type.MULTIPLY, 0,0,0}, { Type.MULTIPLY, 0, -5, 0 }, { Type.MULTIPLY, +5, +5, +25 },{ Type.MULTIPLY, 2347599, 8743999, 2.0527403308401e13},{Type.MULTIPLY, 1.1, 2.2,2.42},
				// Divide test cases:
				{ Type.DIVIDE, 10, 2, 5 }, { Type.DIVIDE, 10, 0, 0 }, { Type.DIVIDE, 0, 0, 0 }, {Type.DIVIDE, 0.5, 1,0.5}, {Type.DIVIDE, 2.0527403308401e13, 8743999, 2347599},
				{ Type.DIVIDE, 0, 10, 0 },{ Type.DIVIDE, 1*1, 1*2, 0.5},
				// Subtract Test cases:
				{ Type.SUBTRACT, 10, 2, 8 }, { Type.SUBTRACT, 10, 0, 10 }, { Type.SUBTRACT, -5, -5, 0 }, {Type.SUBTRACT, +5, +5, 0},{Type.SUBTRACT, 5*1, 5 * 2, -5},
				// Add Test cases:
				{ Type.ADD, 10, 2, 12 }, { Type.ADD, 0, 0, 0 }, { Type.ADD, -0, -1, -1 }, { Type.ADD, +10, +2, +12 }, {Type.ADD, -10, 2, -8}, {Type.ADD, 1.1, 2.2, 3.3} });	
	}

	@Test
	public void testMultiply() {
		Assume.assumeTrue(type == Type.MULTIPLY);
		assertEquals(expectedResult, mymath.multiply(firstNumber, secondNumber)); // regular test
		// fail("Not yet implemented"); // TODO
	}

	@Test
	public void testDivide() {
		Assume.assumeTrue(type == Type.DIVIDE);
		assertEquals(expectedResult, mymath.divide(firstNumber, secondNumber));
	}
	@Test
	public void testAdd() {
		Assume.assumeTrue(type == Type.ADD);
		assertEquals(expectedResult, mymath.add(firstNumber, secondNumber));
	}
	@Test
	public void testSubtract() {
		Assume.assumeTrue(type == Type.SUBTRACT);
		assertEquals(expectedResult, mymath.subtract(firstNumber, secondNumber));
	}	
}