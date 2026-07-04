class Solution {
    private int []root;
    private int find(int i)
    {
        if(root[i]==i)
        return i;
        return root[i]=find(root[i]);
    }
    public int minScore(int n, int[][] roads) {
        root=new int[n+1];
        for(int i=0;i<=n;i++)
            root[i]=i;
        for(int[] r:roads)
            root[find(r[0])]=find(r[1]);
        int res=10001;
        for(int[]r:roads)
        {
            if(find(r[0])==find(1))
            res=Math.min(res,r[2]);
        }
        return res;
    }
}