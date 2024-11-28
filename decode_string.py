class Solution:
    def decodeString(self, s: str) -> str:
        stackstr = []
        stacknum = []
        num = 0
        strs = ""

        for char in s:
            if char.isdigit():
                number = int(char)
                num = num * 10 + number
            elif char == '[':
                stackstr.append(strs)
                stacknum.append(num)
                num = 0
                strs = ""
            elif char == ']':
                times = stacknum.pop()
                repeated_str = strs * times
                # Add the repeated string to the previous string
                strs = stackstr.pop() + repeated_str
            else:
                strs = strs + char
        return strs
