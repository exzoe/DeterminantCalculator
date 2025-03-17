import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        long[][] matrix = {
                {1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,2,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,3,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,4,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,5,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,6,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,7,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,8,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,9,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,10,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,11,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,12,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,13},
        };
        //System.out.println(task1.solve(matrix));

        long[][] arr2 = {
                {2,4,-2},
                {5,-6,-37}
        };
        long[][] arr3Without = {
                {4, -3, 2},
                {5, -4, -8},
                {1, -2, -5}
        };
        double[][] arr3 = {
                {2, 1, -1, 8},
                {-3, -1, 2, 11},
                {-2, 1, 2, -3}
        };
        Random random = new Random();
        long[][] arrRand = new long[6][7];
        for (int i = 0; i < arrRand.length; i++) {
            for (int j = 0; j < arrRand[0].length; j++) {
                arrRand[i][j] = random.nextLong(10);
            }

        }
        System.out.println(Arrays.deepToString(task3.solve(arr3)));
    }
}