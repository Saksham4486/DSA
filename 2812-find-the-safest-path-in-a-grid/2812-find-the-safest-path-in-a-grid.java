class Solution {
    private static int[][]directions={{0,1},{0,-1},{1,0},{-1,0}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n=grid.size();
        if(grid.get(0).get(0)==1||grid.get(n-1).get(n-1)==1)
        return 0;
        int [][]thiefdist=new int[n][n];
        for(int []row:thiefdist)Arrays.fill(row,Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    thiefdist[r][c] = 0;
                    queue.offer(new int[]{r, c});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];   
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && thiefdist[nr][nc] == Integer.MAX_VALUE) {
                    thiefdist[nr][nc] = thiefdist[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        int low=0,high=2*n,ans=0;
        while(low<=high)
        {int mid=(low+high)/2;
            if(isvalid(thiefdist,n,mid))
            {
                ans=mid;
                low=mid+1;
            }
            else
            high=mid-1;
        }
        return ans;
    }
    public static boolean isvalid(int[][] thiefDist, int n, int minSafeness) {
        if (thiefDist[0][0] < minSafeness) return false;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            if (r == n - 1 && c == n - 1) return true;
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    if (thiefDist[nr][nc] >= minSafeness) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return false;
    }
}