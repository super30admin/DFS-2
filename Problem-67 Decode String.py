# 394. Decode String
# https://leetcode.com/problems/decode-string/

# Logic: Iterate the given string and push into stack everything except closing bracket. 
# When closing bracket is reached, pop till the opening bracket, and generate the current string. 
# Pop the integer and make count. Multiply count with current string, and push back to stack.

# Time Complexiety: O(n.maxk) k is the integer count
# Space Complexiety: O(n)

class Solution:
    def decodeString(self, s: str) -> str:
        stack = list()
        
        for i in s:
            if i != ']':
                stack.append(i)
            else:
                x = stack.pop()
                temp = [x]
                count = []
                
                while x != '[':
                    x = stack.pop()
                    
                    if x != '[':
                        temp.append(x)                
                
                temp.reverse()
                
                while stack and stack[-1].isdigit():
                    count.append(stack.pop())
                    
                count = int("".join(count[::-1]))
                
                temp = temp * count
                
                for j in temp:
                    stack.append(j)
        
        return "".join(stack)