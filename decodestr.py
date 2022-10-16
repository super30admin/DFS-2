#time complexity:o(n)
#space complexity:o(2n) or 0(n)
#passed all cases on LeetCode:yes
#difficulty faced:
# comments:in the code
#https://leetcode.com/problems/decode-string/description/

class Solution:
    def decodeString(self, s: str) -> str:

        currstr = ''
        num = ''

        numstack = []
        strstack = []

        for i, val in enumerate(s):

            if val.isdigit():
                num += val     #concat as a string

            elif val == '[':
                numstack.append(int(num))
                strstack.append(currstr)
                num = ""
                currstr = ""
            #currstr already has curr val so pop tos from num stack which had how many times this currstr has to be multiplied, append it with tos of strstack but be mindful of append sequence    
            elif val == ']':
                currstr = strstack.pop() + numstack.pop()*currstr 
            #this else means we are inside sq brackets hence just appending to the currstr    
            else:
                currstr += val

        return currstr