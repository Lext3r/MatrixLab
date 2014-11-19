import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("Matrix.txt"));
        FileWriter out = new FileWriter(new File("NewMatrix.txt"));
        int dimmension = readMatrixDimmension(in);
        int[][]matrix = readMatrix(in,dimmension);
        printMatrix(matrix, out);

    }


    public int factorial(int num) {
        return (num == 0) ? 1 : num * factorial(num - 1);
    }

    public static int readMatrixDimmension(Scanner in){
        return in.nextInt();
    }

    public static int[][] readMatrix(Scanner in, int dimmension) {
        int[][] matrix = new int[dimmension][dimmension];
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
    public static void printMatrix(int[][] matrix, FileWriter out) throws IOException {
        for (int[] row : matrix) {
            for (int element : row) {
                out.write(element + " ");
            }
            out.write("\n");
        }
        out.write("\n");
        out.close();
    }
}

