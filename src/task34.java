public class task34 {
    public static int countPermutations = 0;

    public static int findRowOfMaxInCol(double[][] matrix, int col, int row){
        double maxInCol = matrix[row][col];
        for (int rowCount = row; rowCount < matrix.length; rowCount++) {
            if(matrix[rowCount][col] > maxInCol){
                maxInCol = matrix[rowCount][col];
                row = rowCount;
            }
        }
        return row;
    }

    public static double findMultiplier(double[] matrix, int col){
        if (matrix[col] == 0) {
            throw new ArithmeticException("Деление на ноль невозможно.");
        }
        return 1 / matrix[col];

    }

    public static double[][] toTringular(double[][] matrix){
        int rowCount = 0;
        for (int colNum = 0; colNum < matrix[0].length - 1; colNum++) { //проходимся по каждому столбцу
            int rowOfMax = findRowOfMaxInCol(matrix, colNum, rowCount); //находим строку максимального числа в столбце
            if(rowCount != rowOfMax){
                double[] temp = matrix[rowCount]; //ловушка ссылки
                matrix[rowCount] = matrix[rowOfMax];
                matrix[rowOfMax] = temp; // и меняем ее со строкой ведущего числа
                countPermutations++;

            }
            if (matrix[rowCount][colNum] == 0) {
                continue; //пропустить столбец, если ведущий элемент равен нулю
            }
            double multiplier = findMultiplier(matrix[rowCount], colNum); //находим множитель, при котором ведущее число будет 1
            for (int i = 0; i < matrix[rowCount].length; i++) {
                matrix[rowCount][i] *= multiplier; //и умножаем на этот множитель всю строку
            }
            for (int i = rowCount + 1; i < matrix.length; i++) { //проходимся по каждой строке, не доходя до последней
                double multiplierForRow = matrix[i][colNum] / matrix[rowCount][colNum]; //и ищем множитель, который бы обнулил все
                                                                                        //числа ниже ведущего
                for (int j = colNum; j < matrix[0].length; j++) {
                    matrix[i][j] -= matrix[rowCount][j] * multiplierForRow; //вычитаем из всего чисел столбца ниже ведущего
                }
            }
            rowCount++; //переходим на следующее ведущее число

        }
        return matrix;
    }

    public static double findDeterminant(double[][] matrix) { //таск3
        countPermutations = 0;
        double[][] triangular = toTringular(matrix.clone());

        // Проверка на нулевую строку (вырожденная матрица)
        for (int i = 0; i < triangular.length; i++) {
            if (Math.abs(triangular[i][i]) < 1e-10) {
                return 0;
            }
        }

        double det = 1.0;
        for (int i = 0; i < triangular.length; i++) {
            det *= triangular[i][i];
        }

        return det * Math.pow(-1, countPermutations);
    }

    public static double[] solve(double[][] matrix) {
        double[][] tringularMatrix = toTringular(matrix);
        double[] solutions = new double[tringularMatrix.length];

        for (int i = tringularMatrix.length - 1; i >= 0; i--) { //проходимся построчно с конца
            solutions[i] = tringularMatrix[i][tringularMatrix.length]; //сначала берем число в последнем столбце

            for (int j = i + 1; j < tringularMatrix.length; j++) { // идем по уже известным значениям
                solutions[i] -= tringularMatrix[i][j] * solutions[j]; //и вычитаем их из числа последнего столбца
            }

            solutions[i] /= tringularMatrix[i][i]; //делим на кэф самой переменной
        }

        return solutions;
    }


}