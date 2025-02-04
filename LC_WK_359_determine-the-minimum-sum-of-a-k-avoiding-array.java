class Solution {
    public int minimumSum(int n, int k) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        int sum = 0, count = 0, index = 1;
        while( count != n ) {
            if( hashSet.contains(index) == false) {
                ///System.out.println("index: "+index);
                sum += index;
                count += 1;
                hashSet.add(k-index);
            }
            index++;
        }
        return sum;
    }
}
