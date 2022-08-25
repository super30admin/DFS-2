"""
Time Complexity : O(len(currString))
Space Complexity : O(no of bracket pairs)
"""
class Solution:
    def decodeString(self, s: str) -> str:
        
        def getrep(stack):
            count = ""
            repstr = ""
            
            while len(stack)>0 and stack[-1]!="[":
                repstr= stack.pop()+repstr
                
            if len(stack)>0 and stack[-1]=="[":
                stack.pop()
                
            while stack and not stack[-1].isalpha() and stack[-1]!="[":
                count = stack.pop()+count
                
            return int(count), repstr
            
        
        stack = []
        for c in s:
            if c == "]":
                count, repstr = getrep(stack)
                stack.append(repstr*count)
                
            else:
                stack.append(c)
        return "".join(stack)
        
