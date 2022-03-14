/**
 * Leetcode - p0076_minimum_window_substring
 */
package com.leetcode.p0076_minimum_window_substring;

/**
 * 自己实现：根据滑动窗口原理的实现
 * （速度比官方的快，因为使用了数组代替 Map）
 *
 */
class Solution2 implements Solution {

    public String minWindow(String s, String t) {

        int resultLen = Integer.MAX_VALUE;
        int reslutLeft = -1;
        int resultRight = -1;
        String result = "";

        // init
        int sLen = s.length();
        SubstrChecker sc = new SubstrChecker(t);
        // window left
        int left = 0;
        // windows right
        int right = 0;

        for (; right < sLen; right++) {
            sc.addChar(s.charAt(right));

            if (sc.isValid()) {

                sc.deleteChar(s.charAt(left));
                left++;
                while (sc.isValid()) {
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

        // t 中每个字母出现的次数
        private int[] alphaCounter = new int[58];
        // 窗口中字母出现的次数
        private int[] windowAlphaNum = new int[58];
        // 当前符合要求的字母个数
        private int hitCounter = 0;
        // t 字符串中总共的字母个数。
        private int totalCounter = 0;
        // t 的长度
        private int strLen;

        public SubstrChecker(String t) {
            strLen = t.length();

            // init all char with not exist value(mininum value)
            for (int i = 0; i < alphaCounter.length; i++) {
                alphaCounter[i] = Integer.MIN_VALUE;
            }
            System.arraycopy(alphaCounter, 0, windowAlphaNum, 0, alphaCounter.length);


            // set chars in t with 0
            char ch;
            for (int i = 0; i < strLen; i++) {
                ch = t.charAt(i);
                // 转换成字母对应的数组下标
                int alphabetsIdx = (int) ch - 65;
                if (alphaCounter[alphabetsIdx] == Integer.MIN_VALUE) {
                    alphaCounter[alphabetsIdx] = 1;
                    windowAlphaNum[alphabetsIdx] = 0;
                    totalCounter++;
                } else if (alphaCounter[alphabetsIdx] > 0) {
                    alphaCounter[alphabetsIdx]++;
                }
            }

        }

        public void addChar(char ch) {
            int alphabetsIdx = (int)ch - 65;

            // 如果不是 t 中的字母就返回
            if (windowAlphaNum[alphabetsIdx] == Integer.MIN_VALUE) {
                return;
            }

            windowAlphaNum[alphabetsIdx]++;
            // 如果 窗口中的该字母数=t中的该字母数，就把字母命中数加1.
            if (windowAlphaNum[alphabetsIdx] == alphaCounter[alphabetsIdx]) {
                hitCounter++;
            }



        }

        public void deleteChar(char ch) {
            int alphaIdx = (int)ch - 65;

            if (windowAlphaNum[alphaIdx] == Integer.MIN_VALUE) {
                return;
            }

            // 因为稍后要对该字母出现数减1，所以如果 窗口中的该字母数=t中的该字母数，
            // 说明该字母将不符合 t 中出现次数的条件。
            if (windowAlphaNum[alphaIdx] == alphaCounter[alphaIdx]) {
                hitCounter--;
            }
            windowAlphaNum[alphaIdx]--;

        }

        public boolean isValid() {
            if (hitCounter == totalCounter) {
                return true;
            } else {
                return false;
            }

        }
    }


}
