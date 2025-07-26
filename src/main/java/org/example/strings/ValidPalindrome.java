package org.example.strings;
class ValidPalindrome {
    public boolean isPalindrome(String s) {
        /*
        Ths leetcode problem is a waste of time but if it is reworded a little, it is not. 
        Assume s consists of only alphanumeric chars. 
        
        BF:
        - set two pointers: left starting at index 0 and right starting at s.length() - 1 mover them towards each other while left is eaul to right and stop when left > right 
        if at anypiint left != right return false
        
        Recursive version: 
        - if s is of length 1 return true
        - else if left most letter == right most letter pass substring of s 
        - else return false 
        */
        if(s.length() == 1 || s.length() == 0)
        {
            return true;
        }
        else if(s.charAt(0) == s.charAt(s.length() - 1))
        {
            return isPalindrome(s.substring(1, s.length() - 1));
        }
        else 
        {
            return false;
        }
        
    }
}