class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) return "";

        char[] chars = palindrome.toCharArray();

        // Change the first non-'a' character in the first half to 'a'
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }

        // All characters in first half are 'a', change last char to 'b'
        chars[chars.length - 1] = 'b';
        return new String(chars);
    }
}