class Solution {
    public int minimumIndex(List<Integer> nums) {
        int numsLength = nums.size();
        int[] left = new int[numsLength];
        int[] right = new int[numsLength];
        HashMap<Integer,Integer> count =  new HashMap<Integer,Integer>();
        right[numsLength-1]=nums.get(numsLength-1);
        int minIndex = -1, total=1;
        count.put(nums.get(numsLength-1),1);
        for(int index = numsLength-2; index >= 0; index-- ) {
            total+=1;
            int ele = nums.get(index);
            count.put(ele, 1+count.getOrDefault(ele, 0));
            if( count.get(ele)*2 > total ) right[index] = nums.get(index);
            else if (right[index+1]!=0 && count.get(right[index+1])*2 > total) right[index] = right[index+1];
            else right[index] = 0;
        }
        left[0] = nums.get(0);
        count.clear();
        total = 1;
        count.put(nums.get(0),1);
        for(int index = 1; index < numsLength; index++ ) {
            total+=1;
            int ele = nums.get(index);
            count.put(ele, 1+count.getOrDefault(ele, 0));
            if( count.get(ele)*2 > total ) left[index] = nums.get(index);
            else if (left[index-1]!=0 && count.get(left[index-1])*2 > total) left[index] = left[index-1];
            else left[index] = 0;
        }
        for(int index = 0; index < numsLength-1; index++ ) {
            if(left[index] == right[index+1]){
                minIndex = index;
                break;
            }
        }
        return minIndex;
    }
}
