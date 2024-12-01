"""
TC: O(k*n ) k is max number of times the char needs to be repeated, n is length of string
SP: O(k*n) to form the output string

"""
class Solution:
    def decodeString(self, s: str) -> str:
        def dfs(i):
            currStr = ""
            currNum = 0
            while i < len(s):
                if s[i].isdigit():
                    currNum = currNum * 10 + int(s[i])
                elif s[i] == "[":
                    i, nestedStr = dfs(i + 1)  # Decode nested substring
                    currStr += currNum * nestedStr
                    currNum = 0  # Reset after use
                elif s[i] == "]":
                    return i, currStr  # Return updated index and substring
                else:
                    currStr += s[i]
                i += 1
            return currStr  # Top level case if no unmatched brackets
        
        return dfs(0)
