import java.util.*;

public class Main {

    static long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;

        if (n == 1) {
            return new long[][]{{A[0][0] * B[0][0]}};
        }

        int m = n / 2;

        long[][] A11 = new long[m][m];
        long[][] A12 = new long[m][m];
        long[][] A21 = new long[m][m];
        long[][] A22 = new long[m][m];

        long[][] B11 = new long[m][m];
        long[][] B12 = new long[m][m];
        long[][] B21 = new long[m][m];
        long[][] B22 = new long[m][m];

        split(A, A11, A12, A21, A22);
        split(B, B11, B12, B21, B22);

        long[][] M1 = multiply(add(A11, A22), add(B11, B22));
        long[][] M2 = multiply(add(A21, A22), B11);
        long[][] M3 = multiply(A11, subtract(B12, B22));
        long[][] M4 = multiply(A22, subtract(B21, B11));
        long[][] M5 = multiply(add(A11, A12), B22);
        long[][] M6 = multiply(subtract(A21, A11), add(B11, B12));
        long[][] M7 = multiply(subtract(A12, A22), add(B21, B22));

        long[][] C11 = add(subtract(add(M1, M4), M5), M7);
        long[][] C12 = add(M3, M5);
        long[][] C21 = add(M2, M4);
        long[][] C22 = add(subtract(add(M1, M2), M3), M6);

        return combine(C11, C12, C21, C22);
    }

    static long[][] add(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        return C;
    }

    static long[][] subtract(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }

        return C;
    }

    static void split(long[][] A, long[][] A11, long[][] A12,
                      long[][] A21, long[][] A22) {

        int m = A.length / 2;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                A11[i][j] = A[i][j];
                A12[i][j] = A[i][j + m];
                A21[i][j] = A[i + m][j];
                A22[i][j] = A[i + m][j + m];
            }
        }
    }

    static long[][] combine(long[][] C11, long[][] C12,
                            long[][] C21, long[][] C22) {

        int m = C11.length;
        int n = m * 2;

        long[][] C = new long[n][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                C[i][j] = C11[i][j];
                C[i][j + m] = C12[i][j];
                C[i + m][j] = C21[i][j];
                C[i + m][j + m] = C22[i][j];
            }
        }

        return C;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[][] A = new long[n][n];
        long[][] B = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextLong();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = sc.nextLong();
            }
        }

        long[][] C = multiply(A, B);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j]);

                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

#Input
2
2 1
3 4
5 2
1 3
#Output
11 7
19 18
