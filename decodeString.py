class Solution:
    def decodeString(self, s: str) -> str:
        string_stack = [] 
        number_stack = []
        curr_num = 0 
        curr_str = ""
        for i in range(len(s)):
            if s[i].isnumeric():
                curr_num = curr_num*10 + int(s[i])
            elif s[i].isalpha():
                curr_str = curr_str + s[i]
            elif s[i] == '[':
                string_stack.append(curr_str  )
                curr_str = ""
                number_stack.append( curr_num )
                curr_num = 0 
            elif s[i] == ']':
                num = number_stack.pop()
                prev_str = string_stack.pop()
                curr_str = prev_str + ( curr_str*num )

        return curr_str
        
        '''
        Algorithm:
        Take 2 stacks - one for number and one for strings 
        maintain 2 variables - current_number , current_string 
        
        Initial state : current_string = "" , current_number = 0 
        result_string = ""
        
        compute current_number = current_number*10 + incoming number 
        
        if you encounter a opening bracket, 
        push current_number to the stack and reset current_number=0
        push current string to the stack and reset current string = ""
        
        start calculating the current_string
        
        if you encounter a closing bracket, 
        pop the number from the stack 
        multiply curr string the number times and 
        pop the string from the stack and append it 
        
        set current_string = "" , current_number = 0
        
        T = O(N)
        S = O(N)
        '''
        
