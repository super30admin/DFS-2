class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
    def __init__(self):
        self.ind = 0

    def decodeString(self, s):
        stAlpha = []
        stNum = []
        num = ''
        alpha = ''
        for c in s:
            if ord('0') <= ord(c) <= ord('9'):
                num += c
            if ord('a') <= ord(c) <= ord('z'):
                alpha += c
            # push parent and multiplier in stack and reset them
            if c == '[':
                stNum.append(num)
                stAlpha.append(alpha)
                num = ''
                alpha = ''
            # repeat the string 'k' times and append parent
            if c == ']':
                k = int(stNum.pop())
                newAlpha = ''
                for _ in range(k):
                    newAlpha += alpha
                alpha = newAlpha
                parent = stAlpha.pop()
                alpha = parent + alpha

        return alpha

    """
    Ideation- DFS O(output-string) time and O(1) space
    Notice where the repetition will happen, anything inside '[' will start a new baby and ']' will return the baby
    to parent. Call DFS on that.
    
    Also, to keep the string moving and not reset its own index 'i', we need to declare it in global variable
    
    Also, beware of index 'i' changing inside while loop can cause index out of range, handle that.
    """

    def decodeString1(self, s):
        num = ''
        alpha = ''
        while self.ind < len(s):
            if ord('0') <= ord(s[self.ind]) <= ord('9'):
                num += s[self.ind]
                self.ind += 1
                # continue statements after every if so we don't go out of index since it's a while loop
                continue
            if ord('a') <= ord(s[self.ind]) <= ord('z'):
                alpha += s[self.ind]
                self.ind += 1
                continue
            if s[self.ind] == '[':
                self.ind += 1
                # call recursion on baby - alpha and num is for parent
                decodedString = self.decodeString1(s)
                # multiplier will be current num
                temp = ''
                for _ in range(int(num)):
                    temp += decodedString
                # alpha is the parent, append with decoded string multiplied
                alpha = alpha + temp
                # reset num because current num was for baby which we have finished
                num = ''
                continue
            if s[self.ind] == ']':
                self.ind += 1
                # baby finished, return it to the caller
                return alpha

        # because when the while loop finishes, final alpha (result) built up needs to return
        return alpha



inp = "2[abc]3[cd]ef"
result = Solution().decodeString1(inp)
print(result)