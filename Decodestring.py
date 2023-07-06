# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        for i in s:
            if i == ']':     
                temp = ''
                while stack:
                    j = stack.pop()
                    if j == '[':
                        break
                    temp += j
                multiple = ''
                while stack and stack[-1].isnumeric():
                    multiple += stack.pop()
                stack.extend(temp[::-1] * int(multiple[::-1]))
                continue
                
            stack.extend(i)
        
        return ''.join(stack)
            
            
            