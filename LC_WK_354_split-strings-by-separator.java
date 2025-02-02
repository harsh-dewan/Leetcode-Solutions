class Solution {
    public ArrayList<String> finalList = null;

    public void splitString(String word, char separator) {
        String temp = "";
        int wordLength = word.length();
        for(int index = 0; index < wordLength; index++ ) {
            char ch = word.charAt(index);
            if( ch == separator ) {
                if(temp.length()>0) finalList.add(temp);
                temp = "";
            }
            else temp = temp+ch;
        }
        if(temp.length()>0) finalList.add(temp);
        return;
    }
    
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        int totalStrings = words.size();
        finalList = new ArrayList<String>();
        for(int index = 0; index < totalStrings; index++ ) {
            splitString(words.get(index), separator);
        }
        return finalList;
    }
}
