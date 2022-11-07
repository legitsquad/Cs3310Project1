package Project1;

import Project1.Main;
public class Strassen 
{
    public static int[][] strassenMultiply(int[][] m1, int[][] m2, int rowA, int colA, int rowB, int colB, int n) {
        int[][] m3 = new int[n][n];
        if (n == 1) {
            m3[0][0] = m1[rowA][colA] * m2[rowB][colB];
        } else {
            int N = n / 2;
            int[][] S1 = sub(m2, m2, rowB, colB + N, rowB + N, colB + N, N);
            int[][] S2 = add(m1, m1, rowA, colA, rowA, colA + N, N);
            int[][] S3 = add(m1, m1, rowA + N, colA, rowA + N, colA + N, N);
            int[][] S4 = sub(m2, m2, rowB + N, colB, rowB, colB, N);
            int[][] S5 = add(m1, m1, rowA, colA, rowA + N, colA + N, N);
            int[][] S6 = add(m2, m2, rowB, colB, rowB + N, colB + N, N);
            int[][] S7 = sub(m1, m1, rowA, colA + N, rowA + N, colA + N, N);
            int[][] S8 = add(m2, m2, rowB + N, colB, rowB + N, colB + N, N);
            int[][] S9 = sub(m1, m1, rowA, colA, rowA + N, colA, N);
            int[][] S10 = add(m2, m2, rowB, colB, rowB, colB + N, N);

            int[][] P1 = strassenMultiply(m1, S1, rowA, colA, 0, 0, N);
            int[][] P2 = strassenMultiply(S2, m2, 0, 0, rowB + N, colB + N, N);
            int[][] P3 = strassenMultiply(S3, m2, 0, 0, rowB, colB, N);
            int[][] P4 = strassenMultiply(m1, S4, rowA + N, colA + N, 0, 0, N);
            int[][] P5 = strassenMultiply(S5, S6, 0, 0, 0, 0, N);
            int[][] P6 = strassenMultiply(S7, S8, 0, 0, 0, 0, N);
            int[][] P7 = strassenMultiply(S9, S10, 0, 0, 0, 0, N);

            int[][] C1 = add(sub(add(P5, P4), P2), P6);
            int[][] C2 = add(P1, P2);
            int[][] C3 = add(P3, P4);
            int[][] C4 = sub(sub(add(P5, P1), P3), P7);

            join(C1, m3, 0, 0);
            join(C2, m3, 0, N);
            join(C3, m3, N, 0);
            join(C4, m3, N, N);
        }
        return m3;
    }

    private static void join(int[][] C1, int[][] m3, int row, int col) {
        int size = C1.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                m3[i + row][j + col] = C1[i][j];
            }
        }
    }


    private static int[][] add(int[][] m1, int[][] m2) {
        int[][] m3 = new int[m1.length][m2.length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2.length; j++) {
                m3[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return m3;
    }

    private static int[][] add(int[][] m1, int[][] m2, int rowA, int colA, int rowB, int colB, int size) {
        int[][] m3 = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                m3[i][j] = m1[rowA + i][colA + j] + m2[rowB + i][colB + j];
            }
        }
        return m3;
    }

    private static int[][] sub(int[][] m1, int[][] m2) {
        int[][] m3 = new int[m1.length][m2.length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2.length; j++) {
                m3[i][j] = m1[i][j] - m2[i][j];
            }
        }
        return m3;
    }

    private static int[][] sub(int[][] m1, int[][] m2, int rowA, int colA, int rowB, int colB, int size) {
        int[][] m3 = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                m3[i][j] = m1[rowA + i][colA + j] - m2[rowB + i][colB + j];
            }
        }
        return m3;
    }
    
}
