class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0,minl=nums.length+1,sum;
        
            sum=0;
            for(j=0;j<nums.length;j++)
            {
            sum=sum+nums[j];
            while(sum>=target)
            {
           int x=j-i+1;
            minl=Math.min(minl,x);
            sum=sum-nums[i];
            i++;
            }
            
        }
       return minl==nums.length+1?0:minl; 
    }
}