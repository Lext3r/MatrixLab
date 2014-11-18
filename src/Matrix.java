import java.io.*;
import java.util.Scanner;

public class Matrix {

    public int[][] rotate90(int[][] matrix) {

        return reverseMatrixColumn(transposeMatrix(matrix));
    }

    public int[][] rotate180(int[][] matrix){

        return reverseMatrixColumn(reverseMatrixRow(matrix));
    }

    public int[][] rotate270(int[][] matrix){

        return reverseMatrixRow(transposeMatrix(matrix));
    }

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

    public void printMatrix(int[][] matrix) throws IOException {

        FileWriter out = new FileWriter(new File("NewMatrix.txt"));
        for (int[] row : matrix) {
            for (int element : row) {
                out.write(element+" ");
            }
            out.write("\n");
        }
        out.write("\n");
        out.close();
    }

    public int[][] transposeMatrix(int[][] matrix){

        for (int row = 0; row < matrix.length; row++) {
            for (int col = row+1; col < matrix.length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        return matrix;
    }

    public int[][] reverseMatrixColumn(int[][] matrix){

        for(int col = 0;col < matrix[0].length; col++){
            for(int row = 0; row < matrix.length/2; row++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[matrix.length - row - 1][col];
                matrix[matrix.length - row - 1][col] = temp;
            }
        }
        return matrix;
    }

    public int[][] reverseMatrixRow(int[][] matrix){

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length / 2; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][matrix[row].length - col - 1];
                matrix[row][matrix[row].length - col - 1] = temp;
            }
        }
        return matrix;
    }

    boolean isRowElementsSumEqual(int [][] matrix, int expectedSum){
        for (int row = 0; row < matrix.length; row++) {
            int sum = 0;
            for (int col = 0; col < matrix.length; col++) {
                sum += matrix[row][col];
            }
            if(sum != expectedSum){
                return false;
            }
        }
        return true;
    }

    boolean isColumnElementsSumEqual(int [][] matrix, int expectedSum){
        for (int col = 0; col < matrix.length; col++) {
            int sum = 0;
            for (int row = 0; row < matrix.length; row++) {
                sum += matrix[row][col];
            }
            if(sum != expectedSum){
                return false;
            }
        }
        return true;
    }

    int primaryDiagonalSum(int[][] matrix){
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum+=matrix[row][row];
        }
        return sum;
    }

    int secondaryDiagonalSum(int[][] matrix){
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum+=matrix[row][matrix.length-1-row];
        }
        return sum;
    }

    String isMagic(int[][] matrix, int checkValue){
        if ((isColumnElementsSumEqual(matrix,checkValue) == true) &&
                (isRowElementsSumEqual(matrix, checkValue) == true) &&
                (checkValue==secondaryDiagonalSum(matrix))) {
            return("OK!");
        } else {
            return ("No");
        }
    }

}
