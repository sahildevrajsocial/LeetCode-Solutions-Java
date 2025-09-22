class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> sl = new ArrayList<>();
        int j = 0;

        for (int i = 1; i <= n && j < target.length; i++) {
            if (i == target[j]) {
                sl.add("Push");
                j++;
            } else {
                sl.add("Push");
                sl.add("Pop");
            }
        }

        return sl;
    }
}