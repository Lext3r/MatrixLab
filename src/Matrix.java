import java.io.*;
import java.util.Scanner;

public class Matrix {

    public int[][] readMatrix(int dimmension) throws FileNotFoundException {
        int[][] matrix = new int[dimmension][dimmension];
        Scanner in = new Scanner(new File("Matrix.txt"));
        in.nextLine();
        for (int i = 0; i < dimmension; i++) {
            for (int j = 0; j < dimmension; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        return matrix;
    }

    public int readMatrixDimmension() throws FileNotFoundException {
        Scanner sc = new Scanner (new File("Matrix.txt"));
        return sc.nextInt();
    }

    public void printMatrix(int[][] matrix) throws IOException {
        FileWriter out = new FileWriter(new File("NewMatrix.txt"));
        for (int[] row : matrix) {
            for (int element : row) {
                out.write(element+" ");
            }
            out.write("\n");
        }
        out.close();
    }

    public int[][] rotate90(int[][] matrix, int dimmension){
        int tmp;
        for(int i = 0; i < dimmension / 2; i++)
        {
            for(int j = i; j < dimmension - 1 - i; j++)
            {
                tmp = matrix[i][j];
                matrix[i][j]=matrix[j][dimmension - 1 - i];
                matrix[j][dimmension - 1 - i] = matrix[dimmension - 1 -i][dimmension - 1 - j];
                matrix[dimmension - 1 - i][dimmension - 1 - j] = matrix[dimmension - 1 - j][i];
                matrix[dimmension - 1 - j][i] = tmp;
            }
        }
        return matrix;
    }

    public int[][] rotate270(int[][] matrix, int dimmension){
        int tmp;
        for(int i = 0; i < dimmension / 2; i++)
        {
            for(int j = i; j < dimmension - 1 - i; j++)
            {
                tmp = matrix[i][j];
                matrix[i][j]=matrix[j][dimmension - 1 - i];
                matrix[j][dimmension - 1 - i] = matrix[dimmension - 1 - i][dimmension - 1 - j];
                matrix[dimmension - 1 - i][dimmension - 1 - j] = matrix[dimmension - 1 - j][i];
                matrix[dimmension - 1 - j][i] = tmp;
            }
        }
        return matrix;
    }
}
