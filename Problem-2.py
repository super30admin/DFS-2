#Approach
#go through depth of each inner string and recurse back. recursion is clled when we encounter "[" if ] is there call the

#Complexities
#Time: O(L*M)
#space : O(1)


class Solution:
    def __init__(self):
        self.index = 0

    def decodeString(self, s: str) -> str:

        current_digit = 0
        curr_str = ""

        while (self.index < len(s)):
            char = s[self.index]
            self.index += 1
            if char.isdigit():
                current_digit = 10 * current_digit + int(char)
            elif (char == '['):
                baby_str = self.decodeString(s)
                for i in range(current_digit):
                    curr_str += baby_str

                current_digit = 0
            elif (char == ']'):
                return curr_str
            else:
                curr_str += char

        return curr_str
s = Solution()
s.decodeString("2[a3[b2[c]]]2[g]")




