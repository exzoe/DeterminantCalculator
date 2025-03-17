
public class task2{

    public static long[][] removeLastCol(long[][] arr){
        long[][] determinant = new long[arr.length][arr[0].length-1]; //матрица без последнего столбца
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                determinant[i][j] = arr[i][j];
            }
        }
        return determinant;
    }
    public static long[][] findLastCol(long[][] arr){
        long[][] result = new long[arr.length][1]; //последний столбец
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[0].length-2; j < arr[0].length; j++) {
                result[i][0] = arr[i][j];
            }
        }
        return result;
    }
    public static long[][] findMatrixByNum(long[][] determinant, long[][] lastcol, int num){
        long[][] matrix = new long[determinant.length][determinant[0].length];
        for (int i = 0; i < matrix.length; i++) { //копирование в другой массив во избежание ловушки ссылки
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = determinant[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) { //замена i столбца на lastCol столбец
            for (int j = num; j < num + 1; j++) {
                matrix[i][j] = lastcol[i][0];
            }
        }
        return matrix;
    }

    public static long[] solve(long[][] matrix){
        long[] triangles = new long[matrix[0].length];
        long[][] determinant = removeLastCol(matrix);
        long[][] lastcol = findLastCol(matrix);
        triangles[0] = task1.solve(determinant);
        for (int i = 0; i < matrix.length; i++) {
            long[][] arr = findMatrixByNum(determinant, lastcol, i);
            triangles[i+1] = task1.solve(arr);
        }
        long[] result = new long[triangles.length - 1];
        for (int i = 1; i < triangles.length; i++) {
            result[i-1] = triangles[i] / triangles[0];
        }
        return result;
    }
}
