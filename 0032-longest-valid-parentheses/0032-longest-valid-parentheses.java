class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = 0, right = 0;

            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    maxLen = Math.max(maxLen, right + left);
                }
                else if (right > left) {
                    break;
                }
            }
        }

        return maxLen;
    }
}