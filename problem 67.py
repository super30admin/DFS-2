# Problem2 (https://leetcode.com/problems/decode-string/)

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach


class Solution:
    def decodeString(self, s: str) -> str:
        numst = []
        strst = []

        currstr = []
        currnum = 0

        for i in range(len(s)):
            ch = s[i]
            if ch.isdigit():
                currnum = currnum*10 + ord(ch) - ord('0')
            elif (ch == '['):
                numst.append(currnum)
                strst.append(currstr)
                currnum = 0
                currstr = []

            elif (ch == ']'):
                cnt = numst.pop()
                parent = strst.pop()
                #baby = []
                baby= ''.join(currstr) * cnt
                print(baby)
                
                currstr = parent + [baby]
                print(currstr)

            else:
                currstr.append(ch)
        
        return ''.join(currstr)
