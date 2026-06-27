class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long,Integer> fq=new HashMap<>();
        for(int num:nums)fq.put((long)num,(fq.getOrDefault((long)num,0)+1));
        int ans=0;
        if(fq.containsKey(1L)){
        if(fq.get(1L)%2==0)
        ans=fq.get(1L)-1;
        else
        {ans=fq.get(1L);
        }}
        fq.remove(1L);
        for(Map.Entry<Long,Integer>num:fq.entrySet())
        {
            int length=0;
            long i=num.getKey();
            for(;fq.containsKey(i)&&fq.get(i)>1;i*=i)
            length+=2;
            ans=Math.max(ans,length+(fq.containsKey(i)?1:-1));
        }
        return ans;

    }
}