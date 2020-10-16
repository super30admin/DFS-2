def decodestring(s):
  currentstring = ''
  currentnum = 0
  stack =[]
  for c in s:      #traverse the string
    if c.isalpha():  #if the char is alphabet append to currentstring
      currentstring+=c             
    if c.isdigit():
      currentnum = 10*currentnum + int(c)  # because string could have more than 1 digit continuously. 
    if c is '[':
      stack.append(currentstring)
      stack.append(currentnum)
      currentstring = ''
      currentnum = 0
    elif c is ']':
      num = stack.pop()
      prev = stack.pop()
      currentstring = prev +num*currentstring
  return currentstring
  
  # tc and sc is o(n), string could have input from 0-9, a-z,A-Z,[,] . when encounter [, append currentstring and currentnum because while popping we need reverse.
  
