# Time Complexity : O(n * k)
# Space Complexity : O(n * k)
# Did this code successfully run on Leetcode : Yes  
# Any problem you faced while coding this : No
# Explaianation: This code decodes strings encoded in the form like "3[a2[c]]" using stacks. It uses numSt to store repeat counts and strSt to store partial strings before encountering a [; when a ] is found, it pops from both stacks, repeats the substring, and attaches it to the parent string. By the end, currStr holds the fully decoded characters, which are joined into the final result.


# Your code here along with comments explaining your approach

class Solution:
    #TC: O(n * k)    SC: O(n * k)
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
                strSt.append(currStr)
                numSt.append(currNum)
                currNum = 0
                currStr = []
            elif c == ']':
                cnt = numSt.pop()
                parent = strSt.pop()

                for i in range(cnt):
                    parent.extend(currStr)
                currStr = parent
            else:
                currStr.append(c)
            
        return ''.join(currStr)