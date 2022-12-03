#Time complexity: O(n) where n is length of final string
#Space complexity: O(h) where h is the number of opening brackets or depth of the stack

#Accepted on leetcode

#Approach
#Use a recursive approach (can be called DFS) where you keep track of current string and current count
#Each time opening bracket is encountered, recursively call the decode function to find string 'inside' bracket
#Each time closing bracket is encountered, return string formulated(inside that bracket): using this -> compute entire string 



class Solution:
    i = 0
    def decodeString(self, s: str) -> str:
        self.i = 0
        return self.decodeStr(s)

    def decodeStr(self, s):
        #base case
        curStr = ""
        num = 0
        #logic
        while self.i < len(s):
            curVal = s[self.i]
            if curVal.isnumeric():
                num = num * 10 + int(curVal)
                self.i += 1
            elif curVal.isalpha():
                curStr += curVal
                self.i += 1
            elif curVal == '[':
                self.i += 1
                decodedStr = self.decodeStr(s)
                newStr = ""
                for x in range(num):
                    newStr += decodedStr
                curStr += newStr
                num = 0
            else: # == ']'
                self.i += 1
                return curStr
                

        return curStr


        
        

