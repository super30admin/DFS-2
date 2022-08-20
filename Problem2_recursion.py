# Using recursion
# Time complexity : O(max(length of char, max number in string))
# Space complexity : O(max(length of char*max number in string))
class Solution:
    # global variable to keep track of the position of the char in string
    i = 0
    def decodeString(self, s):
        times = 0
        currNum = 0
        currStr = ''
        n = len(s)
        ch = ''
        # traversing over the string
        while self.i < n:
            ch = s[self.i]
            # check for digit, to get the times to be multiplied
            if ch.isdigit():
                currNum = currNum * 10 + ord(ch) - ord('0')
                self.i += 1
            # if we find an opening brace, then we recursively call the function with the string
            elif ch == '[':
                self.i += 1
                baby = self.decodeString(s)
                
                # multiply the string we got until we get an ending brace and then add it to the current string
                currStr = currStr + baby * currNum
                
                # reset the number
                currNum = 0
                
                # when finding a closing brace, increment the index and return the current string that we have till now
            elif ch == ']':
                self.i += 1
                return currStr
            else:
                # if all condition above doesn't work, that mean we have characters to add to the current string
                currStr += ch
                self.i += 1
        # at the end, simply return the current string
        return currStr
