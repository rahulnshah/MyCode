package org.example.strings;
class ValidIP{
    public boolean isIPv4(String [] ipTokens)
    {
        if(ipTokens.length == 4)
        {
           /*
           for each token t:
            if length of t is 0 or length of t > 3, return false 
            else if length of t > 1 and first char is 0, return false 
            loop the characters of t and check if their ascii value is between that of 0 and 9 ; if not, return false 
            if we got to this point, check if Integer.parseInt(t) > 255, if so, return false 
            return true 
           */
            for(String ipToken : ipTokens)
            {
                 if(ipToken.length() == 0 || ipToken.length() > 3)
                 {
                    return false;
                 }
                 else if(ipToken.length() > 1 && ipToken.charAt(0) == '0')
                 {
                     return false;
                 }
                 for(int i = 0; i < ipToken.length(); i++)
                 {
                      if(!((int) ipToken.charAt(i) >= (int) '0' && (int) ipToken.charAt(i) <= (int) '9'))
                      {
                            return false;
                      }
                 }
                 // need to check if ipToken > 255, if so return false 
                 if(Integer.parseInt(ipToken) > 255)
                 {
                     return false;
                 }
            }
            return true;
        }
        return false;
    }
    
    public boolean isIPv6(String [] ipTokens)
    {
         /*
           for each token t:
            if length of t is 0 or length of t > 3, return false 
            else if length of t > 1 and first char is 0, return false 
            loop the characters of t and check if their ascii value is between that of 0 and 9 ; if not, return false 
            if we got to this point, check if Integer.parseInt(t) > 255, if so, return false 
            return true 
           */
        
        if(ipTokens.length == 8)
        {
            for(String ipToken : ipTokens)
            {
                 if(ipToken.length() == 0 || ipToken.length() > 4)
                 {
                    return false;
                 }
                 for(int i = 0; i < ipToken.length(); i++)
                 {
                        // if char is not (number, lowercase letter, or upper case letter)
                      if(!(((int) ipToken.charAt(i) >= (int) '0' && (int) ipToken.charAt(i) <= (int) '9')
                      || ((int) ipToken.charAt(i) >= (int) 'a' && (int) ipToken.charAt(i) <= (int) 'f')
                      || ((int) ipToken.charAt(i) >= (int) 'A' && (int) ipToken.charAt(i) <= (int) 'F')))
                      {
                            return false;
                      }
                 }
            }
            return true;
        }
        return false;   
    }
    
    
    public String validIPAddress(String queryIP) {
        /*
        A valid IPv4 address:
         - cannot contain leading zeros
         - x_i is a digit between 0 and 255 
         
        A vliad IPv6 address:
        - x_i may contain digits, lower case Englist letter a to f and upper case english letter A to F
        - leading zeros are allowed in x_i 
        
        need to return "IPv4", "IPv6" or "Neither"
        
        BF:
         - validate IPv4:
            Since the '.' separates the x_i in IPv4, I can split the tokens 
            - loop each token (string or x_i) and then f any of the strings in the array does not pass the requirements, return false else return true at the ned of loop 
        
        - validate IPv6:
            Since the ':' separates the x_i in IPv4, I can split the tokens 
            - loop each token (string or x_i) and then f any of the strings in the array does not pass the requirements, return false else return true at the ned of loop
            
        else return "Nethier"
        
        Time:
        Space: 
        
        */
        if(queryIP.length() == 0 || queryIP.charAt(queryIP.length() - 1) == ':' || queryIP.charAt(queryIP.length() - 1) == '.')
        {
            return "Neither";
        }
        else if(isIPv4(queryIP.split("\\.")))
        {
           return "IPv4"; 
        }
        else if(isIPv6(queryIP.split(":")))
        {
            return "IPv6";
        }
        else 
        {
            return "Neither";
        }
    }
}