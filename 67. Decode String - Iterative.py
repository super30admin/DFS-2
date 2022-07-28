class Solution:
    def decodeString(self, s: str) -> str:
        if s is None or len(s) == 0:
            return ""
        curr = [""]
        num = 0
        numst = []
        strst = []

        for i in range(len(s)):
            c = s[i]
            # print(curr, "curr")
            if c.isdigit():
                # print(c, 'c.isdigit()')
                num = num * 10 + int(c)
            elif c == '[':
                numst.append(num)
                # print(numst, "numst")
                # print(curr, c, "curr")
                strst.append("".join(curr))
                # print(strst, "strst")
                curr = [""]
                num = 0
            elif c == ']':
                times = numst.pop()
                newstr = []
                for i in range(times):
                    newstr.append(''.join(curr))
                # print(newstr,"newstr", strst, "strst")
                curr = [(strst.pop() + "".join(newstr))]
                # print(curr,"new curr")
            else:
                curr.append(c)
                # print(curr,c, "c")
        print(''.join(curr), "curr")
        return "".join(curr)


if __name__ == "__main__":
    obj = Solution()
    obj.decodeString("2[abc]3[cd]ef")

# BFS
# Time complexity : O(n)
# Space complexity : O(n)
# Did this code successfully run on Leetcode? Yes
# Any problem you faced while coding this? No
