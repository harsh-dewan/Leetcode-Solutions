class Solution {
    public int addMinimum(String word) {
        /**
        1. we are comparing evry character to check if its at right place or not
        2. we are trying to make our string equal to combination of 'abc' repeated over number of times
        3. we are comparing every character with the charcaters of 'abc'. if both ch are equal we move to next character else we increment the count and compares current word character with the 'abc' next character
        4. we return count at last.
        5. if last cgaracter is 'a'
 we have to add 'bc' so return count+2;
 6. else if last character is 'b' return count+1;
         */
        String requiredString = "abc";
        int count = 0;
        int wordLength = word.length();
        int index1 = 0, index2 = 0;
        char ch1 = word.charAt(wordLength-1);
        while(index1 < wordLength ) {
            ch1 = word.charAt(index1);
            char ch2 = requiredString.charAt(index2);
            if( ch1 !=  ch2 ) count += 1;
            else index1++;
            index2 = (index2+1)%3;
        }
        if( ch1 == 'a' ) return count+2;
        if( ch1 == 'b' ) return count+1;
        return count;
    }
}
