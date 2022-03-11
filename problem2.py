TC:O(n)
SC:O(m) where m is order of nested bracket

class Solution:
    def decodeString(self, s: str) -> str:
        if s is None or len(s) == 0:
            return 0

        numStack = []
        strStack = []
        num = 0
        _str = ""

        for c in s:
            if c.isdigit():
                num = num *10 + ord(c) - ord("0")

            elif c == "[":
                numStack.append(num)
                strStack.append(_str)
                num = 0
                _str = ""

            elif c == "]":
                number = numStack.pop()
                strPopped = strStack.pop()
                _str = _str * number
                _str = strPopped + _str
            else:
                _str += c

        return _str


