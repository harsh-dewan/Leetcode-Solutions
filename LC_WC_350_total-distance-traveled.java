class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int distance = 0;
        while( mainTank > 0 ) {
            if( mainTank < 5 ) {
                distance += mainTank*10;
                break;
            }
            else {
                distance += 50;
                mainTank -= 5;
                if( additionalTank >= 1) {
                    mainTank += 1;
                    additionalTank -= 1;
                }
            }
        }
        return distance;
        
    }
}
