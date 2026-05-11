class Solution:
    def decodeString(self, s):
        str_st = []
        num_st = []
        curr_num = 0
        curr_str = ""
        for c in s:
            if c.isdigit():
                curr_num = curr_num * 10 + int(c)
            elif c == "[":
                str_st.append(curr_str)
                num_st.append(curr_num)
                curr_str = ""
                curr_num = 0
            elif c == "]":
                repeat = num_st.pop()
                curr_str = str_st.pop() + curr_str * repeat
            else:
                curr_str += c
        return curr_str
