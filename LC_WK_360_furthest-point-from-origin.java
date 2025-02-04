class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int movesLength = moves.length();
        int lcount = 0, rcount=0, free=0;
        for(int index = 0; index < movesLength; index++ ) {
            if(moves.charAt(index) == 'L') lcount++;
            else if(moves.charAt(index) == 'R') rcount++;
            else free++;
        }
        if( lcount == rcount) return free+lcount-rcount;
        if(lcount < rcount ) return free+(rcount-lcount);
        return free + (lcount-rcount);
    }
}
