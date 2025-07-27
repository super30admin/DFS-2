// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem2 (https://leetcode.com/problems/decode-string/)
// Given an encoded string, return its decoded string.
// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
// You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
// The test cases are generated so that the length of the output will never exceed 105.

// Example 1:
// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"

// Example 2:
// Input: s = "3[a2[c]]"
// Output: "accaccacc"

// Example 3:
// Input: s = "2[abc]3[cd]ef"
// Output: "abcabccdcdcdef"
 
// Constraints:
// 1 <= s.length <= 30
// s consists of lowercase English letters, digits, and square brackets '[]'.
// s is guaranteed to be a valid input.
// All the integers in s are in the range [1, 300].

class Solution {
    int i; // Global pointer to keep track of position during recursion
    public String decodeString(String s) {
        if (s == null || s.length() == 0){
            return "";
        }

        int num = 0; // To build the multiplier for bracketed substring
        StringBuilder currStr = new StringBuilder();

        while(i < s.length()){
            char c = s.charAt(i);

            // If digit, build the repeat number (could be > 9, e.g., "23[a]")
            if (Character.isDigit(c)){
                i++;
                num = num * 10 + (c - '0');
            }

            // When '[' is encountered, recurse to decode the substring inside brackets
            else if (c == '['){
                i++;
                String decoded = decodeString(s); // Recurse to decode inner substring

                // Repeat the decoded string 'num' times
                StringBuilder newStr = new StringBuilder(); 
                for (int i = 0; i < num; i++){
                    newStr.append(decoded);
                }
                currStr = currStr.append(newStr); // Append repeated string to current string
                num = 0; // Reset num for next potential repeat group
            }

            // When ']' is encountered, return current decoded string
            else if (c == ']'){
                i++; // Move past ']'
                return currStr.toString(); // End this level of recursion
            }

            // If it's a normal character (letter), just append
            else{
                i++;
                currStr.append(c);
            }
        }
        
        return currStr.toString(); // Final decoded string

    }
}

