"""
394. Decode String
Time Complexity - O(n + sum of integer in str)
Space Complexity - O(no of numbers + sum of length of string
Loop is iterating throughout the string and performing following checks
1.Check if character at that index is digit if yes,then store its value in curr_num until [ is not observed
2. When [ is observed push values of curr_str and curr_int in their respecive stacks and reinitialize these variables
3. When ] is observed first pop value from integer stack and make the str as per its integer iteration number then pop str fron string stack and append them
4. curr_str stores string value occuring
return curr_str"""
class Solution:
    def decodeString(self, s: str) -> str:
        if s == None or len(s) == 0:
            return s
        stack_str = []
        stack_int = []
        
        curr_str = ""
        curr_num = 0
        
        for i in range(len(s)):
            #Check if character at that index is digit if yes,then store its value in curr_num until [ is not observed
            if s[i].isdigit():
                curr_num = 10*curr_num + (ord(s[i]) - ord('0'))
            #When [ is observed push values of curr_str and curr_int in their respecive stacks and reinitialize these variables
            elif s[i] == '[':
                stack_str.append(curr_str)
                stack_int.append(curr_num)
                curr_str = ""
                curr_num = 0
            # When ] is observed first pop value from integer stack and make the str as per its integer iteration number then pop str fron string stack and append them
            elif s[i] == ']':
                popped = stack_int.pop()
                temp = ""
                for j in range(popped):
                    temp += curr_str
                curr_str = stack_str.pop() + temp
            #curr_str stores string value occuring
            else:
                curr_str = curr_str+s[i]
        return curr_str
                
                
        