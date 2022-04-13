/**
 * Leetcode - p0304_range_sum_query_2d_immutable
 */
package com.leetcode.p0304_range_sum_query_2d_immutable;

/** 
 * 书上实现。
 *
 *
 */
class NumMatrix implements Solution {

    private int[][] preSumMatrix;

    public NumMatrix(int[][] matrix) {
        this.preSumMatrix = new int[matrix.length + 1][matrix[0].length + 1];

        for (int rowIdx = 1; rowIdx < preSumMatrix.length; rowIdx++) {
            for (int colIdx = 1; colIdx < preSumMatrix[rowIdx].length; colIdx++) {
                preSumMatrix[rowIdx][colIdx] =
                        matrix[rowIdx - 1][colIdx - 1]
                                - preSumMatrix[rowIdx - 1][colIdx - 1]
                                + preSumMatrix[rowIdx][colIdx - 1]
                                + preSumMatrix[rowIdx - 1][colIdx];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return preSumMatrix[row2 + 1][col2 + 1]
                - preSumMatrix[row2 + 1][col1]
                - preSumMatrix[row1][col2 + 1]
                + preSumMatrix[row1][col1];
    }

}
