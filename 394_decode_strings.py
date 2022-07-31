'''

## Problem 394: Decode strings

## Author: Neha Doiphode
## Date:   07-30-2022

## Description:
    Given an encoded string, return its decoded string.

    The encoding rule is: k[encoded_string],
                          where the encoded_string inside the square brackets is being repeated exactly k times.
                          Note that k is guaranteed to be a positive integer.

    You may assume that the input string is always valid;
    there are no extra white spaces,
    square brackets are well-formed, etc.
    Furthermore, you may assume that the original data does not contain any digits and
    that digits are only for those repeat numbers, k.
    For example, there will not be input like 3a or 2[4].

    The test cases are generated so that the length of the output will never exceed 105.

## Examples:
    Example 1:
        Input: s = "3[a]2[bc]"
        Output: "aaabcbc"

    Example 2:
        Input: s = "3[a2[c]]"
        Output: "accaccacc"

    Example 3:
        Input: s = "2[abc]3[cd]ef"
        Output: "abcabccdcdcdef"

 ## Constraints:
    1 <= s.length <= 30
    s consists of lowercase English letters, digits, and square brackets '[]'.
    s is guaranteed to be a valid input.
    All the integers in s are in the range [1, 300].

## Time complexity: O(n), where n is length of the string.

## Space complexity: O(N), where N is number of opening brackets,
                           as opening brackets represent depth of nesting in the input strings.

'''

from typing import List, Optional

def get_input():
    print("Enter the string to decode: ", end = "")
    string = input()
    return string

class Solution:
    # used in the recursive solution
    index = 0
    def decodeString(self, s: str) -> str:
        if len(s) == 0:
            return s

        # Two stacks, string stack stores temporary strings
        # number stack to store numbers
        str_stack = []
        number_stack = []

        # string builder to build the answer string
        str_builder= ""
        # to store how many times a string needs to be repeated in the answer
        num = 0

        # Start looping over every character
        for char in s:

            # if the character is a digit, we use num to store it.
            # Calculation num * 10 + int(char) is done for numbers > 10
            # For example, if the string is 32a, we are supposed to repeat a 32 times.
            # to take 3 and 2 into account:
            # first, num = (0 * 10) + 3 = 3
            # then   num = (3 * 10) + 2 = 32 and so on multi digit numbers.
            if char.isdigit():
                num = num * 10 + int(char)

            # when we encounter opening bracket, we know there is nested string.
            # so we push existing built string onto the string stack and number onto the number stack.
            # And then clear both variables, str_builer and num to start building new nested strings.
            elif char == "[":
                str_stack.append(str_builder)
                number_stack.append(num)
                str_builder = ""
                num = 0

            # On closing bracket, we need to pop elements from stack to build the actual answer string.
            # So, we first pop out number of times to repeat from number stack.
            # Repeat current string those many times.
            # then we pop out previously stored string on top the string stack as prefix
            # and finally pre-pend prefix with string builder tp form new current string.
            elif char == "]":
                times = number_stack.pop()
                str_builder *= times
                prefix = str_stack.pop()
                str_builder = prefix + str_builder

            # if we encounter character, we simply append it to the existing string.
            else:
                str_builder += char

        # finally return the fully built answer string after all characters are processed.
        return str_builder


# Driver code
solution = Solution()
input_string = get_input()
print(f"Input string: {input_string}")
print(f"Output decoded string: {solution.decodeString(input_string)}")
print()
