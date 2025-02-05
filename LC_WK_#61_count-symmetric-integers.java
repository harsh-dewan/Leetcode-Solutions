class Solution {

    public boolean isSymmetric(int num1) {
        int dig = 0;
        int save = num1;
        while( save > 0 ) {
            dig += 1;
            save = save/10;
        }
        if( dig%2 != 0 ) return false;
        int half = dig/2;
        int sum = 0, totalSum = 0;
        save = num1;
        dig = 0;
        while(save > 0 ) {
            dig += 1;
            totalSum += save%10;
            if( dig <= half ) {
                sum += save%10;
            } 
            save = save/10;
        }
        if(2*sum != totalSum) return false;
        return true;
    }
    
    public int countSymmetricIntegers(int low, int high) {
        int index = low, count = 0;
        while( index <= high ) {
            //if symmmetric, increment count
            //else continue;
            if(isSymmetric(index)) count++;
            index++;
        }
        return count;
    }
}
