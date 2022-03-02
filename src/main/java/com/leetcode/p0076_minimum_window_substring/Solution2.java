/**
 * Leetcode - p0076_minimum_window_substring
 */
package com.leetcode.p0076_minimum_window_substring;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * brute force
 */
class Solution2 implements Solution {

    public String minWindow(String s, String t) {

        int resultLen = Integer.MAX_VALUE;
        int reslutStartPos = -1;
        int resultEndPos = -1;
        String result = "";

        // check data
        int sLen = s.length();
        int tLen = t.length();

        // init
        SubstrChecker sc = new SubstrChecker(t);

        // calculation
        int pos = 0;
        int startPos = -1;
        int endPos = -1;

        while (pos < sLen) {
            int sIdx = pos;

            while (sIdx < sLen) {
                // set substr start idx
                if (sc.isOneOfSubstr(s.charAt(sIdx)) && startPos == -1) {
                    startPos = sIdx;
                }

                if (sc.isAllSubstr(s.charAt(sIdx))) {
                    endPos = sIdx;
                    int substrFoundLen = endPos - startPos;
                    if (substrFoundLen < resultLen) {
                        resultLen = substrFoundLen;
                        reslutStartPos = startPos;
                        resultEndPos = endPos;
                        break;
                    }
                }

                sIdx++;
            }

            pos++;
            // reset pos
            startPos = -1;
            endPos = -1;
            sc.reset();
        }

        if (resultLen != Integer.MAX_VALUE) {
            return s.substring(reslutStartPos, resultEndPos + 1);
        } else {
            return "";
        }


    }


    class SubstrChecker {
        private int[] alphabetsCounter = new int[26];
        private int[] alphabetsCounterBk = new int[26];
        private int hitCounter;
        private int subStrLen;
        private Set<Character> alphabetsSet = new HashSet<Character>();

        public SubstrChecker(String t) {
            subStrLen = t.length();
            hitCounter = subStrLen;


            int alphabetsIdx;
            char ch;
            for (int i = 0; i < subStrLen; i++) {
                ch = t.charAt(i);
                alphabetsIdx = (int)Character.toLowerCase(ch) - 97;
                alphabetsCounter[alphabetsIdx] = ++alphabetsCounter[alphabetsIdx];
                alphabetsSet.add(ch);
            }

            System.arraycopy(alphabetsCounter, 0, alphabetsCounterBk, 0, alphabetsCounter.length);
        }

        public boolean isAllSubstr(char ch) {
            int alphabetsIdx = (int) Character.toLowerCase(ch) - 97;
            if (alphabetsCounter[alphabetsIdx] > 0) {
                alphabetsCounter[alphabetsIdx] = --alphabetsCounter[alphabetsIdx];
                hitCounter--;
            }

            if (hitCounter == 0) {
                return true;
            } else {
                return false;
            }

        }

        public boolean isOneOfSubstr(char ch) {
            if (alphabetsSet.contains(ch)) {
                return true;
            }

            return false;

        }

        public void reset() {
            hitCounter = subStrLen;
            System.arraycopy(alphabetsCounterBk, 0, alphabetsCounter, 0, alphabetsCounterBk.length);

        }


    }


}
