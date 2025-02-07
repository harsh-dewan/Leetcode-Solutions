class Solution {
    public String maximumOddBinaryNumber(String str) {
        int strLength =  str.length();
        int zcount = 0, ocount = 0;
        for(int index = 0; index < strLength; index++ ) {
            if(str.charAt(index) == '0') zcount++;
            else ocount++;
        }
        String finalString = "";
        while(ocount > 1 ) {
            finalString += "1";
            ocount -= 1;
        }
        while(zcount > 0 ) {
            finalString += "0";
            zcount -= 1;
        }
        return finalString+="1";
    }
}
