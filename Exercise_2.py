# Time Complexity: O(n*k) where n is the length of the string and k is the maximum number of nested brackets
# Space Complexity: O(n) for the stack elements
# Were you able to solve this on your own? Yes
# Any problem you faced while coding this: The logic was understandable, the implementation of the stack anf getting correct outputs
# took longer due to wrong values being popped from stack

class Solution:
    def decodeString(self, s: str) -> str:

        if len(s)<=1 or s is None:
            return s

        # stacks to keep track of numbers and strings
        num_stack = []
        str_stack = []

        curr_str = []
        curr_num = 0

        for x in s:
            # if the character is a digit, we build the current number
            # by multiplying the previous number by 10 and adding the current digit
            if x.isdigit():
                curr_num = curr_num * 10 + int(x)
                
            # if the character is an opening bracket, we push the current string and number onto their respective stacks
            # and reset the current string and number
            elif x == '[':

                str_stack.append(curr_str)
                num_stack.append(curr_num)

                curr_str = []
                curr_num = 0
            # if the character is a closing bracket, we pop the last string and number from their respective stacks
            # and repeat the current string the number of times specified by the popped number
            # then we append the repeated string to the last string popped from the string stack
            # and set the current string to this new string
            elif x == ']':

                parent_str = str_stack.pop()
                count = num_stack.pop()
                # print(f"{parent_str}: {count}")
                for k in range(count):
                    parent_str.extend(curr_str)

                curr_str = parent_str

            # if the character is a letter, we simply append it to the current string
            else:
                curr_str.append(x)

        return "".join(curr_str)
                 



        