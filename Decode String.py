# time complexity is o(n), where n is the size of the input
# space complexity is o(h), where 'h' is the number of '[' in the input.
class Solution:
    def decodeString(self, s: str) -> str:
        strstack = list()
        numstack = list()
        currstr = list()
        currstr.append('')
        currnum = 0
        for st in s:
            if(st.isdigit()):
                currnum = currnum*10 + int(st)
                # numstack.append(int(st))
            elif(st == '['):
                k = ''.join(i for i in currstr)
                strstack.append(k)
                currstr = list()
                currstr.append('')
                numstack.append(currnum)
                currnum = 0   
            elif(st == ']'):
                popnum = numstack.pop()
                k = ''.join(i for i in currstr)
                newstr = ''
                for i in range(popnum):
                    newstr += k
                parent = strstack.pop()
                currstr = list()
                currstr.append('')
                currstr.append(parent + newstr)   
            else:
                currstr.append(st)
                # strstack.append(st)
        return ''.join([k for k in currstr])
                
        
        