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
public class MyMathTestMatrixIdentity {
	private double[][] matrix;
	private boolean result;
	private Type type;
	private MyMath mymath;

	enum Type {
		IDENTITY
	};

	public MyMathTestMatrixIdentity(Type type, double[][] matrix, boolean result) {
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
				// Multiply Test cases:
				{ Type.IDENTITY, new double[][] {{0,1},{0,1}}, true}, 
				{ Type.IDENTITY, new double[][] {{1,1},{1,1}}, false},
				{ Type.IDENTITY, new double[][] {{0,1},{-1,-0}}, false},
				{Type.IDENTITY, new double[][] {{0,9},{9,0}}, false},
	
	});
	}

	@Test
	public void isSymmetrical() {
		Assume.assumeTrue(type == Type.IDENTITY);
		assertEquals(mymath.isIdentityMatrix(matrix), true);
	}
}