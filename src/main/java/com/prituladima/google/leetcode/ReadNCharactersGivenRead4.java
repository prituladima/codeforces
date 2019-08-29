package com.prituladima.google.leetcode;

public class ReadNCharactersGivenRead4 {
    class Reader4 {
        int read4(char[] buf) {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * The read4 API is defined in the parent class Reader4.
     * int read4(char[] buf);
     */
    class Solution extends Reader4 {

        int from = 4;
        int to = 4;
        char[] last;

        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return The number of actual characters read
         */
        public int read(char[] buf, int n) {
            int ans = 0;
            int i = 0;
            while (i < n && to > 0) {
                if (from == to) {
                    from = 0;
                    last = new char[4];
                    to = read4(last);
                } else {
                    buf[i++] = last[from++];
                    ans++;
                }
            }
            return ans;
        }
    }


}
