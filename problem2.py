# Time Complexity : O(n)
# Space Complexity : O(N) 

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach
def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if s == "":
            return ""

        if '0' < s[0] and s[0] <= '9':
            stack, start,end = ['['], s.index('[')+1,s.index('[')+1
            while stack:
                if s[end] == '[':
                    stack.append('[')
                elif s[end] == ']':
                    stack.pop()
                end += 1
            return self.decodeString(s[start:end - 1]) * int(s[0:start-1]) + self.decodeString(s[end:])
        else:
            return s[0] + self.decodeString(s[1:])