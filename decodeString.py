# Time Complexity : O(n) where n is the length of the string
# Space Complexity : O(n) for the stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        current_num = 0
        current_string = ""
        for i in range(len(s)):
            if s[i] == "[":  # when encountering '['
                stack.append(current_num)  # update stack
                stack.append(current_string)
                current_string = ""  # change it back
                current_num = 0
            elif s[i] == "]":  # when encountering end parenthesis
                old_string = stack.pop()  # pop out the string which was appended last into stack
                to_repeat = stack.pop()  # pop out the number of times to repeat
                current_string = old_string + to_repeat * current_string  # update current string
            elif s[i].isdigit():
                current_num = current_num * 10 + int(s[i])
            else:
                current_string += s[i]
        return current_string


r = Solution()
s = "3[a]2[bc]"
print("decoded string1:", r.decodeString(s))
s1 = "2[abc]3[cd]ef"
print("decoded string2:", r.decodeString(s1))
