# Time Complexity: O(n)
# Space Complexity: O(m+n)

class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        curr=""
        num=0
        strStack=[]
        numStack=[]
        for i in range(len(s)):
            if s[i].isdigit():
                num = num*10 + int(s[i])
            elif s[i].isalpha():
                curr += s[i]
            elif s[i] =="[":
                numStack.append(num)
                num=0
                strStack.append(curr)
                curr=""
            elif s[i]=="]":
                count = numStack.pop()
                newstr = strStack.pop()
                curr = newstr + count*curr
        return curr
