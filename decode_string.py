class Solution:
    def decodeString(self, s: str) -> str:
        my_stack=[]
        
        for i in range(len(s)):
            if s[i]!="]":
                my_stack.append(s[i])
            else:
                substr=""
                while my_stack[-1] !="[":
                    substr=my_stack.pop()+substr
                    
                my_stack.pop()
                
                k="" 
                while my_stack and my_stack[-1].isdigit():
                    k=my_stack.pop()+k
                
                my_stack.append(int(k)*substr)
            
        return "".join(my_stack)
                    
                
            
        