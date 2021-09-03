# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO

class Solution:
    def decodeString(self, s: str) -> str:
        stack = [''] 
        stackcnt = []
        k = 0
        for c in s:
            if c.isdigit():
                k = k * 10 + int(c)
            elif c == '[': 
                stackcnt.append(k)
                k = 0
                stack.append('')  
            elif c == ']':  
                add = stack.pop()
                cnt = stackcnt.pop()
                stack[-1] += add * cnt
            else:  
                stack[-1] += c
        
        return stack.pop()