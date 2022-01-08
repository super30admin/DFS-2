// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// recursively call the same fucntion for the sub part, first take num to store the nums, then if found [ then get the string from recursion, and multiply it for num time, then add it to the end of curr string, if ] then return the curr string. else add the char to curr string
// Your code here along with comments explaining your approach
// using recursion - O(n)
class Solution {
    int i;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        StringBuilder curr = new StringBuilder();
        int num = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10 + (ch-'0');
                i++;
            }else if( ch == '['){
                i++;
                String part = decodeString(s);
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < num; j++){
                    sb.append(part);
                }
                curr.append(sb);
                num = 0;
            }else if( ch == ']'){
                i++;
                return curr.toString();
            }else{
                curr.append(ch);
                i++;
            }
        }
        return curr.toString();
    }
}

// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// have stack for storing the subpart of the string when found [ with the num; and if foud ] then multiply the curr string to the poped number of time, then add the curr string to the poped stored string and make it as the curr string, if nothing then set the character to the curr string
// Your code here along with comments explaining your approach
// Using - stacks
// class Solution {
//     public String decodeString(String s) {
//       if( s== null || s.length() == 0) return "";
//       StringBuilder curr = new StringBuilder();
//       Stack<StringBuilder> charSt = new Stack<>();
//       Stack<Integer> numSt = new Stack<>();
//       int num = 0;
//       for(int i = 0; i < s.length(); i++){
//           char ch = s.charAt(i);
//           if(Character.isDigit(ch)){
//               num = num*10 + (ch-'0');
//           }else if(ch == '['){
//               // add to the stack
//               numSt.add(num);
//               charSt.add(curr);
//               curr = new StringBuilder();
//               num = 0;
//           }else if(ch == ']'){
//               int time = numSt.pop();
//               StringBuilder sb = new StringBuilder();
//               for(int j = 0; j < time; j++){
//                   sb.append(curr);
//               }
//               curr = charSt.pop().append(sb);
//           }else{
//               curr.append(ch);
//           }
//       }
//       return curr.toString();
//     }
// }