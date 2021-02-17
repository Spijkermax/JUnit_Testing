/**
 * This class takes two integer parameters to either multiply, divide, add or
 * subtract them.
 * 
 * @author spijkemax
 *
 */

public class MyMath {

	/** multiplies two values by taking parameters of int x and int y */

	/**
	 * this will return multiplication of x and y
	 * 
	 * @param x
	 * @param y
	 * @return x * y
	 * 
	 */
	public double multiply(double x, double y) {
		try {
			return x * y;
		
	} catch (IllegalArgumentException f) {
		throw new IllegalArgumentException("cant set all parameters to 0");
	}
	}
	/**
	 * divides two values by taking parameters of int x and int
	 * 
	 * @param x
	 * @param y
	 * @return x / y this will return division of x and y
	 */
	public double divide(double x, double y) {
		try {
			return x / y;

		} catch (ArithmeticException e) {
			throw new ArithmeticException("Division by 0 not possible");
		} catch (IllegalArgumentException f) {
			throw new IllegalArgumentException("cant set all parameters to 0");
		}
	}

	/**
	 * adds two values by taking parameters of int x and int y
	 * 
	 * @param x
	 * @param y
	 * @return x + y this will add x and y
	 */
	public double add(double x, double y) {
		return x + y;
	}

	/**
	 * subtracts two values by taking parameters of int x and int y this will return
	 * x minus y
	 * 
	 * @param x
	 * @param y
	 * @return x - y
	 * 
	 */
	public double subtract(double x, double y) {
		return x - y;
	}

	/**
	 * Returns a new array (result) of the multiplication of two vector array
	 * parameters
	 * 
	 * @param vectorOne
	 * @param vectorTwo
	 * @return vectorOne * vectorTwo (for each comparable index)
	 */

	public double[] multiplyVector(double[] vectorOne, double[] vectorTwo) {
		try {
			double[] product = new double[vectorOne.length]; // take values from vector1
			for (int i = 0; i < vectorTwo.length; i++) {
				product[i] = vectorOne[i] * vectorTwo[i]; // multiply each element in vector1 array by every value in
															// vector
															// two array
			}
			return product;
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException("Out of bounds index. Vectors should be equal length");
		}
	}

	/**
	 * Multiplies matrix by vector
	 * 
	 * @param matrix
	 * @param vector
	 * @return matrix * vector
	 */
	public double[] multiplyMatrixByVector(double[] vector, double[][] matrix) { // think of it as matrix * matrix
			double cols = matrix[0].length; // number of columns in first index/get the second dimenson of the 2d array
			double[] product = new double[matrix.length]; // multiply this product against the product of the matrix and
			// vector
			for (int i = 0; i < matrix.length; i++) { // for every index value in the rows of the matrix
				for (int j = 0; j < cols; j++) { // get each index value in each column and...
					product[i] = product[i] + matrix[i][j] * vector[j]; // Multiply by the vector, which only has 1
																		// column

				}

			}
			return product;
		} 
	

	/**
	 * Checks whether given matrix parameter is an identity matrix. returns boolean
	 * true or false.
	 * 
	 * @param matrix
	 * @return boolean
	 */
	public boolean isIdentityMatrix(double[][] matrix) {
		for (int i = 0; i < matrix.length; i++) { //for all of the rows
			for (int j = 0; j < matrix[i].length/2; j++) { //check each column value in the row
				if (matrix[i][j] != matrix[i][matrix[i].length - j - 1]) { //if the row and column is not equal 
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Multiplies the rows and columns of two matrices
	 * 
	 * @param firstMatrix
	 * @param secondMatrix
	 * @return
	 */

	public double[][] multiplyMatrices(double[][] matrixOne, double[][] matrixTwo) {
		try {
			double[][] product = new double[matrixOne.length][matrixTwo[0].length];
			for (int i = 0; i < matrixOne.length; i++) {
				for (int j = 0; j < matrixTwo[0].length; j++) {
					for (int k = 0; k < matrixOne[0].length; k++) {
						product[i][j] += matrixOne[i][k] * matrixTwo[k][j];
					}
				}
			}
			return product;
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException(
					"Incompatible matrices. cols of first matrix must equal rows of second matrix");
		}
	}
	/** 
	 * 
	 * 
	 * @param matrix
	 * @return
	 */
	
    public double[][] transposeMatrix(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        double[][] product = new double[columns][rows]; //swap columns and rows
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                product[j][i] = matrix[i][j]; 
            } 
        }
        return product;
    }
}