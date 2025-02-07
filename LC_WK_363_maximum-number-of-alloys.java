class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int maxUnits = -1, index = 0, tbudget = 0;
        while(index < k) {
            List<Integer> comp = composition.get(index);
            List<Integer> stocks = new ArrayList<>(stock);
            int currUnits = 0;
            tbudget = budget;
            boolean tryUnits = true;
            while( tryUnits ) {
                //current run
                int currCost = 0;
                
                for(int index1 = 0; index1 < comp.size(); index1++) {
                    if(stocks.get(index1) >= comp.get(index1)) continue;
                    else currCost = currCost + cost.get(index1)*(comp.get(index1)-stocks.get(index1));
                }
               // System.out.println("index: "+index+ " currCost: "+currCost);
                if(currCost <= tbudget ) {
                    tbudget -= currCost;
                    currUnits += 1;
                    for(int index1 = 0; index1 < comp.size(); index1++) {
                        if(stocks.get(index1) == 0 ) continue;
                        else if(stocks.get(index1) >= comp.get(index1)) stocks.set(index1, stocks.get(index1)-comp.get(index1));
                        else stocks.set(index1, 0);
                    }
                }
                else tryUnits = false;
                if( tbudget <= 0 ) tryUnits = false;
            }
            index++;
            //System.out.println("currUnits: "+currUnits);
            maxUnits = Integer.max(maxUnits, currUnits);
        }
        return maxUnits;
    }
}
