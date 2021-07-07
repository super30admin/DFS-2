class DecodeString{
    // Time - K*N : K- max number & N:largest str
    // Space -
    // Depth - number of opening brackets
    public String decodeString(String s) {
        if(s == null || s.length() ==0) return null;
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int num = 0;
        StringBuilder curStr = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            } else if(c == '['){
                numStack.add(num);
                strStack.add(curStr);
                num =0;
                curStr = new StringBuilder();
            } else if(c == ']'){
                //evaluate child
                StringBuilder newStr = new StringBuilder();
                int times = numStack.pop();
                for(int k=0; k<times; k++){
                    newStr.append(curStr);
                }
                //append child to parent and update curStr
                StringBuilder parent = strStack.pop();
                curStr = parent.append(newStr);

            } else {
                curStr.append(c);
            }
        }
        return curStr.toString();
    }
}