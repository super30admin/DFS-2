# tc O(maxcount * n), sc O(n).
stack = []
string = []
count = 0

for c in s:
    if c == "[":
        stack.append(string)
        stack.append(count)
        string = []
        count = 0
    elif c == "]":
        currcount = stack.pop()
        prevstring = stack.pop()
        string = prevstring + (currcount*string)
    elif c.isdigit():
        count = count*10 + int(c)
    else:
        string.append(c)

return "".join(string)