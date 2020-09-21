# Time Complexity : O(n)
# Space Complexity : O(n)  using 1 stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

def decodeString(self, s):
        stack = []
        curr = ''
        curr_num = 0
        for char in s:
            if char == '[':
                #for every open bracket append the current string, number and reset
                stack.append(curr)
                stack.append(curr_num)
                curr = ''
                curr_num = 0
            elif char == ']':
                #for every close bracket pop string and number and create a string until then
                num = stack.pop()
                prev = stack.pop()
                curr = prev + num * curr
            elif char.isdigit():
                #for every digit just update current number
                curr_num = 10*curr_num + int(char)
            else:
                #for every digit just update current string
                curr = curr + char
        return curr