//https://leetcode.com/submissions/detail/617276846/
//Time: O(number of chars * max(total number of chars))
//Space: O(n)
class Solution {
    
    int i;
    
    public String decodeString(String s) {
        
        i = 0;
        return helper(s);
    }
    
    private String helper(String s) {
        
     String currString = "";
    int currNumber = 0;
     while(i < s.length()){
        
         char c = s.charAt(i);
        if(Character.isDigit(c)) {
            i++;
            currNumber = currNumber * 10 + (c - '0');

        } else if ( c == '['){
            i++;
            String innerDecoded = helper(s);
            String temp= "";
            for(int j = 0; j < currNumber; j++) {
                temp += innerDecoded;
            }
            currString += temp;
            currNumber = 0;
                
        } else if( c == ']') {

            i++;
            return currString;

        } else {
            i++;
            currString += c;
        }
     }
     return currString;   
  }
}