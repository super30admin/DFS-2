# Two Stacks
# TC: O(kn) k is max number in the string
# SC: O(m+n)
# Maintain two stacks for storing currString state and number state when encounter '['(anandon parent to process inner strings) and remove previously stored parent's string to append with currStr when we encounter ']'
class Solution:
    def decodeString(self, s: str) -> str:
        if s == None or len(s) == 0: return s
        currNum, currStr = 0, ""
        numStack, strStack = [], []
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                currNum = currNum *10 + int(c)
            elif c == '[':
                numStack.append(currNum)
                strStack.append(currStr)
                currNum, currStr = 0, ""
            elif c == ']':
                times = numStack.pop()
                newStr = times*currStr
                currStr = strStack.pop() + newStr
            else:
                currStr += c
        return currStr

# DFS
# TC: O(kn)
# SC: O(m+n)
# Unrap innermost strings and come back to solve previous recursive calls. Repeat until pointer reaches end of string.  
class Solution:
    # keep pointer global for child recursive calls to access current char under consideration. 
    i = 0
    def decodeString(self, s: str) -> str:
        if s == None or len(s) == 0: return s
        # Update currStr as and when child calls are resolved. currNum keeps the latest digit occurrence in the string.
        currNum, currStr = 0, ""
        # traverse through string
        while self.i < len(s):
            c = s[self.i]
            # update new digit, handle multiple digit numbers. Move pointer
            if c.isdigit():
                currNum = currNum *10 + int(c)
                self.i += 1
            # '['- make recursive call to decode inner string(newStr). while returning append currNum times child result to result string
            elif c == '[':
                self.i += 1
                inner = self.decodeString(s)
                newStr = currNum * inner
                currStr += newStr
                currNum = 0
            # recursive calls make return to parent call here! Notice here we are returning to form result string, not returning the result itself
            elif c == ']':
                self.i += 1
                return currStr
            # add the char to result string and move the pointer
            else:
                currStr+=c
                self.i += 1
        return currStr