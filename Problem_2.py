# // Time Complexity : O(n)
# // Space Complexity : O(n)
class Solution:
    def decodeString(self, s: str) -> str:
        
        num = ''
        stack = []
        string = ''
        for i in s:    
            if(i.isdigit()):
                num+=i
            if(i == '['):
                stack.append([string,num])
                num,string = '',''
            if(i.isalpha()):
                string+=i
            if(i == ']'):
                temp = stack.pop(-1)    
                temp[0] += string * int(temp[1]) 
                string = temp[0]
               
        return(string)




        