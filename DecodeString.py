---------------------------------- Decode String -------------------------------------
# Time Complexity : O(N) N is the length of the s
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we used a stack and when ever we encounter digit we will assign it to another variable. when we found '['
# we will append to stack and when we found ']' we will remove the string from stack until we reach the '['
# If it is a character, then I will append to stack.Once the string is processed, I will join the string 





class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        num = ''
        for i in s:
            if i.isdigit():
                num+=i
            elif i == '[':
                stack.append(num)
                stack.append('[')
                num = ''
            elif i == ']':
                s = ''
                while stack and stack[-1] != '[':
                    s = stack.pop()+s
                stack.pop()
                stack.append(s*int(stack.pop()))
                
            else:
                stack.append(i)
                
        
        return ''.join(stack)