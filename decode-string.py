"""

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

 
Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].


Time Complexity: O(N), where N is the length of the string, as each character is processed once.
Space Complexity: O(N), due to the stack storing substrings and repeat counts in the worst case.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach: 
# Use a stack to store previous strings and repeat counts when encountering '['. 
# When encountering ']', pop from the stack and construct the decoded string by repeating the substring. 
# Process digits to form numbers and accumulate characters for the current substring.


class Solution:
    def decodeString(self, s: str) -> str:

        stack = []
        num = 0
        curr_str = ""

        for char in s:
          
            if char == "[":
                stack.append((curr_str, num))
                num = 0
                curr_str = ""
              
            elif char == "]":
                last_str, repeat = stack.pop()
                curr_str = last_str + repeat * curr_str
              
            elif char.isdigit():
                num = num * 10 + int(char)
              
            else:
                curr_str += char

        return curr_str

