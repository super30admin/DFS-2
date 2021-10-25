#Time Complexity : O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No

class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        
        for i in range(len(s)):
            if s[i] != "]":
                stack.append(s[i])
            else:
                substr = ""
                while stack[-1] !="[":
                    substr = stack.pop()+ substr
                stack.pop()
                k = ""
                while stack and stack [-1].isdigit():
                    k= stack.pop()+k
                stack.append(int(k)*substr)
                
        return "".join(stack)
