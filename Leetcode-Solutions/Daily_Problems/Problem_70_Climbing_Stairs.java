class Solution {


	/*
	we will check for every possible way and keeping on 
	saving the total unique ways from a certain level to last step.
	*/
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    
    public int computeTotalWaysToClimb(int currLevel, int n ) {
        if( currLevel > n ) return 0;
        if( currLevel == n ) return 1;
        if( map.getOrDefault(currLevel, -1) != -1 )  return map.get(currLevel);
        int ans = computeTotalWaysToClimb(currLevel+1, n) +
                  computeTotalWaysToClimb(currLevel+2, n);
        map.put(currLevel, ans);
        return ans;
    }

    public int climbStairs(int n) {
		
		//we will start from level 0 till last step.
		
        return computeTotalWaysToClimb(0, n);
    }
}