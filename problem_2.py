# Time O(N)
# Space O(N)
class Solution:
    def decodeString(self, s: str) -> str:
        if not s:
            return ""
        stack = []
        cur_sum = 0 
        cur_str = ""
        for i in s:
            if i == '[':
                stack.append(cur_sum)
                stack.append(cur_str)

                cur_sum = 0 
                cur_str = ""
            elif i == ']':
                old_str = stack.pop()
                rep = stack.pop()

                cur_str = old_str + rep * cur_str
            elif i.isdigit():
                cur_sum = 10*cur_sum + int(i)
            else:
                cur_str += i
        return cur_str