class Solution:
    def decodeString(self, s: str) -> str:
        '''
        TC = O(N * M) where M = maximum number in the string 
        SC = O(stack)
        
        traverse through the string and store it to stack until you encounter the "]" 
            find the string and nuber by poping out the stack
            append decoded string in the stack
            repeat until we reach the end.
        '''
        
        
        
        
#         approach 2
        stack = []
        res = ""
        for i in s:
            if i == "]":
                temp = ""
                x = stack.pop()
                while x != '[':
                    temp = x + temp
                    x = stack.pop()
                val = ""
                while stack and stack[-1].isnumeric():
                    val =  stack.pop() + val
                ans = ""
                val = int(val)
                while val:
                    ans+= temp
                    val -= 1
                stack.append(ans)
            else: stack.append(i)
            
        return "".join(stack)
                
            
            