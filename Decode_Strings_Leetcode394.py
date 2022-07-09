class Solution:
    def decodeString(self, s: str) -> str:
        # Stack
        # Time Complexity = O(maxK * n)
        # Space complexity = O(n+m)
        stack = []
        for i in range(len(s)):
            if s[i] != "]":
                stack.append(s[i])
            else:
                substr = ""
                while stack[-1] != "[":
                    substr = stack.pop() + substr
                stack.pop()  # to remove "["
                k = ""  # remember k is also string
                while stack and stack[-1].isdigit():
                    k = stack.pop() + k
                stack.append(int(k) * substr)

        return "".join(stack)  # use join because otherwise o/p is ["aaa","bcbc"]

'''
        res = ""
        for i in range(len(s)):
            if s[i].isalpha():
                res += s[i]
            elif s[i].isnumeric():
                a = s[i]
                j = i+1
                while s[j].isnumeric():
                    a += s[j]
                    j += 1
                num = int(a)
                j += 1
                l = j
                count = 1
                while count != 0:
                    if s[j] == "[":
                        count += 1
                    elif s[j] == "]":
                        count -= 1
                    j += 1
                return res + num*self.decodeString(s[l:j-1]) + self.decodeString(s[j:])
        return res

'''