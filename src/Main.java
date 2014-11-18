import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Matrix matrix = new Matrix();
        int dimmension = matrix.readMatrixDimmension();
        int[][]inputMatrix = matrix.readMatrix(dimmension);
        int checkValue = matrix.primaryDiagonalSum(inputMatrix);
        System.out.println(matrix.isMagicSquare(inputMatrix, checkValue));
        System.out.println(matrix.isLatinSquare(inputMatrix));
    }

}
