'''
394 Decode String
https://leetcode.com/problems/decode-string/description/

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

Solution:
1. Iterative using stacks
Define two stacks, one for numbers, the other for characters.
For each character read from the input string, do:
a) If char == number, push char into number stack
b) If char == [ or 'a'-'z', push char into characters stack
c) If char == ']', pop all elements from the characters stack until you encounter a ']'. Concatenate all poppped elements and push the concatenated string into the characters stack.

Once the entire input string is read, pop all elements from the characters stack until it is empty. Concatenate all the popped elements. The concatenated string is the result.

Time: O(N), Space: O(N), N = no. of characters

2. DFS using stacks
Time: O(N), Space: O(N), N = no. of characters
'''

# def decodeString(s):
#     def get_integer(s,i):
#         char = ""
#         while i < N:
#             if s[i] == '[':
#                 break
#             char += s[i]
#             i += 1
#         return char, i-1 # digits of the integer, the index of the last digit

#     if not s:
#         return ""
#     N = len(s)
#     numbers = []
#     characters = []
#     i = 0
#     while i < N:
#         char = s[i]
#         if char == ']':
#             # Pop from characters[] until you get a ']'
#             popped_chars = ""
#             while characters[-1] != '[':
#                 popped_chars = characters.pop() + popped_chars
#             characters.pop()
#             result = popped_chars*numbers.pop()
#             characters.append(result)
#         elif ord('a') <= ord(char) <= ord('z'): # char is a character
#             characters.append(char)
#         elif char == '[':
#             characters.append(char)
#         else: # char is an integer
#             char, i = get_integer(s,i)
#             numbers.append(int(char))
#         i += 1

#     result = ""
#     while characters:
#         result = characters.pop() + result

#     return result

# def decodeStringDFS(s):
#     '''
#         Recursive solution using DFS
#         Time: O(N), Space: O(N) (worst case space if N nested levels)
#     '''
#     def get_integer(s,i):
#         char = ""
#         while i < N:
#             if s[i] == '[':
#                 break
#             char += s[i]
#             i += 1
#         return char, i-1 # digits of the integer, the index of the last digit

#     def dfs(i):
#         if i == N:
#             return ""

#         char = s[i]
#         if char == '[':
#             sent = dfs(i+1)
#             return sent
#         elif char == ']':
#             sent = dfs(i+1)
#             if sent:
#                 future_string.append(sent)
#             return ""

#         if ord('a') <= ord(char) <= ord('z'): # char is a character
#             sent = dfs(i+1)
#             result = char + sent
#         else: # char is an integer
#             # read all digits of the integer
#             char, i = get_integer(s,i)
#             sent = dfs(i+1)
#             result = sent*int(char)
#             if future_string:
#                 result = result + future_string.pop()
#         return result

#     if not s:
#         return ""
#     N = len(s)
#     future_string = []
#     return dfs(0)

def decodeStringStack(s):
    '''
        Iterative solution using stack
        Time: O(N), Space: O(N) (worst case space if N nested levels)
    '''
    numbers = []
    characters = []
    curr_str = ""
    curr_num = 0
    for c in s:
        # accumulate numbers and characters until we hit a '['
        if c.isdigit():
            curr_num = curr_num*10 + (ord(c) - ord('0'))
        elif c.isalpha():
            curr_str = curr_str + c
        elif c == '[':
            # '[' signals that we are going one level deeper (L -> L+1)
            # and need to start a new string at level L + 1
            # Thus, curr_num, curr_str become prefix to the string
            # we will build at level L+1
            # Preserve the prefix by pushing curr_num, curr_str into stack
            # Reset curr_num, curr_str to build a new string at L + 1
            numbers.append(curr_num)
            characters.append(curr_str)
            curr_num = 0
            curr_str = ""
        elif c == ']':
            # ']' signals that we are going one level up (from L+1 -> L)
            # Thus, we need to use the current string curr_str at current level
            # L+1 and append it to the prefix at level L
            # curr_num, curr_str become prefix to the string
            times = numbers.pop()
            prefix = characters.pop()
            curr_str = prefix + curr_str*times
    return curr_str


def decodeStringDFS(s):
    '''
        Recursive solution using DFS
        Time: O(N), Space: O(N) (worst case space if N nested levels)
    '''
    def dfs(s):
        nonlocal i
        curr_str = ""
        curr_num = 0
        while i < N:
            c = s[i]
            i += 1
            if c.isdigit():
                curr_num = curr_num*10 + (ord(c) - ord('0'))
            elif c.isalpha():
                curr_str = curr_str + c
            elif c == '[':
                decoded_str = dfs(s)
                curr_str = curr_str + decoded_str*curr_num
                curr_num = 0
            elif c == ']':
                return curr_str
        return curr_str
    N = len(s)
    i = 0
    return dfs(s)


def run_decodeString():
    tests = [("3[a2[c]]", "accaccacc"),
             ("3[a2[c]2[b]]", "accbbaccbbaccbb"),
             ("2[a3[c2[x]]y]", "acxxcxxcxxyacxxcxxcxxy"),
             ("3[a]2[bc]", "aaabcbc"),
             ("3[z]2[2[y]pq4[2[jk]e1[f]]]ef", "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"),
             ]
    for test in tests:
        s, ans = test[0], test[1]
        print(f"\nEncoded String = {s}")
        for method in ['stack', 'dfs']:
            if method == 'stack':
                output = decodeStringStack(s)
            elif method == 'dfs':
                output = decodeStringDFS(s)
            print(f"Method {method}: Decoded String = {output}")
            print(f"Pass: {ans == output}")

run_decodeString()