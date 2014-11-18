import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Matrix matrix = new Matrix();
        int dimmension = matrix.readMatrixDimmension();
        int [][] inputMatrix = matrix.readMatrix(dimmension);
        int [][]matrix90 = matrix.rotate(inputMatrix,dimmension);
        matrix.printMatrix(matrix90);

    }
}
