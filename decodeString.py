#Space Complexity:O(N)
#Time Compleixty : O(maxK* N)
class Solution:
    
    def decodeString(self, s: str) -> str:
        return self.dfs(s, 0)
    
    def dfs(self, s, i):
         #Using DFS
        num = 0
        curr = []
        while(i < len(s)):
            
            if(s[i].isnumeric()):
                num = num* 10 + int(s[i])
                i += 1
            elif(s[i].isalpha()):
                curr.append(s[i])
                i += 1
            elif(s[i] == "["):
                decodedStr, i = self.dfs(s, i+1)
                decodedStr *= num
                curr.append(decodedStr)
                num = 0
            else:
                return ("".join(curr), i+1)
        return "".join(curr)
