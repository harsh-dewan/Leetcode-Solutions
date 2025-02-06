class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int numsLength = nums.size();
        HashSet<Integer> hashSet  = new HashSet<Integer>();
        for(int index = 0; index < numsLength; index++) {
            List<Integer> list = nums.get(index);
            for(int index1 = list.get(0); index1 <= list.get(1); index1++ ) {
                hashSet.add(index1);
            }
        }
        return hashSet.size();
    }
}
