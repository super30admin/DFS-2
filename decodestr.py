class Solution:
    
    """
    Description: Given an encoded string, return its decoded string (Example: "3[a]2[bc]" -> "aaabcbc")

    Time Complexicity: O(n*d) for For loop solution, and O()
    where, d is maximum value of a given digit in string "s"
    Space Complexicity: O(n) -> n is the length of string "s"

    Approach:
    Using for loop:
    1 start with empty lists (one for numbers and one for strings) starting with num = 0 and string = ""
    2 for each opening bracket, append values of digits/letters within each stack, and restart num and string as in #1
    3 for each closing bracket, pop the stack items and update the string from the deepest level

    """      
        
    def decodeString(self, s: str) -> str:
        
        if s == None or len(s) == 0: return s
        
        str_stk = []; num_stk = []
        num = 0; string = ""

        for item in s:
            if item.isdigit():
                num = num*10 + int(item)
            elif item == "[":
                num_stk.append(num)
                str_stk.append(string)
                num = 0; string = ""
            elif item == "]":
                curr_num = num_stk.pop()
                curr_str = str_stk.pop()
                string = curr_str + curr_num*string
            else:
                string += item
                
        return string
        
