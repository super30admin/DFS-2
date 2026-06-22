# O(n*k) time and space where k is the max repeat count and n is size of string
class Solution:
    def decodeString(self, s: str) -> str:
        numSt = []
        strSt = []
        currNum = 0
        currStr = []

        for i in range(len(s)):
            c = s[i]
            
            if c.isdigit():
                currNum = currNum * 10 + int(c)
            elif c == '[':
                # Push the current state to stacks to handle nesting
                strSt.append(currStr)
                numSt.append(currNum)
                
                
                currNum = 0
                currStr = []
            elif c == ']':
                cnt = numSt.pop()
                parent = strSt.pop()
                
                for k in range(cnt):
                    parent.extend(currStr)
                
                currStr = parent
            else:
                currStr.append(c)
                
        final_result = ''.join(currStr)
        return final_result

# Example run:
# sol = Solution()
# sol.decodeString("3[a2[c]]")