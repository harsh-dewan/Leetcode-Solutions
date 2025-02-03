class Solution {
    public int maxSum(int[] nums) {
        int numsLength = nums.length;
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<Integer,ArrayList<Integer>>();
        int maxAns = -1;
        for( int index = 0; index < numsLength; index++ ) {
            //1. find the max digit
            //2. add it in the hashmap
            int maxdigit = -1;
            int n1 = nums[index];
            while(n1 > 0 ) {
                maxdigit = Integer.max(maxdigit, n1%10);
                n1 = n1/10;
            }
            ArrayList<Integer> arrList = hashMap.getOrDefault(maxdigit, new ArrayList<Integer>());
            arrList.add(nums[index]);
            hashMap.put(maxdigit, arrList);
        }
        for(int index = 1; index <= 9; index++ ) {
            ArrayList<Integer> a1 = hashMap.getOrDefault(index, new ArrayList<Integer>());
            if( a1.size() == 0) continue;
            Collections.sort(a1);
            if( a1.size() >= 2 ) maxAns = Integer.max(maxAns, a1.get(a1.size()-1)+a1.get(a1.size()-2));
        }
        return maxAns;
    }
}
