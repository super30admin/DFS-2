"""
Problem : 2

Time Complexity : O(y) //y=length of output string
Space Complexity : O(n) //n=length of input string

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

initializing a stack to store numbers before each string starts and string stack to store string after square brackets
calculating the number, after opening bracked encountered, storing into number stack, storing the previous string to the string stack
calculating the current string and as closed braces are enountered, decoding the string and concatenating it to previous string an making it as current string
returning the current string at the end

"""

# Decode string


class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        strst=[]
        numst=[]
        currnum=0
        currstr=""

        for i in range(len(s)):
            # currstr=""
            c=s[i]
            if c.isdigit():
                currnum=currnum*10+int(c)
                
            elif c=='[':
                numst.append(currnum)
                strst.append(currstr)
                currstr=""
                currnum=0
            elif c==']':
                count=numst.pop()
                newstr=""
                for i in range(count):
                    newstr+=currstr
                currstr=strst.pop()+newstr
                                
            else:
                currstr+=c

        return currstr
