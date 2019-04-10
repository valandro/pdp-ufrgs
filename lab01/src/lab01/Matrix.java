package lab01;

class Matrix {
    private int size;

    Matrix(int size) {
        this.size = size;
    }

    int[][] getMatrix() {
        //Creating square matrix
        int[][] matrix = new int[size][size];

        //Populate the matrix
        for(int i = 0; i < matrix.length; i++){
          for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i + j;
            }
        }

        //Print the matrix
        for (int[] x : matrix){
           for (int y : x)
           {
                System.out.print(y + " ");
           }
           System.out.println();
        }



        return matrix;
    }
}
