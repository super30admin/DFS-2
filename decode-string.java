// Time Complexity : O(Length(output string))
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Recursive
// TC = O(Length(output string)), SC = O(H); H = Max depth of stack/ no of nestings/ no of open braces
// class Solution {
//     int i;
//     public String decodeString(String s) {
//         StringBuilder currStr = new StringBuilder();
//         int num = 0;
//         while(i < s.length()) {
//             char c = s.charAt(i);
//             if(Character.isDigit(c)) { // for digits
//                 i++;
//                 num = num * 10 + c - '0';
//             }
//             else if(c == '[') { 
//                 i++;
//                 String decoded = decodeString(s); // calling recursion, global i is taking care of from where to call s (Instead of sending substring)
//                 // parent -> currStr
//                 for(int j = 0; j < num; j++) currStr.append(decoded);
//                 num = 0;
//             }
//             else if(c == ']') {
//                 i++;
//                 return currStr.toString();
//             }
//             else { // for chars
//                 i++;
//                 currStr.append(c);
//             }
//         }
//         return currStr.toString();
//     }
// }

// Itertaive
// TC = O(Length of output string),SC = O(H); H = Max depth of stack/ no of nestings/ no of open braces
class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) num = num * 10 + c - '0';
            else if(c == '[') { // beginning of new nesting, put previous in stacks and reset vars
                strSt.push(currStr);
                numSt.push(num);
                currStr = new StringBuilder();
                num = 0;
            }
            else if(c == ']') { // 1 nesting is done, so we repeat it no of times and we append it to the parent
                int k = numSt.pop();
                StringBuilder temp = new StringBuilder(); // make a new StringBuilder to avoid bug
                for(int j = 0; j < k; j++) temp.append(currStr);
                StringBuilder parent = strSt.pop();
                currStr = parent.append(temp);
            }
            else currStr.append(c); // processing the chars
        }
        return currStr.toString();
    }
}