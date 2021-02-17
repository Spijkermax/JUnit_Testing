import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MyMathTestVector {
	private double[] firstVector;
	private double[] secondVector;
	private double[] expectedResult;
	private Type type;
	private MyMath mymath;

	enum Type {
		MULTIPLY
	};

	public MyMathTestVector(Type type, double[] firstVector, double[] secondVector, double[] expectedResult) {
		super();
		this.type = type;
		this.firstVector = firstVector;
		this.secondVector = secondVector;
		this.expectedResult = expectedResult;
	}

	@Before
	public void initialize() {
		mymath = new MyMath();
	}

	@Parameterized.Parameters
	public static Collection input() {
		return Arrays.asList(new Object[][] {
				// Multiply Test cases:
				{ Type.MULTIPLY, new double[] {1,2,3}, new double[] {1,2,3}, new double[] {1,4,9}},
				{ Type.MULTIPLY, new double[] {0,0,0}, new double[] {0,0,0}, new double[] {0,0,0}},
				{ Type.MULTIPLY, new double[] {0/1,0/2,0/3}, new double[] {0/1,0/2,0/3}, new double[] {0/1,0/4,0/9}},
					{ Type.MULTIPLY, new double[] {1,2,3,4}, new double[] {1,2,3}, new double[] {1,3,4,9}},
					{ Type.MULTIPLY, new double[] {1,2,3}, new double[] {1,2,3,4,5}, new double[] {1,4,9,5,6}},
					{ Type.MULTIPLY, new double[] {1,2,3}, new double[] {1,2,3}, new double[] {9,9,9}},
					{ Type.MULTIPLY, new double[] {1,2,3}, new double[] {1,2,3}, new double[] {9,9,9}},
					{ Type.MULTIPLY, new double[] {1.1,2.1,3.1}, new double[] {1.1,2,3}, new double[] {1.21,9,9}},
					{ Type.MULTIPLY, new double[] {1/1,2/1,3/1}, new double[] {1/1,2/1,3/1}, new double[] {1,4,9}},
					{ Type.MULTIPLY, new double[] {+1,+2,+3}, new double[] {+1,+2,+3}, new double[] {9,9,9}},
					{ Type.MULTIPLY, new double[] {1234567899,1234567899,+1234567899}, new double[] {1234567899,1234567899,1234567899}, new double[] {1.52415789724127411e18,1.52415789724127411e18,1.52415789724127411e18}}
	});
	}

	@Test
	public void multiplyVector1ByVector2() {
		Assume.assumeTrue(type == Type.MULTIPLY);
		assertArrayEquals(expectedResult, mymath.multiplyVector(firstVector, secondVector));
	}
}