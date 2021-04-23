class Solution:
    def decodeString(self, s: str) -> str:
        
        if(s == ''):
            return ''
        
        numstack = []
        stringstack = []
        num = 0
        currentstring = ''
        for i in range(len(s)):
            
#             print (f'numstack: {numstack}')
#             print (f'stringstack: {stringstack}')
#             print (f'currentstring: {currentstring}')
            
            if s[i].isdigit():
                num = num*10 + int(s[i])
            
            elif s[i] == '[':
                
                numstack.append(num)
                stringstack.append(currentstring)
                num = 0
                currentstring = ''
            
            elif s[i] == ']':
                
                times = numstack.pop()
                temp_s = ''
                #print (times)
                for j in range(times):
                    temp_s += currentstring
                
                currentstring = stringstack.pop() + temp_s
            else:
                currentstring += s[i]
        
        return currentstring
                
