# time : 0(N^2)
#space  : 0(n)
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        result = ""
        n = len(s)
        if n == 0:
            return result
        
        string_stack = []
        i = 0
        while i < n :
            ch = s[i]
            if ch == ']':                
                decoded_str = ""                
                while string_stack[-1]!= '[':
                    decoded_str = string_stack.pop() + decoded_str

                string_stack.pop()                
                times = string_stack.pop()
                print("time sis ",times)
                decoded_str = decoded_str * times
                string_stack.append(decoded_str)
            
            else:
                if ch.isdigit():
                    temp = ch
                    i = i + 1
                    while s[i].isdigit():
                        temp += s[i]
                        i = i + 1
                    
                    string_stack.append(int(temp))
                string_stack.append(s[i])
            i = i +1
            
        while len(string_stack) != 0:
            result = string_stack.pop() + result  
            
        return result

            
        