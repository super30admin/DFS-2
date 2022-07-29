//Time Complexity: O(max_number * n); where n is the size of string and max_number is the max times that repetition occurs.
//Space Complexity: O(n * l); where l is the level of nesting.
//Code run successfully on LeetCode.

public class Problem2_Recursion {

    int i;
    public String decodeString(String s) {
        
        if(s == null|| s.length() == 0)
            return " ";
        
        int num = 0;
        StringBuilder currString = new StringBuilder();
        
        while(i < s.length()){
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num*10 + c - '0';
                i++;
            }
            
            else if(c == '['){
                i++;
                String decodedString = decodeString(s);
                StringBuilder newString = new StringBuilder();
                for(int i =0; i < num; i++)
                    newString.append(decodedString);
                num = 0;
                currString.append(newString);
            }
            
           else if(c == ']'){
               
               i++;
               return currString.toString();
           }
            else
            {
              i++;
              currString.append(c);                
            }
        }
         return currString.toString();
    }
}
