/**
 * Leetcode - p0141_linked_list_cycle
 */
package com.leetcode.p0141_linked_list_cycle;

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

    /** Execute once before any of the test methods in this class. */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        /* uncomment to switch solutions */
//        solution = new Solution1();
//        solution = new Solution2();
        solution = new Solution3();
//        solution = new Solution4();
    }

    /** Execute once after all of the test methods are executed in this class. */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    /** Initialize test cases */
    @Parameters
    public static Collection<Object[]> testcases() {
//        ListNode head0 = new ListNode(1);
//        head0.next = new ListNode(2);
//        head0.next.next = new ListNode(3);
//        head0.next.next.next = new ListNode(4);
//        head0.next.next.next.next = new ListNode(5);
//        head0.next.next.next.next.next = head0.next;
////        head0.next.next.next.next.next = new ListNode(6);
////        head0.next.next.next.next.next.next = head0.next;
////        head0.next.next.next.next.next.next = new ListNode(7);
////        head0.next.next.next.next.next.next.next = head0.next;

        // 1->234->2
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next;

        // 1->2->1
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next = head2;

        // 1
        ListNode head3 = new ListNode(1);

        // 1->2
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);

        return Arrays.asList(new Object[][]{
                {head1, true},
                {head2, true},
                {head3, false},
                {head4, false},
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
     private ListNode para1;                       // parameter 1
     private boolean expected;                    // parameter 3 (expected answer)

    /** This constructor must be provided to run parameterized test. */
    public Tester(ListNode para1, boolean expected) {
           // initialize test parameters
         this.para1 = para1;
         this.expected = expected;
    }

    /** Execute before each test method in this class is executed. */
    @Before
    public void setUp() throws Exception {}

    /** Executed as a test case. */
    @Test
    public void test() {
        boolean actual = solution.hasCycle(para1);
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
