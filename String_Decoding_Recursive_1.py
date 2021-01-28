# Created by Aashish Adhikari at 7:12 PM 1/27/2021

'''
Time Complexity:
O(length of the decoded string)

Space Complexity:
~O(n)
'''


class Solution:


    def dfs(self, string,):
        # check if there is a substring at the front
        front_string = ""

        idx = 0
        while idx < len(string) and string[idx].isdigit() is False and string[idx] != "[" :

            front_string += string[idx]
            idx += 1

        # check if there is a multiplier for the second string
        new_multiplier = 0

        if idx < len(string):
            while string[idx].isdigit():

                new_multiplier = new_multiplier * 10 + int(string[idx])
                idx += 1

        # since we just encountered a number, we are guaranteed to get a "[" next
        pos = idx+1
        pointer = pos
        second_string_returned = ""
        square_brackets_ctr = 1
        if pointer < len(string):
            while square_brackets_ctr != 0:

                if string[pointer] == "[":
                    square_brackets_ctr += 1

                if string[pointer] == "]":
                    square_brackets_ctr -= 1


                pointer += 1

                if pointer == len(string):
                    break

            # at this point, the pointer points at "]"
            second_string_returned = self.dfs(string[pos:pointer-1])

        second_string = ""
        for times in range(new_multiplier):
            second_string += second_string_returned


        # dfs the remaining string and return the sum of all of these

        third_string = ""
        if pointer < len(string):
            third_string += self.dfs(string[pointer:])

        return front_string + second_string + third_string






    def decodeString(self, s: str) -> str:

        if len(s) == 0:
            return ""

        return self.dfs(s)
