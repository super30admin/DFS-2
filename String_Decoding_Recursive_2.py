# Created by Aashish Adhikari at 9:29 PM 1/27/2021

'''
Time Complexity:
O(n . k) where n is the length of the input string and k is maximum number that was given in the input string.
~ O(length of the decoded string)

Space Complexity:
~O(n) where n is the length of the input string. In the worst case, we will have a[b[c[.... type scenario and we put each of the characters in the
recursive stack before moving on to the child.
'''


class Solution:


    def dfs(self, s):


        multiplier = 0
        current_string = ""


        while self.global_num < len(s):




            if s[self.global_num].isdigit():
                while s[self.global_num].isdigit():
                    multiplier = multiplier * 10 + int(s[self.global_num])
                    self.global_num += 1




            elif s[self.global_num] == "[":

                self.global_num += 1
                innerString = self.dfs(s)
                actual_inner_string = ""
                for index in range(multiplier):
                    actual_inner_string += innerString
                multiplier = 0
                current_string = current_string + actual_inner_string

            elif s[self.global_num] == "]":
                # means a substring ended
                self.global_num += 1
                return current_string

            else:
                current_string += s[self.global_num]
                self.global_num += 1




        return current_string


    def decodeString(self,s):
        if len(s) == 0 or s is None:
            return s
        self.global_num = 0
        return self.dfs(s)







