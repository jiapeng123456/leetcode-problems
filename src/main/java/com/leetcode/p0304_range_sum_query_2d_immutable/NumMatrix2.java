/**
 * Leetcode - p0304_range_sum_query_2d_immutable
 */
package com.leetcode.p0304_range_sum_query_2d_immutable;

/**
 * 自己实现。
 * 只把行变成了累加和的形式，然后根据列的区间，对 N 行进行 leetcode 303那样的计算。
 */
class NumMatrix2 implements Solution {

    private int[][] preSumMatrix;

    public NumMatrix2(int[][] matrix) {
        this.preSumMatrix = new int[matrix.length][matrix[0].length + 1];

        for (int rowIdx = 0; rowIdx < preSumMatrix.length; rowIdx++) {
            for (int colIdx = 1; colIdx < preSumMatrix[rowIdx].length; colIdx++) {
                preSumMatrix[rowIdx][colIdx] =
                        preSumMatrix[rowIdx][colIdx-1] + matrix[rowIdx][colIdx - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int rowIdx = row1; rowIdx <= row2; rowIdx++) {
            sum += preSumMatrix[rowIdx][col2 + 1] - preSumMatrix[rowIdx][col1];
        }

        return sum;
    }


}
