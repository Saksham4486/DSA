class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int len = s.length();
        long MOD = 1000000007L;
        
        long[] pow10 = new long[len + 1];
        pow10[0] = 1;
        for (int i = 1; i <= len; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        
        long[] prefixSum = new long[len + 1];
        long[] prefixX = new long[len + 1];
        int[] nonZeroCount = new int[len + 1];
        
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            long digit = ch - '0';
            
            prefixSum[i + 1] = prefixSum[i];
            prefixX[i + 1] = prefixX[i];
            nonZeroCount[i + 1] = nonZeroCount[i];
            
            if (digit != 0) {
                prefixSum[i + 1] += digit;
                prefixX[i + 1] = (prefixX[i] * 10 + digit) % MOD;
                nonZeroCount[i + 1]++;
            }
        }
        
        int qLen = queries.length;
        int[] ans = new int[qLen];
        
        for (int i = 0; i < qLen; i++) {
            int L = queries[i][0];
            int R = queries[i][1];
            
            long currentSum = prefixSum[R + 1] - prefixSum[L];
            int elementsInBetween = nonZeroCount[R + 1] - nonZeroCount[L];
            
            long totalSubtractedContribution = multiplyMod(prefixX[L], pow10[elementsInBetween], MOD);
            long currentX = (prefixX[R + 1] - totalSubtractedContribution + MOD) % MOD;
            
            ans[i] = (int) multiplyMod(currentSum, currentX, MOD);
        }
        
        return ans;
    }

    private long multiplyMod(long a, long b, long mod) {
        return (a % mod * (b % mod)) % mod;
    }
}