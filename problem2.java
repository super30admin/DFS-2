import java.util.Stack;

class decodeString{
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;

        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder str = new StringBuilder();

        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(Character.isDigit(curr)){
                num = num * 10 + (curr - '0');
            }
            else if(curr == '['){
                numStack.push(num);
                strStack.push(str);
                num = 0;
                str = new StringBuilder();
            }
            else if(curr == ']'){
                int times = numStack.pop();
                StringBuilder newstr = new StringBuilder();
                for(int j = 0; j < times; j++){
                    newstr.append(str);
                }
                str = strStack.pop().append(newstr);
            }
            else{
                str.append(curr);
            }
        }
        return str.toString();
    }
}

// time complexity O(n)
//space complexity O(number of open bracket) or length of output string