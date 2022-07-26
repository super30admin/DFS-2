class Solution:
    def decodeString(self, s: str) -> str:
        
        string=''
        current_stack=[]
        number_stack=[]
        number=0
        
        for i in s:
            if i.isnumeric()==True:
                number=number*10+int(i)
                
            elif i=='[':
                number_stack.append(number)
                current_stack.append(string)
                string=""
                number=0
                
            elif i==']':
                new_string=current_stack.pop()
                count=number_stack.pop()
                
                for i in range(count):
                    new_string+=string
                string=new_string
                
            else:
                string+=i
                
        return string
				
        
                        
                        
                    
            
        
        
        
        