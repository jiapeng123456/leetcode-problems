/**
 * Leetcode - p0034_find_first_and_last_position_of_element_in_sorted_array
 */
package com.leetcode.p0034_find_first_and_last_position_of_element_in_sorted_array;

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

    /**=========================== static for every test cases ============================== */

    // Solution instance to test
    private static Solution solution;
    // use this Object to print the log (call from slf4j facade)
    private static final Logger LOGGER = LoggerFactory.getLogger(TesterRunner.class);

    /** Execu`te once before any of the test methods in this class. */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        /* uncomment to switch solutions */
//        solution = new Solution1();
//        solution = new Solution2();
//        solution = new Solution3();
//        solution = new Solution4();
        solution = new Solution5();
    }

    /** Execute once after all of the test methods are executed in this class. */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    /** Initialize test cases */
    @Parameters
    public static Collection<Object[]> testcases() {
        return Arrays.asList(new Object[][]{

                // leetcode testcases
                {new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}},
                {new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1}},
                {new int[]{}, 0, new int[]{-1, -1}},
                {new int[]{2, 2}, 2, new int[]{0, 1}},

                // custom testcases
                // only one target element
                {new int[]{1, 2, 2, 2, 3}, 3, new int[]{4, 4}},
                // odd number
                {new int[]{1, 2, 2, 2, 3}, 3, new int[]{4, 4}},
                // even number
                {new int[]{1, 2, 2, 2, 2, 3}, 2, new int[]{1, 4}},


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
    private int[] para1;                       // parameter 1
    private int para2;                       // parameter 2
    private int[] expected;                    // parameter 3 (expected answer)

    /** This constructor must be provided to run parameterized test. */
    public Tester(int[] para1, int para2, int[] expected) {
        // initialize test parameters
        this.para1 = para1;
        this.para2 = para2;
        this.expected = expected;
    }

    /** Execute before each test method in this class is executed. */
    @Before
    public void setUp() throws Exception {}

    /** Executed as a test case. */
    @Test
    public void test() {

        int[] actual = solution.searchRange(para1, para2);
        assertThat(actual, is(equalTo(expected)));
        //
        // if (LOGGER.isDebugEnabled()) {
        //     LOGGER.debug("your-method() pass unit test!");
        // }
    }

    /** Execute after each test method in this class is executed. */
    @After
    public void tearDown() throws Exception {}

}
