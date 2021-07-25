package DFS2;

import java.util.Stack;

/*S30 Big N Problem #67 {Medium} - https://www.youtube.com/watch?v=FKmSxpNBj_k&list=PLWtKyKogBpBB3ZUuLAjIlCzZ5bnbult-t&index=23
    you are given an encoded string and you have to return the decoded string.

the rule for encoding is:

The encoding rule is: k[encoded_string], where the encoded_stringinside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
        
https://leetcode.com/problems/decode-string/
-------------------------------------------------------------------------------------------------------
Time complexity :  O(M) where M is maximum depth of decoded string * number ahead of the that decoded
space complexity: O(N) where N is maximum depth of decoded string
Did this code run successfully in leetcode : yes
problems faces : no*/
    
public class DecodeString {
    
    public String decodeStringIterative(String s) {
        
        if(s == null || s.length() == 0 ) return s;
        
        Stack<Integer> stNum = new Stack<Integer>();
        Stack<String>  stString = new Stack<String>();
        
        int n = s.length();
        
        String currStr = "";
        int num =0;
        
        
        for(int i=0;i<n;i++)
        {
            
            if(Character.isDigit(s.charAt(i)))
            {
                num = num *10 + s.charAt(i)-'0';
                
            }
            else if(s.charAt(i) == '[')
            {
              
                stNum.add(num);
                stString.add(currStr);
                
                num =0 ;
                currStr = "";
            }
            else if(s.charAt(i) == ']')
            {
                int times = stNum.pop();
                String tempStr = "";
             
                for(int k=0;k<times;k++)
                {
                    tempStr = tempStr+ currStr;
                }
                
                currStr = stString.pop()+ tempStr;
                
            }
            else
            {
                
                currStr = currStr+ s.charAt(i);
            }
            
        }
        
        return currStr;
        
    }
    
  //---------------------------------------Recursive--------------------------------------------

    int i ;  
 public String decodeString(String s) {
 
        
     if(s == null || s.length() == 0 ) return s;
        
        StringBuilder currStr = new StringBuilder();
        int num =0;
        
        
       while(i<s.length())
        {
            
            if(Character.isDigit(s.charAt(i)))
            {
                num = num *10 + s.charAt(i)-'0';
                i++;
                
            }
            else if(s.charAt(i) == '[')
            {
              i++;
              String child = decodeString(s);
              StringBuilder newStr = new StringBuilder();  
              for(int k=0;k<num;k++)
              {
                  newStr.append(child);
              }
              currStr = currStr.append(newStr);
              num = 0;
            }
            else if(s.charAt(i) == ']')
            {
                i++;
                return currStr.toString();
            }
            else
            {
               currStr =  currStr.append(s.charAt(i));
                i++;  
            }
        }
        
        return currStr.toString();
        
    }
    
    

}
