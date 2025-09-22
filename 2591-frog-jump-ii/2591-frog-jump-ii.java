class Solution {
    public int maxJump(int[] stones) {
        int maxJump = stones[1] - stones[0];

        for (int i = 2; i < stones.length; i++) {
            int jump = stones[i] - stones[i - 2];
            maxJump = Math.max(maxJump, jump);
        }

        return maxJump;
    }
}