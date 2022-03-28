// Time Complexity : O(maxK * n) maxK is maximum value of k or digit. and n is length of String
// Space Complexity : O(n) used by stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Declare a global variable index to keep track of the position
// Declare string builder res to store the results
// Initiate while loop that would go untill the closing bracket
// If character is non digit append it to res string
// Otherwise  if digit take the digit value in k
// Increment extra index to skip opening bracket
// Now call recursively the function and stroe it in decodedString
// Append the result to res the number of times k is suggesting
class Solution {
    int index = 0;
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        while(index < s.length() && s.charAt(index) != ']'){
            if(!Character.isDigit(s.charAt(index)))
                res.append(s.charAt(index++));
            else{
                int k = 0;
                while(index < s.length() && Character.isDigit(s.charAt(index)))
                    k = k * 10 + s.charAt(index++) - '0';
                index++;
                String decodedString = decodeString(s);
                index++;
                while(k-- > 0)
                    res.append(decodedString);
            }
        }
        return res.toString();
    }
}