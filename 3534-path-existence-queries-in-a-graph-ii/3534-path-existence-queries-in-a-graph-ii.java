class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] sortedIndices = new Integer[n];
        for (int i = 0; i < n; i++) {
            sortedIndices[i] = i;
        }
        Arrays.sort(sortedIndices, (a, b) -> Integer.compare(nums[a], nums[b]));

        int[] posInSorted = new int[n];
        for (int i = 0; i < n; i++) {
            posInSorted[sortedIndices[i]] = i;
        }

        int LOG = 18;
        int[][] st = new int[n][LOG];

        int r = 0;
        for (int i = 0; i < n; i++) {
            while (r + 1 < n && nums[sortedIndices[r + 1]] - nums[sortedIndices[i]] <= maxDiff) {
                r++;
            }
            st[i][0] = Math.max(r, i);
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                st[i][j] = st[st[i][j - 1]][j - 1];
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            if (u == v) {
                ans[i] = 0;
                continue;
            }

            int a = posInSorted[u];
            int b = posInSorted[v];

            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            int curr = a;
            int steps = 0;

            for (int j = LOG - 1; j >= 0; j--) {
                if (st[curr][j] < b) {
                    curr = st[curr][j];
                    steps += (1 << j);
                }
            }

            if (st[curr][0] >= b) {
                ans[i] = steps + 1;
            } else {
                ans[i] = -1;
            }
        }

        return ans;
    }
}