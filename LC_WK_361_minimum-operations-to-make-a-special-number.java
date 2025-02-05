class Solution {
    public int minimumOperations(String str) {
        int numsLength = str.length();
        if( numsLength >= 2 ) {
            int num1 = Integer.parseInt(str.substring(numsLength-2));
            if( num1%25  == 0 ) return 0;
        }
        int minCount = numsLength;
        for(int index1 = numsLength-1; index1 >= 0; index1--) {
            //either the char is 5 or 0 
            if(str.charAt(index1) == '5' ) {
                int index = index1-1;
                boolean found2 = false;
                int count = 0;
                while(index>=0) {
                    if(str.charAt(index) == '2'  || str.charAt(index)=='7') {
                        found2 = true;
                        break;
                    }
                    else count++;
                    index--;
                }
                if(found2 == true ) {
                    minCount = Integer.min(minCount,count+(numsLength-index1-1));
                }
            }
            else if(str.charAt(index1) == '0' ) {
                int index = index1-1;
                boolean found2 = false;
                int count = 0;
                while(index>=0) {
                    if(str.charAt(index) == '0'  || str.charAt(index)=='5') {
                        found2 = true;
                        break;
                    }
                    else count++;
                    index--;
                }
                if(found2 == true ) {
                    minCount = Integer.min(minCount,count+(numsLength-index1-1));
                }
                else minCount = Integer.min(minCount,count+(numsLength-index1-1));
            }
        }
        return minCount;
    }
}
