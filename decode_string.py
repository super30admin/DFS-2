# Time Complexity: O( max K * n) - n - size of string
# Space COmplexity: O(m + n) - m - Number of letters and n - number of digits
class Solution:
    #     Implementation using two stacks and maintaing result strinf and current k
    def decodeString(self, s):
        numb = []
        st = []
        str_curr = ""
        k = 0
        #         iterate over string and depending on the 4 parameters
        #          1. ] - then pop the elements and form string
        #          2. [  - then append numbers and letters in stack
        #          3. number - calculate the number depending on previou snumber
        #          4. Alpha  - append it to current string
        # Evenetually return the result string
        for i in range(len(s)):
            if s[i].isnumeric():
                k = k * 10 + int(s[i])
            elif s[i] == '[':
                numb.append(k)
                st.append(str_curr)
                str_curr = ""
                k = 0
            elif s[i] == ']':
                t_n = int(numb.pop())
                curr_s = st.pop()
                for i in range(t_n):
                    curr_s = curr_s + (str_curr)

                str_curr = curr_s
            else:
                str_curr = str_curr + s[i]

        return str_curr







