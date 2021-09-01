class Solution:
    """
    Trick - keep track of nums and strings simultaneously
    TC - O(n)
    SC - O(n)
    """

    def decodeString(self, s: str) -> str:
        if not s:
            return ""
        num = 0
        currs = ""
        numStack = []
        stringStack = []

        for char in s:
            if char.isdigit():
                num = num * 10 + int(char)
            elif char == '[':
                numStack.append(num)
                stringStack.append(currs)
                num = 0
                currs = ""
            elif char == ']':
                times = numStack.pop()
                news = ""
                for i in range(times):
                    news += currs
                currs = stringStack.pop() + news
            else:
                currs += char

        return currs