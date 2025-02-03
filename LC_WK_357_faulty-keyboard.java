class Solution {
    public String finalString(String str) {
        int strLength = str.length();
        String finalString = "";
        for(int index = 0; index < strLength; index++ ) {
            char ch = str.charAt(index);
            if(ch != 'i') finalString += ch;
            else  {
                finalString = new StringBuilder().append(finalString).reverse().toString();
            }
        }
        return finalString;
    }
}
