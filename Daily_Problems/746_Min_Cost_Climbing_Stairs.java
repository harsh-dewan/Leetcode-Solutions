class Solution {


    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

    public int computeTotalAmount(int currLevel, int[] cost, int targetLevel) {
        
		/*
		At every step we will check if this is the targetLevel
			if this is last step, we return 0
			else
				we calculate minimum cost it will take us to reach last step from current step.
		*/
        if( currLevel == targetLevel ) return 0;
        if( map.getOrDefault(currLevel, -1) != -1 ) return map.get(currLevel);
		
		/*
		For every step we have to check if we can got to 1 step above or 2 steps
		if we can go to both the steps, we will take option which will be with minimum cost among them
		otherwise we will include the cost wherever possible to go.
		*/
        if( currLevel + 1 <= targetLevel && currLevel +2 <= targetLevel ) {
            map.put(currLevel,Integer.min(
            cost[currLevel] + computeTotalAmount(currLevel+1, cost, targetLevel),
            cost[currLevel] + computeTotalAmount(currLevel+2, cost, targetLevel)));
            return map.get(currLevel);
        }
        else if( currLevel + 1 <= targetLevel  ) {
            map.put(currLevel, 
                    cost[currLevel] + computeTotalAmount(currLevel+1, cost, targetLevel));
        }
        else {
            map.put(currLevel,
                    cost[currLevel] + computeTotalAmount(currLevel+2, cost, targetLevel));
        }
        return map.get(currLevel);
    }

    public int minCostClimbingStairs(int[] cost) {
        
		/*
		  we will calculate the cost from 0th step and 1st step and return minimum of these values.
		*/
        int a = computeTotalAmount(0, cost, cost.length);
        int b = computeTotalAmount(1, cost, cost.length);
        return Integer.min(a,b);
    }
}