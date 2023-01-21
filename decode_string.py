# Time Complexity :
# O(Lenght of return string)

# Space Complexity :
# O(Length of return string)

# Did this code successfully run on Leetcode :
#Yes

#We iterate through each character - We have 4 cases - if we encounter a number, we increase it based on previous number we had
#If we encounter a character - then we add it to our current string.
#If we encounter a opening brace, we recursively call the function on the rest of the string (it's taken care by global i). When we get the return from the recursive call, we multiply it by the number of curr_number of times and append it to current string
#If we encounter a closing brace - we just return the current string

class Solution:
    def decodeString(self, s: str) -> str:
        self.i = 0 
        return self.dfs(s)

    def dfs(self,s):
        curr_string = ''
        curr_number = 0
        while self.i < len(s):
            char = s[self.i]
            if char.isdigit(): 
                curr_number = curr_number *10 + int(char)
                self.i += 1

            elif char == '[':
                self.i += 1
                new_string = self.dfs(s)
                curr_string += new_string*curr_number
                curr_number = 0
            
            elif char == ']' :
                self.i += 1
                return curr_string

            else :
                self.i += 1
                curr_string += char

        return curr_string
