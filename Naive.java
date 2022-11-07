package Project1;

public class Naive 
{
    public static int[][] nMultiply(int[][] m1, int[][] m2, int rowA, int colA, int rowB, int colB, int n)
    {
        
        int[][] m3 = new int[n][n];

        if (n == 1) 
            m3[0][0] = m1[rowA][colA] * m2[rowB][colB];
        
        else 
        {
            int N = n/2;

            add(m3, nMultiply(m1, m2, rowA, colA, rowB, colB, N),//A11*B11
            nMultiply(m1, m2, rowA, colA + N, rowB + N, colB, N), //A12*B21
                    0, 0);//C11

            add(m3, nMultiply(m1, m2, rowA, colA, rowB, colB + N, N),//A11*B12
            nMultiply(m1, m2, rowA, colA + N, rowB + N, colB + N, N),//A12*B22
                    0, N);

            add(m3, nMultiply(m1, m2, rowA + N, colA, rowB, colB, N),//A21*B11
            nMultiply(m1, m2, rowA + N, colA + N, rowB + N, colB, N),//A22*B21
                    N, 0);

            add(m3, nMultiply(m1, m2, rowA + N, colA, rowB, colB + N, N),//A21*B12
            nMultiply(m1, m2, rowA + N, colA + N, rowB + N, colB + N, N), //A22*B22
                    N, N);
    
        }

        return m3;
    }


    public static void add(int[][] m3, int[][] m1, int[][] m2, int rowC, int colC) {
        int n = m1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m3[i + rowC][j + colC] = m1[i][j] + m2[i][j];
            }
        }

    }
    
}
