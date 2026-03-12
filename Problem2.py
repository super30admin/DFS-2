# https://leetcode.com/problems/decode-string/description/

# Time Complexity: O(m*n)
# Space Complexity: O(h)

class Solution:
    def decodeString(self, s: str) -> str:

        st = []
        num = []
        currNum = 0
        currStr = ""

        for i in s:
            c = i

            if c.isdigit():
                currNum = currNum * 10 + int(c)
            elif c == "[":
                # push them to the stack
                num.append(currNum)
                st.append(currStr)

                currNum = 0
                currStr = ""
            elif c == "]":
                count = num.pop()
                parent = st.pop()
                baby = ""
            
                for i in range(int(count)):
                    baby = baby + currStr

                parent = parent + baby
                currStr = parent
            else:
                currStr = currStr + c

        return currStr