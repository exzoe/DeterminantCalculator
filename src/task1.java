public class task1 {
    public static long solve(long[][] arr){
        if(arr.length != arr[0].length){
            return 0;
        }
        if(arr.length == 1){
            return arr[0][0];
        }
        else if(arr.length == 2){
            return arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0];
        }
        else{
            long result = 0;
            for (int i = 0; i < arr.length; i++) {
                result += (long) (Math.pow(-1, i) * arr[0][i] * solve(createNewMatrix(arr, 0, i)));
            }
            return result;
        }
    }

    public static long[][] createNewMatrix(long[][] arr, int row, int col){
        long[][] minor = new long[arr.length-1][arr[0].length-1];
        for (int i = 0, minorRow = 0; i < arr.length; i++) {
            for (int j = 0, minorCol = 0; j < arr[0].length; j++) {
                if(i != row && j != col){
                    minor[minorRow][minorCol] = arr[i][j];
                    minorCol++;
                    if(minorCol == arr[0].length - 1){
                        minorCol = 0;
                        minorRow++;
                    }
                }

            }
        }
        return minor;
    }
}
