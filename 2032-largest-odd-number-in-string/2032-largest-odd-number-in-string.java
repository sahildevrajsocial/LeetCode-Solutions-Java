class Solution {
    public String largestOddNumber(String num) {
        int j = -1, n = num.length();
        for(int i = n - 1; i >= 0; i--) {
            if((num.charAt(i)) % 2 == 1) {
                j = i;
                break;
            }
        }
        if(j == -1) {
            return "";
        }
        int i = 0;
        while(i < n && num.charAt(i) == '0') {
            i++;
        }
        return num.substring(i, j+1);
    }
}