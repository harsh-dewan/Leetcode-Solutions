class Solution {
    public int minimumPossibleSum(int n, int target) {
        long sum = 0, MOD=1000000007;
        HashSet<Long> hashSet = new HashSet<Long>();
        long count = 0, index = 1;
        while(count >= 0 && count < n ) {
            if(hashSet.contains(index)) {
                index++;
            }
            else {
                count = (count+1)%MOD;
                sum = (sum%MOD+index%MOD)%MOD;
                hashSet.add((long)(target-(int)index));
                index++;
            }
        }
        return (int)sum;
    }
}
