class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;

        for (int point : cardPoints) {
            total += point;
        }

        if (k == n) return total;

        int windowSize = n - k;
        int currSum = 0;

        // Initial window
        for (int i = 0; i < windowSize; i++) {
            currSum += cardPoints[i];
        }

        int minSubarraySum = currSum;

        for (int i = windowSize; i < n; i++) {
            currSum += cardPoints[i] - cardPoints[i - windowSize];
            minSubarraySum = Math.min(minSubarraySum, currSum);
        }

        return total - minSubarraySum;
    }
}