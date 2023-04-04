# Time Complexity : O(max_k * n) where where max_K is the maximum value of k and n is the length of the input string s.
# Space Complexity : O(n), here n is the length of string
class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        num = 0
        res = ""
        for c in s:
            if c.isdigit():
                num = num * 10 + int(c)
            elif c.isalpha():
                res += c
            elif c == "[":
                stack.append((num, res))
                num = 0
                res = ""
            elif c == "]":
                prev_num, prev_res = stack.pop()
                res = prev_res + prev_num * res
        return res
