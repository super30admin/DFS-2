'''
time complexity: O(len(output))
space complexity: O(len(output))
'''
class Solution:
    def decodeString(self, s: str) -> str:
        if s == None or s == "": return ""
        strSt = deque([])
        numSt = deque([])
        currStr = ""
        num = 0
        
        for i in range(len(s)):
            c = s[i]
            if(c.isnumeric()):
                num = num*10 + int(c)
            elif(c=="["):
                numSt.append(num)
                strSt.append(currStr)
                currStr = ""
                num = 0
            
            elif(c=="]"):
                count = numSt.pop()
                sb = currStr*count
                parent = strSt.pop()
                currStr = parent+sb
                
            else: 
                currStr = currStr + c
        return currStr