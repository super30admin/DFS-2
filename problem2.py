# Time Complexity : O(max(len(s), mul_of_nums))
# Space Complexity : O(num_of_open_brackets)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class Solution:
    # iterative solution
    def decodeString(self, s: str) -> str:
        stack = []

        cur_str = ""
        cur_num = 0
        for c in s:
            if c.isdigit():
                cur_num = cur_num*10 + int(c)
            elif c.isalpha():
                cur_str += c
            elif c == "[":
                stack.append((cur_num, cur_str))
                cur_num = 0
                cur_str = ''
            else: # case: c == "]"
                num, parent = stack.pop()
                cur_str = cur_str * num
                cur_str = parent + cur_str
        
        return cur_str
    
    # recursive solution
    def rec_decodeString(self, s: str, index = 0) -> str:
        stack = []

        cur_str = ""
        cur_num = 0
        i = index
        while i < len(s):
            if s[i].isdigit():
                cur_num = cur_num * 10 + int(s[i])
            elif s[i].isalpha():
                cur_str += s[i]
            elif s[i] == "[":
                jump, baby_str = self.rec_decodeString(s, i+1)
                cur_str = cur_str + cur_num * baby_str
                i = jump
                cur_num = 0
            else:
                return (i,cur_str)
            i += 1
        
        return cur_str