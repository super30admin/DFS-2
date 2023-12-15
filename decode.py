class Solution:
    def decodeString(self, s: str) -> str:
        nums = []
        string = []
        currNum = 0
        currStr = ""

        for i in s:
            if i.isdigit():
                currNum = 10 * currNum + int(i)
            elif i == '[':
                nums.append(currNum)
                string.append(currStr)
                currNum = 0
                currStr = ""
            elif i == ']':
                cnt = nums.pop()
                temp = cnt * currStr
                temp2 = string.pop()
                currStr = temp2 + temp
            else:
                currStr += i

        return currStr


