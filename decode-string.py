# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s: return s
        curr = ""
        num, i = 0, 0
        while i < len(s):
            c = s[i]
            if c.isnumeric():
                num = num*10 + int(c)
                i += 1
            elif c == "[":
                i += 1
                inner = self.decodeString(s)
                child = ""
                for k in range(num):
                    child.append(inner)
                curr = curr.append(child)
                num = 0
            elif c == "]":
                i += 1
                return curr
            else:
                curr.append(c)
                i += 1
        return curr