def decodeString(self, s: str) -> str:
    strstack=[]
    numstack=[]
    curr_num=0
    curr_str=[]

    for i in range(len(s)):
        c=s[i]

        if c.isdigit():
            curr_num=curr_num*10+int(c)
        elif c=='[':
            strstack.append(curr_str)
            numstack.append(curr_num)

            curr_num=0
            curr_str=[]
        elif c==']':
            cnt=numstack.pop()
            parent=strstack.pop()

            for i in range(cnt):
                parent.extend(curr_str)
            curr_str=parent
        else:
            curr_str.append(c)
    return "".join(curr_str)
