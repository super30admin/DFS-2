class Solution:
    def decodeString(self, s: str) -> str:
        
        stack=[]
        
        final=""
        num=""
        
        for i in range(len(s)):
           
            
            if s[i].isalpha():
                final+=s[i]
            elif s[i].isnumeric():
                num+=s[i]
            elif s[i]=="[":
                stack.append(num)
                stack.append(final)
                num=""
                final=""
            elif s[i]=="]":
                parent=stack.pop()
                num1=int(stack.pop())
                final=parent+num1*final
        print(stack)
        return final
        #Time O(n)-number of elements in string
        #Space O(n)
