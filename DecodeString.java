class DecodeString {
    public String decodeString(String s) {
        if(s == null || s.length() == 0 || s.length() == 1){
            return s;
        }

        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder outputStr = new StringBuilder();
        int currNum = 0;

        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(Character.isDigit(curr)){
                int digit = curr - '0';
                currNum = currNum * 10 + digit;
            } else if (curr == '['){
                numStack.push(currNum);
                strStack.push(outputStr);
                currNum=0;
                outputStr = new StringBuilder();
            } else if (curr == ']'){
                StringBuilder str = strStack.pop();
                StringBuilder newStr = new StringBuilder();
                int num = numStack.pop();
                while(num>0){
                    num--;
                    newStr.append(outputStr);
                }
                outputStr = str.append(newStr);
            } else {
                outputStr.append(curr);
            }
        }
        return outputStr.toString();

    }
}
