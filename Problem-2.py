# Time Complexity :O(length of result string)
# Space Complexity :O(length of result string)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        #one stack for digits other for alphabets
        counts = []
        string = []
        #sol and a count that is use to concatinate number
        res = ""
        count = ""
        #loop through the string
        for l in s:
            #if you find a digit add it to the count string
            if l.isdigit():
                count+=l
            # if you find alpha put it to res
            elif l.isalpha():
                res+=l
            #if you find a [ append count as intiger and res to string stack and make both res and count empty strings
            elif l == '[':
                counts.append(int(count))
                string.append(res)
                res = ""
                count = ""
            # if you find ] add string to res count times
            else:
                res = string.pop() + res * counts.pop()
        #return result
        return res