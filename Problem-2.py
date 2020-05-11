"""
## Problem2 (https://leetcode.com/problems/decode-string/)
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_stringinside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".

s = "3[a2[c]]", return "accaccacc".

s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

time - O(n)
space - (n)

"""
def DecodeString(s):
    number_stack = []   # stack to keep track of number
    string_stack = []    # stack to keep track of string
    curr_num = 0         # curr env num
    curr_string = ''     # curr env string
    for char in s:

        if char == ' ] ':
            time = number_stack.pop()
            process = time * curr_string
            curr_string = string_stack.pop()+ process


        elif char == '[':    #think start of new environment
            number_stack.append(curr_num)
            string_stack.append(curr_string)

            #reseting
            curr_num = 0
            curr_string = ''


        elif char.isnumeric():     #if numeric
            curr_num = curr_num * 10 + char

        else:
            curr_string  += char
    return curr_string


print(DecodeString("2[abc]3[cd]ef"))
