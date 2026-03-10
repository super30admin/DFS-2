# Time Complexity : O(n * k)  # n = length of string, k = max repeat number
# Space Complexity : O(n)     # recursion stack for nested brackets
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# The code recursively decodes a string with nested patterns like k[encoded_string].
# It keeps track of repeat counts and builds the decoded substring for each level of brackets.
# Recursion handles nested brackets automatically, returning the fully decoded string.

class Solution:
    def decodeString(self, s: str) -> str:
        def dfs(i):
            res = ""
            num = 0
            while i < len(s):
                if s[i].isdigit():
                    num = num * 10 + int(s[i])
                    i += 1
                elif s[i] == '[':
                    sub, i = dfs(i + 1)
                    res += sub * num
                    num = 0
                elif s[i] == ']':
                    return res, i + 1
                else:
                    res += s[i]
                    i += 1
            return res, i

        decoded, _ = dfs(0)
        return decoded