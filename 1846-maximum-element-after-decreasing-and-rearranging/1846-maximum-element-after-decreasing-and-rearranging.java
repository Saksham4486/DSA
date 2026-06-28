class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0]=1;
        int prev=0;
        for(int i=1;i<arr.length;i++)
        {   prev=arr[i-1];
            if(arr[i]-prev!=1)
                arr[i]=Math.min(prev+1,arr[i]);
            else
            continue;
        }
        return arr[arr.length-1];
    }
}