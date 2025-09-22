import java.math.BigInteger;

class Solution {
    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            sb.append(digits[i]);
        }

        BigInteger num = new BigInteger(sb.toString());
        num = num.add(BigInteger.ONE);
        String numberStr = num.toString();

        int[] newArr = new int[numberStr.length()];
        for (int i = 0; i < numberStr.length(); i++) {
            newArr[i] = Character.digit(numberStr.charAt(i), 10);
        }
        return newArr;
    }
}