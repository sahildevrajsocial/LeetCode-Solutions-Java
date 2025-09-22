import java.util.Vector;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       Arrays.sort(nums1);
       Arrays.sort(nums2);
       
       int i = 0, j = 0;

        Vector<Integer> ans = new Vector<>();
        while(i<nums1.length && j< nums2.length) {
            if(nums1[i] < nums2[j]){
                i++;
            }
            else if(nums2[j] < nums1[i]) {
                j++;
            }
            else {
                if (ans.isEmpty() || ans.lastElement() != nums1[i]) {
                    ans.add(nums1[i]);
                }
                i++;
                j++;
            }
        }
        int[] result = new int[ans.size()];
        for (int k = 0; k < ans.size(); k++) {
            result[k] = ans.get(k);
        }

        return result;
    }
}