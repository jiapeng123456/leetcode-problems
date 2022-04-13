/**
 * Leetcode - p0304_range_sum_query_2d_immutable
 */
package com.leetcode.p0304_range_sum_query_2d_immutable;

import java.util.*;

import com.ciaoshen.leetcode.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Parameterized.class)
public class Tester {

    /**
     * =========================== static for every test cases ==============================
     */

    // Solution instance to test
    private static Solution solution;
    // use this Object to print the log (call from slf4j facade)
    private static final Logger LOGGER = LoggerFactory.getLogger(TesterRunner.class);

    /**
     * Execute once before any of the test methods in this class.
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        /* uncomment to switch solutions */
//        solution = new Solution1();
        // solution = new Solution2();
    }

    /**
     * Execute once after all of the test methods are executed in this class.
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * Initialize test cases
     */
    @Parameters
    public static Collection<Object[]> testcases() {
        return Arrays.asList(new Object[][]{
                {new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}},
                        new int[]{2, 1, 4, 3},
                        new int[]{1, 1, 2, 2},
                        new int[]{1, 2, 2, 4},
                        8, 11, 12},
//                {{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}}, {2, 1, 4, 3}, {1, 1, 2, 2}, {1, 2, 2, 4}, 8, 11, 12},
                // {},     // test case 1 (init parameters below: {para1, para2, expected})
                // {},     // test case 2 (init parameters below: {para1, para2, expected})
                // {}      // test case 3 (init parameters below: {para1, para2, expected})
        });
    }

    /**=========================== for each test case ============================== */

    /**
     * Parameters for each test (initialized in testcases() method)
     * You can change the type of parameters
     */
    private int[][] matrix;                       // parameter 1
    private int[] para1;                       // parameter 2
    private int[] para2;                       // parameter 2
    private int[] para3;                       // parameter 2
    private int expected1;                    // parameter 3 (expected answer)
    private int expected2;                    // parameter 3 (expected answer)
    private int expected3;                    // parameter 3 (expected answer)

    /**
     * This constructor must be provided to run parameterized test.
     */
    public Tester(int[][] matrix, int[] para1, int[] para2, int[] para3,
                  int expected1, int expected2, int expected3) {
        // initialize test parameters
        this.matrix = matrix;
        this.para1 = para1;
        this.para2 = para2;
        this.para3 = para3;
        this.expected1 = expected1;
        this.expected2 = expected2;
        this.expected3 = expected3;
    }

    /**
     * Execute before each test method in this class is executed.
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Executed as a test case.
     */
    @Test
    public void test() {
//        solution = new NumMatrix(matrix);
//        solution = new NumMatrix2(matrix);
        solution = new NumMatrix3(matrix);

        int actual1 = solution.sumRegion(para1[0], para1[1], para1[2], para1[3]);
        int actual2 = solution.sumRegion(para2[0], para2[1], para2[2], para2[3]);
        int actual3 = solution.sumRegion(para3[0], para3[1], para3[2], para3[3]);

        assertThat(actual1, is(equalTo(expected1)));
        assertThat(actual2, is(equalTo(expected2)));
        assertThat(actual3, is(equalTo(expected3)));
        //
        // if (LOGGER.isDebugEnabled()) {
        //     LOGGER.debug("your-method() pass unit test!");
        // }
    }

    /**
     * Execute after each test method in this class is executed.
     */
    @After
    public void tearDown() throws Exception {
    }

}
