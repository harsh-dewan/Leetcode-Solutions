class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        int[]  prime = new int[n+1];
        Arrays.fill(prime, 1);
        prime[0] = 0;
        prime[1] = 0;
        for (int index = 2; index * index < n; index++) {
            if (prime[index] == 1) {
                for (int index1 = index * index; index1 <= n; index1 += index) {
                    prime[index1] = 0; 
                }
            }
        }
        List<List<Integer>> arrList = new ArrayList<List<Integer>>();
        for(int index = 2; index <= n/2; index++ ) {
            if( (prime[index] == 1) && 
                (prime[n-index] == 1) )
            {
              arrList.add(new ArrayList<Integer>(Arrays.asList(index, n-index)));   
            }
        }
        return arrList;
    }
}
