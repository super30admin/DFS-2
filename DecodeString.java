package Nov13;

class DecodeString {
    public String decodeString(String s) {
        
/*
  Time Complexity: O(n*k) where n is number of characters in string s and k is number of times a substring is to be repeated in the given string.
  
  Space Complexity: O(n)
  Because if given string is like 1[a2[b3[c4[d....  then each stack will contain n/4 elements as shown below because all n characters of the string are divided into 4 chunks, one number, one alphabet, one opening and closing bracket.
Hence, total space used = O(n/4)+O(n/4) ~= O(n)
  
|    3  |           |    c  | 
---------           ---------
|    2  |           |    b  |
---------           ---------
|    1  |           |    a  |
 --------           --------   
  numStack          strStack
 
  Did this code successfully run on Leetcode : Yes
 
  Any problem you faced while coding this : No
     
  Approach: 
  DFS applied to form string of innermost child and keep appending it as we grow outwards towards the first character of the encoded string.
  Iterative approach used by making use of 2 stacks, one for storing frequency of a set of alphabets and another for storing parent string formed till now.
                        
*/ 
        
        
        // edge
        if (s == null || s.length() == 0) {
            return s;
        }
        
        int num = 0;
        StringBuilder curStr = new StringBuilder();
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            
            char curElem = s.charAt(i);
            
            // digit check
            if (Character.isDigit(curElem)) {
                // to accomodate numbers having more than 1 digit, we are performing below operation
                num = num*10 + (curElem - '0');
            }
            
            // open brackets check
           else  if (curElem == '[') {
                // add parent string to string stack and frequency to numstack
                // reinitialize both variables to process child string.
                numSt.add(num);
                strSt.add(curStr);
                curStr = new StringBuilder();
                num = 0;
            }
            
            // close brackets check
            else if (curElem == ']') {
                // create a temp stringbuilder to store the curStr*frequency times.
                int freq = numSt.pop();
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < freq; j++) {
                    temp.append(curStr);
                }
                // append the temp stringbuilder(child content) at the end of the stringbuilder content stored in stack(parent content) and store the same in stringstack.
                StringBuilder popped = strSt.pop();
                curStr = popped.append(temp);
            }
            
            // alphabets check
            else {
                curStr.append(curElem);
            }
        }
        
        return curStr.toString();
    }
}