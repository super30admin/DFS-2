# // Time Complexity : O(n) where n is length of the string
# // Space Complexity : O(b) where b is th number of times a bracket pair appears
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 

class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        num = 0
        cur = ''
        i = 0
        
        while i < len(s):
            if s[i].isdigit():
                while s[i].isdigit():
                    num = num*10 + int(s[i])
                    i += 1
            elif s[i] == '[':
                stack.append(cur)
                cur = ''
                stack.append(num)
                num = 0
                i += 1
            elif s[i] == ']':
                times = stack.pop()
                string = ''
                for t in range(times):
                    string += cur
                cur = stack.pop() + string
                i += 1
            else:
                cur += s[i]
                i += 1
        return cur
                
                