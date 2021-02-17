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
public class MyMathTestTransposeMatrix {
	private double[][] matrix;
	private double[][] result;
	private Type type;
	private MyMath mymath;

	enum Type {
		TRANSPOSE
	};

	public MyMathTestTransposeMatrix(Type type, double[][] matrix, double[][] result) {
		super();
		this.type = type;
		this.matrix = matrix;
		this.result = result;
	}

	@Before
	public void initialize() {
		mymath = new MyMath();
	}

	@Parameterized.Parameters
	public static Collection input() {
		return Arrays.asList(new Object[][] {
				// Multiply Test cases: Need to test for uneven matrix(e.g. uneven rows), positive, negative, division during transpose process
				{ Type.TRANSPOSE, new double[][] {{0,1},{0,1}},new double[][] {{0,1},{0,1}} }
	
	});
	}

	@Test
	public void traverseMatrix() {
		Assume.assumeTrue(type == Type.TRANSPOSE);
		assertArrayEquals(mymath.transposeMatrix(matrix));
	}
}