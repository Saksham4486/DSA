class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int total=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
                nums[i]=1;
            else
                nums[i]=-1;
        }
        for(int i=1;i<nums.length;i++)
        {
            nums[i]=nums[i]+nums[i-1];
        }
        for(int i:nums)
            if(i>0)total++;
        for(int i=1;i<nums.length;i++)
            for(int j=i;j<nums.length;j++)
                if(nums[j]-nums[i-1]>0)total++;
        return total;
    }
}