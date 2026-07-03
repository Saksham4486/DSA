class Solution {
   public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int maxCost = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            adj.get(u).add(new int[]{v, cost});
            maxCost = Math.max(maxCost, cost);
        }
        
        int low = 0, high = maxCost;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isValidPathPossible(mid, adj, online, k, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return ans;
    }
    
    private boolean isValidPathPossible(int minEdgeThreshold, List<List<int[]>> adj, boolean[] online, long maxAllowedCost, int n) {
        long[] minCostToNode = new long[n];
        Arrays.fill(minCostToNode, Long.MAX_VALUE);
        minCostToNode[0] = 0;
        
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{0, 0});
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long currentCost = curr[1];
            
            if (currentCost > minCostToNode[u]) continue;
            
            if (u == n - 1) return true;
            
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int edgeCost = neighbor[1];
                
                if (edgeCost >= minEdgeThreshold && (v == n - 1 || online[v])) {
                    long nextCost = currentCost + edgeCost;
                    
                    if (nextCost <= maxAllowedCost && nextCost < minCostToNode[v]) {
                        minCostToNode[v] = nextCost;
                        pq.offer(new long[]{v, nextCost});
                    }
                }
            }
        }
        
        return minCostToNode[n - 1] <= maxAllowedCost;
    }
}