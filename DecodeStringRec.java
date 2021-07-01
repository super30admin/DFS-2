//Time Complexity - O(nk)  where k is the maximum number in the string
//Space complexity - O(nk)


class Solution {
  int i = 0;
    public String decodeString(String s) {
      
      //null case
      if(s == null || s.length() == 0) return s;
      int num = 0;
    
      StringBuilder currStr = new StringBuilder();
      while(i<s.length()) {
        char c = s.charAt(i);
        if(Character.isDigit(c)) { // update the currStr
          num = num * 10 + c-'0';
          i++;
        } else if(c =='[') { 
          i++;
          String child = decodeString(s);  
          StringBuilder newStr = new StringBuilder();
          for(int k = 0; k<num;k++) {
            newStr.append(child);
          }
          currStr.append(newStr);
          num = 0;
        } else if(c == ']') { 
           i++;
          return currStr.toString();
        } else {
          currStr.append(c);
          i++;
         
        }
      }
      return currStr.toString();
        
    }
}