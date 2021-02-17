import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MyMathTestVectorMatrix {
	private double[] vector;
	private double[][] matrix;
	private double[] expectedResult;
	private Type type;
	private MyMath mymath;

	enum Type {
		MULTIPLY
	};

	public MyMathTestVectorMatrix(Type type, double[] vector, double[][] matrix, double[] expectedResult) {
		super();
		this.type = type;
		this.vector = vector;
		this.matrix = matrix;
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
				{ Type.MULTIPLY, new double[] {1,2,3,4}, new double[][] {{1,2},{3,4}}, new double[] {5,11,15,22} },
				{ Type.MULTIPLY, new double[] {1*1,2*1}, new double[][] {{1,2},{3,4}}, new double[] {5,11,15,22} }, 
				{ Type.MULTIPLY, new double[] {1/1,2/1,3/1,4/1}, new double[][] {{1,2},{3,4}}, new double[] {5,11,15,22}},
				{ Type.MULTIPLY, new double[] {-1,-2,-4,-5}, new double[][] {{1,2},{3,4}}, new double[] {5,11,15,22}},
				{ Type.MULTIPLY, new double[] {0,0,-0,0}, new double[][] {{0,0},{0,0}}, new double[] {0,0,0,0} },
				{ Type.MULTIPLY, new double[] {1,2,0,5}, new double[][] {{1,2},{3,4}}, new double[] {5,11,15,22} },
				//{ Type.MULTIPLY, new double[] {1/0,2/0,4/0,5/0}, new double[][] {{1,2},{3,4}}, new double[] {5,11,15,22} }
	});
	}

	@Test
	public void multiplyVectorByMatrix() {
		Assume.assumeTrue(type == Type.MULTIPLY);
		assertArrayEquals(expectedResult, mymath.multiplyMatrixByVector(vector, matrix));
	}
}