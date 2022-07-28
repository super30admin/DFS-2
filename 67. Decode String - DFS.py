class Solution:
    i = 0

    def decodeString(self, s: str) -> str:
        if s is None or len(s) == 0:
            return ""
        # self.i = 0  # got error cause of this
        num = 0
        curr = ['']
        # print(self.i)
        while self.i < len(s):
            # print(s[self.i])
            c = s[self.i]
            if c.isdigit():
                num = num * 10 + int(c)
                self.i += 1
            elif c == '[':
                self.i += 1
                decoded = self.decodeString(s)
                newStr = []
                for k in range(num):
                    newStr.append(decoded)
                # print(newStr, "newStr")
                curr.append("".join(newStr))
                num = 0
            elif c == ']':
                self.i += 1
                return ''.join(curr)
            else:
                curr.append(c)
                self.i += 1
        print(''.join(curr), "curr")
        return ''.join(curr)


if __name__ == "__main__":
    obj = Solution()
    obj.decodeString("2[abc]3[cd]ef")

# BFS
# Time complexity : O(n)
# Space complexity : O(n)
# Did this code successfully run on Leetcode? Yes
# Any problem you faced while coding this? yes. Was initializing "self.i = 0" every time recursion call was happening and it returned "Maximum Recursion Depth Exceeded" error.
# removed it and error was solved.
