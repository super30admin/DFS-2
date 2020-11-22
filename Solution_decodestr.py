class Solution_decodestr:
    def decodeString(self, s: str) -> str:
        st = []
        for char in s:
            if char == ']':
                sub = st.pop()
                while sub[0] != '[':
                    sub = st.pop() +sub
                digit = st.pop()
                while st and st[-1].isdigit():
                    digit = st.pop() +digit
                st.extend(sub[1:] * int(digit))
            else:
                st.append(char)
        return ''.join(st)