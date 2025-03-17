public class task3 {

    public static int findRowOfMaxInCol(double[][] matrix, int col, int row){
        double maxInCol = matrix[0][col];
        for (int rowCount = row; rowCount < matrix.length; rowCount++) {
            if(matrix[rowCount][col] > maxInCol){
                maxInCol = matrix[rowCount][col];
                row = rowCount;
            }
        }
        return row;
    }

    public static double findMultiplier(double[] matrix, int col){
        return 1 / matrix[col];

    }

    public static double[][] solve(double[][] matrix){
        int rowCount = 0;
        for (int colNum = 0; colNum < matrix[0].length - 1; colNum++) {
            int rowOfMax = findRowOfMaxInCol(matrix, colNum, rowCount);
            if(rowCount != rowOfMax){
                double[] temp = matrix[rowCount]; //ловушка ссылки
                matrix[rowCount] = matrix[rowOfMax];
                matrix[rowOfMax] = temp;

            }

            double multiplier = findMultiplier(matrix[rowCount], colNum);
            for (int i = 0; i < matrix[rowCount].length; i++) {
                matrix[rowCount][i] *= multiplier;
            }
            for (int i = rowCount + 1; i < matrix.length; i++) {
                double multiplierForRow = matrix[i][colNum] / matrix[rowCount][colNum];
                for (int j = colNum; j < matrix[0].length; j++) {
                    matrix[i][j] -= matrix[rowCount][j] * multiplierForRow;
                }
            }
            rowCount++;

        }
        return matrix;
    }
}