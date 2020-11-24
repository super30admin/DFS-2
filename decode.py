# A siimple way to solve this problem is using a list like a stack, first I get the multiplier and then if I encounter opening bracket, then whatever follows the [ is appended to last element of stack, also, multiplier before that is stord as second element.
# then multiplier is reset, now when ] is encountered, element is popped and then multipled by multiplier else, the character is appended to existing string
# Time Complexity: O(n)
#Space complexity: O(number+num of elements in stack)
def decodeString(s):
    st = [["",1]]
    multiplier = ""
    number = ["0","1","2","3","4","5","6","7","8","9"]
    for ch in s:
        if ch in number:
            multiplier = multiplier + ch
        elif ch == "[":
            st.append(["",int(multiplier)])
            multiplier = ""
        elif ch == "]":
            elem = st.pop()
            st[-1][0] = st[-1][0] + (elem[0]*elem[1])
        else:
            st[-1][0] = st[-1][0] + ch
    return st[0][0]

s = "3[a]2[bc]"
l = decodeString(s)
print(l)



