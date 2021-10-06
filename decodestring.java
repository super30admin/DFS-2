
time complexity: O(n)
space complexity: O(n)

class Solution {
    
    private int pos = 0;
    
    public String decodeString(String s) {
    
    StringBuilder sb = new StringBuilder();
    String num = "";
    for (int i = pos; i < s.length(); i++) {
           if (Character.isDigit(s.charAt(i))) {
        num += s.charAt(i);
      }
      else if (s.charAt(i) == '[') {
        pos = i + 1;
        String next = decodeString(s);
        for (int n = Integer.valueOf(num); n > 0; n--) {
          sb.append(next);
        }
        num = "";
        i = pos;
      } 
      else if (s.charAt(i) == ']') {
        pos = i; 
        return sb.toString();
      } 
      else {
        sb.append(s.charAt(i));
      } 
    }

    return sb.toString();
     
    }
}