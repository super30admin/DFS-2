# // Time Complexity : O(maxK.n) where maxK is the maximum value of K and n is number of letters
# // Space Complexity : O(n+m) where n is number of digits and m is the number of letters
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def decodeString(self, s: str) -> str:
        
        stack = []
        
        # loops through the string
        for i in range(len(s)):
            if s[i] != "]":
                stack.append(s[i])
            else:
                substr = ""
                while stack[-1] != "[":
                    substr = stack.pop() + substr
                stack.pop()
            
                k = ""
                while stack and stack[-1].isdigit():
                    k = stack.pop() + k  
                # take the substring and append
                stack.append(int(k) * substr)
            
        return "".join(stack)