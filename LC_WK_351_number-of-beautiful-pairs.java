class Solution {

    public int gcd(int num1, int num2) {
        if(num2 == 0 ) return num1;
        return gcd(num2, num1%num2);
    }
    public int countBeautifulPairs(int[] nums) {
        int numsLength = nums.length;
        int count = 0;
        for(int index1 = 0; index1 < numsLength; index1++ ) {
            for(int index2 = index1+1; index2 < numsLength; index2++) {
                int num1 = nums[index1];
                int num2 = nums[index2];
                while( num1 > 9 ) num1=num1/10;
                if( gcd(num1,num2%10) == 1)  count++;            
            }
        }
        return count;
    }
}
