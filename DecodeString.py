class Solution:
    def decodeString(self, s: str) -> str:
        if len(s)==0 or s==None:
            return ""
        pairStack=[]
        currStr=""
        currNum=0
        for i in range(len(s)):
            if s[i].isdigit():
                currNum=10*currNum+int(s[i])
            elif s[i]=="[":
                pairStack.append([currNum,currStr])
                currNum=0
                currStr=""
            elif s[i].isalpha():
                currStr+=s[i]
            else:
                temp=pairStack.pop()
                newString=""
                for i in range(int(temp[0])):
                    newString+=currStr
                currStr=temp[1]+newString
        return currStr
                
            
Space Complexity is O(n)
Time Complexity is O(n)
