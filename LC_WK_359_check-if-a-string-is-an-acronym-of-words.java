class Solution {
    public boolean isAcronym(List<String> words, String str) {
        int totalWords = words.size();
        int strLength =  str.length();
        if( totalWords !=  strLength ) return false;
        int index = 0;
        while(index < totalWords) {
            if( str.charAt(index) != words.get(index).charAt(0)) return false;
            index++;
        }
        return true;
    }
    
}
