import java.util.Arrays;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length; // matrix row length
        int cols = matrix[0].length; // matrix at index 0 length

        boolean rowZero = false; // set the row boolean to zero
        boolean colZero = false; // set the columnn boolean

        // [row][col]
        // row horizontal 
        // column vertical 


        // check if the first row of the matrix contains zero
        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                rowZero = true;
                break;
            }
        }

        // check if the first column contains zero
        for (int j = 0; j < rows; j++) {
            if (matrix[j][0] == 0) {
                colZero = true;
                break;
            }
        }

        // mark rows and columns to be zero based on the rest of the elements in the matrix
        for (int i = 1; i < rows; i++) { // loop through rows start from index 1
            for (int j = 1; j < cols; j++) { // loop through cols
                if (matrix[i][j] == 0) { // if any of the rows/cols are zero
                    matrix[i][0] = 0; // make the row at i 0
                    matrix[0][j] = 0; // make the column 0
                }
            }
        }

        // make all the elements in the marked rows and columns 0
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // make the first row 0 if need be
        if (rowZero) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }
        
        // make first column zero if need be
        if (colZero) {
            for (int j = 0; j < rows; j++) {
                matrix[j][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetZeroes setzero = new SetZeroes();
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
        int[][] matrix2 = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        setzero.setZeroes(matrix);
        setzero.setZeroes(matrix2);

        // print in matrix style
        System.out.println("Test case: 1");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println("\nTest case: 2");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix2[i]));
        }

    }
}
