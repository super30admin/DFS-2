class Solution:
    def decodeString(self, s: str) -> str:
        '''
        DFS Based Solution: Recursion
        Time Complexity: O(n)
        Space Complexity: O(n)
        
        '''
        i=0
        def decode():
            nonlocal i
            o = ""
            z = 0
            while(i<len(s)):
                if(s[i].isnumeric()):
                    z = z*10 + int(s[i])
                    i+=1
                elif(s[i]=="["):
                    i+=1
                    o += z*decode()
                    z=0
                elif(s[i]=="]"):
                    i+=1
                    return o
                else:
                    o = o + s[i]
                    i+=1
            return o
        
        return decode()
