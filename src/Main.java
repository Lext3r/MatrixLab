import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private int[][] matrix;

    public static void main(String[] args) throws IOException {
        Matrix matrix = new Matrix();
        int dimmension = readMatrixDimmension();
        int[][]inputMatrix = matrix.readMatrix(dimmension);
        int checkValue = matrix.primaryDiagonalSum(inputMatrix);
        System.out.println(matrix.isMagicSquare(inputMatrix, checkValue));
        System.out.println(matrix.isLatinSquare(inputMatrix));
    }

    public static int readMatrixDimmension() throws FileNotFoundException {
        Scanner sc = new Scanner (new File("Matrix.txt"));
        return sc.nextInt();
    }
}
