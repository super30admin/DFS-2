# Time Complexity : O(N)
# Space Complexity : O(number of nests)


class Solution:
    def decodeString(self, s: str) -> str:
        if len(s) == 0:
            return ""
        times = 0
        numstack = []
        stringsstack = []
        num = 0
        currstr = ""
        for c in s :
            if c.isdigit():
                num = num*10 + int(c) # changine string to int and trying to see ifs its larger digit
            elif c == "[" :
                numstack.append(num)
                stringsstack.append(currstr)
                num = 0
                currstr = ""
            elif c == "]": 
                times = numstack.pop()
                prevstr = stringsstack.pop()
                currstr = prevstr + currstr * times
                       
            else:
                currstr = currstr + c

        return currstr




            
        