class Solution:
    def decodeString(self, s: str) -> str:
        self.i = 0
        
        def helper():
            multi = 0
            sub = []
            while self.i < len(s):
                char = s[self.i]
                self.i += 1
                
                if char.isdigit():
                    multi = multi*10 + int(char)
                   
                elif char == '[':      
                    sub += multi * helper()
                    multi = 0
                    
                elif char == ']':
                    print(self.i,sub,multi)
                    return sub
                
                else:
                    sub.append(char)
            
            return "".join(sub)
        
        return helper()