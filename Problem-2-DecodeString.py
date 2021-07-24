class Solution:
    def decodeString(self, s) :
        numstack = []
        strstack = []
        # st.append("inf")
        currstr = ""
        num = 0

        for i in range(len(s)):
            if s[i].isnumeric():
                num = num * 10 + int(s[i])
            elif s[i] == '[':
                numstack.append(num)
                strstack.append(currstr)
                currstr = ""
                num = 0
            elif s[i] == ']':
                times = int(numstack.pop())
                cstr = strstack.pop()
                for i in range(times):
                    cstr = cstr + currstr

                currstr = cstr
            else:
                currstr = currstr + s[i]

        return currstr

#Time complexity:O(kn), where k is the max value of the numbers in the string
#Space complexity:O(kn), where k is the max value of the numbers in the string
