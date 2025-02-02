# Time Complexity : O(n), n is the no of elements in the given char array/string
# Space Complexity : O(h), where h is the no of nested levels in the given string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# since we need to process the inner most level first, and delay the processing out outer levels, we need to use a stack
# using 2 stacks - numstack and strstack
# currstr is a list that stores curent list
# so we traverse the given input string for every character
# and we have 4 possibilities of a character in the string - digit, [, ], and any other char

class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if s is None:
            return ""
        
        # we need a list for the final string (like string builder in java)
        currstr  = []

        # and we need a string stack
        strstack = []

        num = 0
        # num stack
        numstack = []

        for i in range(len(s)):
            c = s[i]
            # now we check if this character is a digit
            if c.isdigit():
                # store in num
                num = num * 10 + int(c) 
            
            elif c == '[':
                # stack push
                numstack.append(num)
                strstack.append(currstr)
                # revert the string and num
                num = 0
                currstr = []

            elif c == ']':
                # stack pop from numstack
                times = numstack.pop()
                # make a new string for this level of string
                newstring = []
                for i in range(times):
                    # repeat the current str times no of times
                    newstring.append("".join(currstr))

                # then pop from str stack
                oldstring = strstack.pop()

                # and append new string to the popped string to get the current string
                oldstring.extend(newstring)
                currstr = oldstring
            
            else:
                # any other character is a string character
                # append it to the current string
                currstr.append(c)

        # parallel to currstr.toString() in java
        # return the current string 
        return "".join(currstr)

        