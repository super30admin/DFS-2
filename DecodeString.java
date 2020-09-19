/*
 * #394. Decode String
 * 
 * Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"

 */


/*
 * Time Complexity: O (N) + O (No of times popped) -> Explained in code section
 * 
 * Space Complexity: O (N) -> Overall 'N' elements in given string are pushed onto respective stack but not all at the same time
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.DFS2;

import java.util.Stack;

public class DecodeString {
public String decodeString(String s) {
        
        // #1. Base condition
        if(s == null || s.length() == 0){
            return "";
        }
        
        // #2. Create two stacks
        // One for string and other for number
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        
        // #3. Initialize the currNum and currString variables
        int currNum = 0;
        String currString = "";
        
        // #4. Traverse through the given string
        
        // Time complexity: O (N) -> 'N' elements in given string
        // Overall time complexity: outer for loop: O (N) + pop operation: O (no of times popped)
        // We do pop operation only when ']' is encountered, not for all elements in given string, so we add its TC to outer for loop's TC 
        for(int i = 0; i < s.length(); i++){
            // Get the current character in string
            char ch = s.charAt(i);
            
            //Check if character is a digit. If yes,
            // e.g: 
            // e.g: 31[a] 
            // currNum = 0 * 10 + ('3' - '0')     -> converting character '3' to a digit by subtracting ASCII value of character '0' from its ASCII value to get the digit (3), currNum = 3
            // currNum = 3 * 10 + ('1' - '0')    , currNum = 31
            if(Character.isDigit(ch)){
                currNum = currNum * 10 + (ch - '0');
            }
            
            // Check if character is '['
            else if(ch == '['){
                // push the currNum and currString to respective stacks
                numStack.add(currNum);
                strStack.add(currString);
                
                // And, reset both after pushing to stack
                currNum = 0;
                currString = "";
            }
            
            // Check if character is ']'
            else if(ch == ']'){
                // pop the top from numStack, multiply the currstring to top and store in temp string
                int popped = numStack.pop();
                
                String temp = "";
                // Multiply operation is similar to adding the currString 'top'(e.g: 3) times into temp string
                // for loop will run 3 times for example
                
                // Time complexity for pop operation is O (no of times popped)
                for(int x = 0; x < popped; x++){  // for example 1 in description, we are doing pop operation total 3 + 2 = 5 times 
                    temp += currString;
                }
                
                // pop the top from strStack into currString and append the temp and currstring into currstring
                currString = strStack.pop();
                currString = currString + temp;
                
            }
            
            // Check if character is a char -> e.g: 'a'
            else{
                currString += ch;
            }
            
        }
        return currString; // return the output
    }

}
