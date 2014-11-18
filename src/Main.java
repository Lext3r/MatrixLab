import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        Matrix matrix = new Matrix();
        int dimmension = readMatrixDimmension();
        int[][]inputMatrix = matrix.readMatrix(dimmension);
    }

    public static int readMatrixDimmension() throws FileNotFoundException {
        Scanner sc = new Scanner (new File("Matrix.txt"));
        return sc.nextInt();
    }
}
