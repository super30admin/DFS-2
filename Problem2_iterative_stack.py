# Time complexity : O(max(length of char, max number in string))
# Space complexity : O(max(length of char*max number in string))
# Leetcode : Solved and submitted
class Solution:
    def decodeString(self, s):
        # initalize empty string and variables as 0 to use for calculations
        currStr = ds = baby = ''
        currNum = 0
        # numSt is for number stack and strSt is for string stack
        numSt = []
        strSt = []
        times = 0
        # traverse over the whole string
        for ch in s:
            # if we find a digit from the left, then find the number to which we have to multiply
            if ch.isdigit():
                currNum = currNum * 10 + ord(ch) - ord('0')
            # if we find an opening brace, then append the stack with the current string and number we have and rest it to default    
            elif ch == '[':
                numSt.append(currNum)
                strSt.append(currStr)
                currStr = ''
                currNum = 0
            # if we find a closing brace, then we need to multiply the string with the num
            elif ch == ']':
                times = numSt.pop()
                # this for loop is to iterte over the string and store it in another variable
                for i in range(times):
                    baby += currStr
                # here we add the previous string at the start which is in stack and then the iterated multipled string
                currStr = strSt.pop() + baby
                # reset the temp variable otherwise it would be appened again
                baby = ''
            else:
                # if none, then simply add the char to the currStr
                currStr += ch
        # at last, we return the completed decoded string
        return currStr
