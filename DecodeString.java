class DecodeString {
    public String decodeString(String s) {
        Stack<StringBuilder> charStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
         int currNum=0;
         StringBuilder currString = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                currNum = currNum*10 + c-'0';
            }
            else if(c == '['){
                intStack.push(currNum);
                charStack.push(currString);
                currNum = 0;
                currString = new StringBuilder();
            }
            else if(c == ']'){
                StringBuilder baby = new StringBuilder();
                int num = intStack.pop();
                for(int j=0; j<num; j++){
                    baby.append(currString);
                }
                StringBuilder parent = charStack.pop();
                parent.append(baby);
                currString = parent;
            }
            else
                currString.append(c);
        }
        return currString.toString();
    }
}