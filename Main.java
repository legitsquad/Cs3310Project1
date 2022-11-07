package Project1;

import java.util.Random;

import Project1.*;

public class Main {

    public static void main(String[] args) 
    {
        int[][] m1 = { 
           { 2, 0, -1, 6 }, 
           { 3, 7, 8, 0 }, 
           { -5, 1, 6 , -2 }, 
           { 8, 0, 1, 7} 
           };
           
            int[][] m2 = { 
           { 0,1,6,3 }, 
           { -2, 8 ,7, 1 }, 
           { 2,0,-1,0 }, 
           { 9, 1, 6, -2} 
           };

        int size = 1024;   
        int[][] A = matrixGenerator(size);
        int[][] B = matrixGenerator(size); 
  
        long startTime = System.currentTimeMillis();

        int[][] result = classical(m1, m2);

        long stopTime = System.currentTimeMillis();

        System.out.println("\n Finished in " + (stopTime-startTime) + "ms.\n");

      // int[][] mResult = Naive.nMultiply(A, B, 0, 0, 0, 0, 64);

      // int[][] sResult = Strassen.strassenMultiply(A, B, 0, 0, 0, 0, 128);

     
      printMatrix(result);

    
      
    }
  
    public static int[][] classical(int[][] m1, int[][] m2)
    {
      int n = m1.length;
      int[][] m3 = new int[n][n];
  
      for(int i = 0; i < n; i++)
        {
          for(int j = 0; j < n; j++)
            {
              for(int k = 0; k < n; k++)
                {
                  m3[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
  
      return m3;
    }


    public static void printMatrix(int[][] m1 )
    {
      int n = m1.length;
        for(int i =0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                System.out.print(" ");
                System.out.print(m1[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] matrixGenerator(int n)
    {
      
      int[][] a=new int[n][n];
      for(int i=0;i<n;i++)
      {
          for(int j=0;j<n;j++)
          {
            a[i][j] = (int) (Math.random()*10);
          }
        }
      return a;
    }

  }