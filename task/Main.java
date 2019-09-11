import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][A[j].length - j - 1];
                A[i][A[j].length - j - 1] = temp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 0) A[i][j] = 1;
                else A[i][j] = 0;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(flipAndInvertImage(new int[][]{{1,1,0,0}, {1,0,0,1}, {0,1,1,1}, {1,0,1,0}}));
    }
}
