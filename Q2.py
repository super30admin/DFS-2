############## Decode strings

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# using a stack add the number and the string into the stack. when we encounter opening we reset the value and when we encounter closing we create the string.

def decode_strings(s):
        stack = []
        curr_str = ''
        curr_num = 0

        for i in s:
            if i == "[":
                stack.append(curr_str)
                stack.append(curr_num)
                curr_str = ''
                curr_num = 0

            elif i == "]":
                num = stack.pop()
                prev_str = stack.pop()
                curr_str = prev_str + (curr_str * num)

            elif i.isdigit():
                curr_num = curr_num * 10 + int(i)
            else:
                curr_str += i
        return curr_str

