import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Matrix matrix = new Matrix();
        matrix.printMatrix(matrix.readMatrix(matrix.readMatrixDimmension()));
    }
}
