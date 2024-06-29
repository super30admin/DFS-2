class Solution {
    int i;
    public String decodeString(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int num = 0;
        StringBuilder curr = new StringBuilder();
            while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');

            }
            else if(c == '['){
                numStack.push(num);
                strStack.push(curr);
                num = 0;
                curr = new StringBuilder();

            }
            else if(c == ']'){
                int time = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int i = 0; i < time; i++){
                    newStr.append(curr);

                }
                
                curr = strStack.pop().append(newStr);
            }
            else{
                curr.append(c);

            }
            i++;
        }

        return curr.toString();
    }
}