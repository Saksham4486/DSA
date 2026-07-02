class Solution {
    private final int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m=grid.size();
        int n=grid.get(0).size();
        int dis[][]=new int[m][n];
        for(int []row:dis)Arrays.fill(row,Integer.MAX_VALUE);
        dis[0][0]=grid.get(0).get(0);
        Deque<int[]>dq=new ArrayDeque<>();
        dq.offerFirst(new int[]{0,0});
        while(!dq.isEmpty())
        {
            int []curr=dq.pollFirst();
            for(int[] d:dir)
            {
                int nx=curr[0]+d[0];
                int ny=curr[1]+d[1];
            
            if(nx>=0&&nx<m&&ny>=0&&ny<n)
            {
                int cost=grid.get(nx).get(ny);
                int dist=cost+dis[curr[0]][curr[1]];
                if(dist<dis[nx][ny])
                {
                    dis[nx][ny]=dist;
                    if(cost==0)
                    dq.offerFirst(new int[]{nx,ny});
                    else
                    dq.offerLast(new int[]{nx,ny});
                }
            }
            }
        }
        return dis[m-1][n-1]<health;
    }
}