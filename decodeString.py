# Time Complexity : O(maxCount * n) bc traverse strings and iterate count times.
# Space Complexity : O(m+n) max size of the two stacks
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def decodeString(self, s: str) -> str:
        """
        Have a numberStack and character stack
        """
        res = ""
        numberStack = []
        charStack = []
        
        index = 0
        
        while index < len(s):
            if s[index].isdigit():
                count = 0
                while s[index].isdigit():
                    count = count * 10 + int(s[index])
                    index += 1 
                numberStack.append(count)
            
            elif s[index] == '[':
                charStack.append(res)
                res = ""
                index += 1
            
            elif s[index] == ']':
                temp = charStack.pop()
                freq = numberStack.pop()
                for i in range(0, freq):
                    temp += res
                    
                res = temp
                index += 1
            
            else: #its a character
                res += s[index]
                index += 1
        
        return res