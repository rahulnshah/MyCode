package strings;

public class ValidAbbrv {
    public boolean validWordAbbreviation(String word, String abbreviation) {
        /*
       Use two pointers approach: O(n) time
        - set a pointer i on word and pointer j and loop both strings at the same time
        - if you come across a letter in word and abbrv and it does not match, then return false else inc both
        ptrs and advance to next char
        - if you find a number in abbrv, collect it, check if it has leading 0s (it should not)
        - return True at the end if you have reached the end of both strings
        */
        int i = 0, j = 0;
        int m = word.length(), n = abbreviation.length();
        while(i < m) {
            // if you reach the end of abbrv before reaching the end of word then return false
            if(j >= n) {
                return false;
            }

            // if both characters are eq, inc both i and j
            if(word.charAt(i) == abbreviation.charAt(j)) {
                i++;
                j++;
                continue;
            }
            // if they are not equal, check if the char at abbrv is a digit, if not return false
            if(!Character.isDigit(abbreviation.charAt(j))) {
                return false;
            }
            // it is a digit, so collect it
            int start = j;
            while(start < n && Character.isDigit(abbreviation.charAt(start))) {
                start++;
            }
            String strInt = abbreviation.substring(j, start);
            // check if there is a leading 0
            if(strInt.charAt(0) == '0') {
                return false;
            }
            // move the pointer i forward in word by strInt and set j to start cuz we finished parsing the int
            i += Integer.parseInt(strInt);
            j = start;
        }
        return i == m && j == n;
    }
}

