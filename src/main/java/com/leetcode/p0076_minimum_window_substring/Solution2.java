/**
 * Leetcode - p0076_minimum_window_substring
 */
package com.leetcode.p0076_minimum_window_substring;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 * 自己写的滑动窗口实现
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution2 implements Solution {

    public String minWindow(String s, String t) {

        int resultLen = Integer.MAX_VALUE;
        int reslutLeft = -1;
        int resultRight = -1;
        String result = "";

        // check data


        // init
        int sLen = s.length();
        SubstrChecker sc = new SubstrChecker(t);
        // window left
        int left = 0;
        // windows right
        int right = 0;

        // satisfied str left
        int satisfiedLeft;
        int satisfiedRight;

        for (; right < sLen; right++) {
            sc.addChar(s.charAt(right));

            if (sc.isSatisfied()) {

                sc.deleteChar(s.charAt(left));
                left++;
                while (sc.isSatisfied()) {
                    sc.deleteChar(s.charAt(left));
                    left++;
                }

                // get minimum substring, and save it postion
                int tmpLen = right - (left - 1);
                if (tmpLen < resultLen) {
                    reslutLeft = left - 1;
                    resultRight = right;
                    resultLen = tmpLen;
                }
            }
        }




        if (resultLen != Integer.MAX_VALUE) {
            return s.substring(reslutLeft, resultRight + 1);
        } else {
            return "";
        }


    }


    class SubstrChecker {
        private int[] alphaCounter = new int[58];
        private int[] currAlphaNum = new int[58];
        private int hitCounter = 0;
        private int totalCounter = 0;
        private int subStrLen;
        private Set<Integer> alphabetsIdxSet = new HashSet<>();


        public SubstrChecker(String t) {
            subStrLen = t.length();

            // init all char with not exist value(mininum value)
            for (int i = 0; i < alphaCounter.length; i++) {
                alphaCounter[i] = Integer.MIN_VALUE;
            }
            System.arraycopy(alphaCounter, 0, currAlphaNum, 0, alphaCounter.length);


            // set chars in t with 0
            char ch;
            for (int i = 0; i < subStrLen; i++) {
                ch = t.charAt(i);
                int alphabetsIdx = (int) ch - 65;
                if (alphaCounter[alphabetsIdx] == Integer.MIN_VALUE) {
                    alphaCounter[alphabetsIdx] = 1;
                    currAlphaNum[alphabetsIdx] = 0;
                    totalCounter++;
                    alphabetsIdxSet.add(alphabetsIdx);
                } else if (alphaCounter[alphabetsIdx] > 0) {
                    alphaCounter[alphabetsIdx] = ++alphaCounter[alphabetsIdx];
                }
            }

        }

        public void addChar(char ch) {
            int alphabetsIdx = (int)ch - 65;

            if (currAlphaNum[alphabetsIdx] == Integer.MIN_VALUE) {
                return;
            }

            currAlphaNum[alphabetsIdx] = ++currAlphaNum[alphabetsIdx];
            if (currAlphaNum[alphabetsIdx] == alphaCounter[alphabetsIdx]) {
                hitCounter++;
            }



        }

        public void deleteChar(char ch) {
            int alphaIdx = (int)ch - 65;

            if (currAlphaNum[alphaIdx] == Integer.MIN_VALUE) {
                return;
            }

            currAlphaNum[alphaIdx] = --currAlphaNum[alphaIdx];
            // find char in t string, and increment char count
            if ((currAlphaNum[alphaIdx] + 1) == alphaCounter[alphaIdx]) {
                hitCounter--;
            }
        }

        public boolean isSatisfied() {
            if (hitCounter == totalCounter) {
                return true;
            } else {
                return false;
            }

        }
    }


}
