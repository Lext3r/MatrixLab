import java.io.*;
import java.io.File;
import java.util.Scanner;

/**
 * Class included some methods for matrix
 */

public class Matrix {

    /**
     * Method for rotating matrix by 90 degrees counterclockwise
     *
     * @param matrix
     * @return rotated matrix
     */
    public int[][] rotate90(int[][] matrix) {

        return reverseMatrixColumn(transposeMatrix(matrix));
    }

    /**
     * Method for rotating matrix by 180 degrees counterclockwise
     *
     * @param matrix
     * @return rotated matrix
     */
    public int[][] rotate180(int[][] matrix) {

        return reverseMatrixColumn(reverseMatrixRow(matrix));
    }

    /**
     * Method for rotating matrix by 270 degrees counterclockwise
     *
     * @param matrix
     * @return rotated matrix
     */
    public int[][] rotate270(int[][] matrix) {

        return reverseMatrixRow(transposeMatrix(matrix));
    }

    /**
     * Read matrix from input file
     *
     * @param dimmension
     * @return matrix
     * @throws FileNotFoundException
     */
    public int[][] readMatrix(int dimmension) throws FileNotFoundException {

        int[][] matrix = new int[dimmension][dimmension];
        Scanner in = new Scanner(new File("Matrix.txt"));
        in.nextLine();
        for (int row = 0; row < dimmension; row++) {
            for (int col = 0; col < dimmension; col++) {
                matrix[row][col] = in.nextInt();
            }
        }
        return matrix;
    }

    /**
     * Write matrix into output file
     *
     * @param matrix
     * @throws IOException
     */
    public void printMatrix(int[][] matrix) throws IOException {

        FileWriter out = new FileWriter(new File("NewMatrix.txt"));
        for (int[] row : matrix) {
            for (int element : row) {
                out.write(element + " ");
            }
            out.write("\n");
        }
        out.write("\n");
        out.close();
    }

    public int[][] transposeMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = row + 1; col < matrix.length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        return matrix;
    }

    /**
     * Flip matrix left to right
     *
     * @param matrix
     * @return
     */
    public int[][] reverseMatrixColumn(int[][] matrix) {

        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length / 2; row++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[matrix.length - row - 1][col];
                matrix[matrix.length - row - 1][col] = temp;
            }
        }
        return matrix;
    }

    /**
     * Flip matrix up to down
     *
     * @param matrix
     * @return
     */
    public int[][] reverseMatrixRow(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length / 2; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][matrix[row].length - col - 1];
                matrix[row][matrix[row].length - col - 1] = temp;
            }
        }
        return matrix;
    }

    /**
     * Check if all of the row have the same elements sum
     *
     * @param matrix
     * @param expectedSum
     * @return
     */
    boolean isRowElementsSumEqual(int[][] matrix, int expectedSum) {
        for (int row = 0; row < matrix.length; row++) {
            int sum = 0;
            for (int col = 0; col < matrix.length; col++) {
                sum += matrix[row][col];
            }
            if (sum != expectedSum) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if all of the row have the same elements sum
     *
     * @param matrix
     * @param expectedSum
     * @return
     */
    boolean isColumnElementsSumEqual(int[][] matrix, int expectedSum) {
        for (int col = 0; col < matrix.length; col++) {
            int sum = 0;
            for (int row = 0; row < matrix.length; row++) {
                sum += matrix[row][col];
            }
            if (sum != expectedSum) {
                return false;
            }
        }
        return true;
    }

    /**
     * Find the matrix main diagonal elements sum
     *
     * @param matrix
     * @return
     */
    int primaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum += matrix[row][row];
        }
        return sum;
    }

    /**
     * Find the matrix antidiagonal elements sum
     *
     * @param matrix
     * @return
     */
    int secondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum += matrix[row][matrix.length - 1 - row];
        }
        return sum;
    }

    /**
     * Magic square - arrangement of distinct numbers, in a square grid, where the numbers in each row,
     * and in each column, and the numbers in the main and secondary diagonals, all add up to the same number.
     *
     * @param matrix
     * @param checkValue
     * @return
     */
    String isMagicSquare(int[][] matrix, int checkValue) {
        if ((isColumnElementsSumEqual(matrix, checkValue)) &&
                (isRowElementsSumEqual(matrix, checkValue)) &&
                (checkValue == secondaryDiagonalSum(matrix))) {
            return ("OK!");
        } else {
            return ("No");
        }
    }

    /**
     * Latin square is an n × n array filled with n different symbols,
     * each occurring exactly once in each row and exactly once in each column.
     *
     * @param matrix
     * @return
     */
    String isLatinSquare(int[][] matrix) {
        if ((isColumnElementMultiplicationEqual(matrix, 6)) &&
                (isRowElementMultiplicationEqual(matrix, 6))) {
            return ("OK!");
        } else {
            return ("No");
        }
    }

    boolean isColumnElementMultiplicationEqual(int[][] matrix, int checkValue) {
        int sum = 1;
        for (int col = 0; col < matrix.length; col++) {
            sum = 1;
            for (int row = 0; row < matrix.length; row++) {
                sum *= matrix[row][col];
            }
            if (sum != checkValue) {
                return false;
            }
        }
        return true;
    }

    boolean isRowElementMultiplicationEqual(int[][] matrix, int checkValue) {
        int sum = 1;
        for (int row = 0; row < matrix.length; row++) {
            sum = 1;
            for (int col = 0; col < matrix.length; col++) {
                sum *= matrix[row][col];
            }
            if (sum != checkValue) {
                return false;
            }
        }
        return true;
    }
}