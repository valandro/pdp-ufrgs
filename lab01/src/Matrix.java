class Matrix {
    private int size;

    Matrix(int size) {
        this.size = size;
    }

    int[][] getMatrix() {
        switch (this.size) {
            case 3: {
                return new int[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
            }
            case 5: {
                return new int[][]{ {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15} };
            }
            case 7: {
                return new int[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} , {10, 11, 12}, {13, 14, 15}, {16, 17, 18}, {19, 20, 21} };
            }
            default:
                return new int[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        }
    }
}
