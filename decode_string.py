'''
Time complexity : O(m*n) m-> max(independent sums all over the arrays)
Space Complexity : O(m*n)
Also O(L) --> Length of the Output.
'''
class Solution:
    def decodeString(self, s: str) -> str:

        num_stack = []
        str_stack = []
        curr_str = ''
        curr_num =0

        for i in s:

            if i.isdigit():
                i=int(i)
                curr_num = curr_num*10+i

            elif i.isalpha()==True:
                curr_str = curr_str+i

            elif i=='[':
                num_stack.append(curr_num)
                str_stack.append(curr_str)

                curr_num = 0
                curr_str =''

            else:
                pop_num = num_stack.pop()

                curr_str = curr_str*pop_num

                pop_str = str_stack.pop()
                curr_str = pop_str+curr_str
        return curr_str
