package com.company.part1.lab7;
import com.company.part1.lab6.ConsecutiveMatrixMultiplication;
import com.company.part1.lab6.MatrixGenerator;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
public class Main {
    public static ForkJoinPool forkJoinPool = new ForkJoinPool(4);
    public static void main(String[] args) {
        int size = 10;
        double[][]
                matrix1 = new double[size][size],
                matrix2 = new double[size][size];
        double[][] res = new double[matrix1.length][matrix2[0].length];
        matrix1 = MatrixGenerator.generateMatrix(matrix1.length,matrix1.length);
        matrix2 = MatrixGenerator.generateMatrix(matrix2.length,matrix2.length);
        System.out.println(Arrays.deepToString(matrix1));
        System.out.println(Arrays.deepToString(matrix2));
        var action = new CustomRecursiveAction(matrix1,matrix2,res, 0, size-1);
        forkJoinPool.execute(action);
        action.compute();
        System.out.println(Arrays.deepToString(res));
        System.out.println(Arrays.deepToString(ConsecutiveMatrixMultiplication.multiply(matrix1, matrix2)));
    }
}
