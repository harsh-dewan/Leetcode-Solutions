class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int numsLength = nums.length;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int index = 0; index < numsLength; index++ ) {
            hashSet.add(nums[index]);
        }
        int count = 0;
        int unique = hashSet.size();
        if(unique == 1 ) {
            for(int index = 0; index < numsLength; index++ ) count+=(index+1);
            return count;
        }
        int[] ans = new int[numsLength];
        ans[numsLength-1] = 1;
        HashSet<Integer> flySet = new HashSet<Integer>();
        flySet.add(nums[numsLength-1]);
        int[] save = new int[numsLength];
        save[numsLength-1] = 1;
        for(int index = numsLength-2; index >= 0; index-- ) {
            if(flySet.contains(nums[index]) == true ) {
                if(nums[index]!=nums[index+1]) ans[index] = ans[index+1];
                else ans[index] = 1+ans[index+1];
                save[index] = save[index+1];
            }
            else {
                flySet.add(nums[index]);
                save[index] = 1 +save[index+1];
                ans[index] = ans[index+1];
            }
        }
        for(int index = 0; index < numsLength; index++)  {
            System.out.print(ans[index]+" ");
        }
        System.out.println();
        for(int index = 0; index < numsLength; index++ ) {
            System.out.print(save[index]+" ");
        }
        for(int index = 0; index < numsLength; index++ ) {
            if( save[index] == unique) count+=ans[index];
        }
        return count;
    }
}
