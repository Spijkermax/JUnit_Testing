import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MyMathTestMatrix {
	private double[][] firstMatrix;
	private double[][] secondMatrix;
	private double[][] expectedResult;
	private Type type;
	private MyMath mymath;

	enum Type {
		MULTIPLY
	};

	public MyMathTestMatrix(Type type, double[][] firstMatrix, double[][] secondMatrix, double[][] expectedResult) {
		super();
		this.type = type;
		this.firstMatrix = firstMatrix;
		this.secondMatrix = secondMatrix;
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
				{ Type.MULTIPLY, new double[][] {{1,2},{3,4}}, new double[][] {{1,2},{3,4}}, new double[][] {{7,10},{15,22}}},
					{Type.MULTIPLY, new double[][] {{1,2},{1,2}}, new double[][] {{1,2,3,4},{5,6,7,8}}, new double[][] {{7,10},{15,22}}},
					{Type.MULTIPLY, new double[][] {{1,2,4,5},{1,2,4,5,6}}, new double[][] {{1,2,3,4,5},{5,6,7,8}}, new double[][] {{7,10,12,14,18},{15,22,23,24}}},
					{ Type.MULTIPLY, new double[][] {{-1,-2},{-3,-4}}, new double[][] {{-1,-2},{-3,-4}}, new double[][] {{7,10},{15,22}}},
					{ Type.MULTIPLY, new double[][] {{1,2},{3,4}}, new double[][] {{-1,-2},{-3,-4}}, new double[][] {{-7,-10},{-15,-22}}},
					{ Type.MULTIPLY, new double[][] {{1,2},{3,4}}, new double[][] {{1,2},{3,4}}, new double[][] {{7,10},{15,22}}},
					{ Type.MULTIPLY, new double[][] {{0,0},{0,0}}, new double[][] {{0,0},{0,0}}, new double[][] {{0,0},{0,0}}},
					{ Type.MULTIPLY, new double[][] {{1*1,2*1},{3*1,4*1}}, new double[][] {{1*1,2*1},{3*1,4*1}}, new double[][] {{7*1,10*1},{15*1,22*1}}},
					{ Type.MULTIPLY, new double[][] {{1/1,2/1},{3/1,4/1}}, new double[][] {{1/1,2/1},{3/1,4/1}}, new double[][] {{7,10},{15,22}}}
					
					
	});
	}

	@Test
	public void multiplyMatrix1ByMatrix2() {
		Assume.assumeTrue(type == Type.MULTIPLY);
		assertArrayEquals(expectedResult, mymath.multiplyMatrices(firstMatrix, secondMatrix));
	}
}