package 牛客算法课.基础班提升.课3_最长回文子串和滑动窗口.Q01_最长回文子串问题.NC17_最长回文串长度;


public class Solution2 {
    // 中心扩散法：求最长回文子串的长度
    public int getLongestPalindrome(String A, int n) {
        if (n < 2) {
            return 1;
        }
        int maxLen = 1;
        char[] cs = A.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            int len1 = getPalindromeCenterLen(cs, n, i, i);// 奇数中心的扩散长度
            int len2 = getPalindromeCenterLen(cs, n, i, i + 1);// 偶数中心的扩散长度
            len1 = Math.max(len1, len2);
            if (len1 > maxLen) {
                maxLen = len1;
            }
        }
        return maxLen;
    }


    private int getPalindromeCenterLen(char[] cs, int len, int left, int right) {
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (cs[i] == cs[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 循环跳出：cs[i]!=cs[j]
        // 此时的回文中心长度：j-i+1-2=j-i-1
        return j - i - 1;
    }
}
