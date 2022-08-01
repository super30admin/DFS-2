// tc: o(n)
// sc: depends on the depth of nesting


class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        // stringbuilder to store characters
        int num = 0;
        StringBuilder currstr = new StringBuilder();
        // two stacks for storing numbers and characters
        // when we encouter "[" then add number and currstring from stringbulder into two stack
        Stack<StringBuilder> strStack = new Stack();
        Stack<Integer> numStack = new Stack();
        // logic

        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);
            // 4 cases
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            else if(c == '['){
                numStack.push(num);
                strStack.push(currstr);
                currstr = new StringBuilder();
                num = 0;
            }
            else if(c == ']'){
                int multiply = numStack.pop();
                StringBuilder newString = new StringBuilder();
                for(int j = 0; j < multiply; j++){
                    newString.append(currstr);
                }
                currstr = strStack.pop().append(newString);


            }
            else{
                currstr.append(c);
            }
        }

        return currstr.toString();


    }
}





// using recursion second approach

class Solution {
    int i;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        // stringbuilder to store characters
        int num = 0;
        StringBuilder currstr = new StringBuilder();
        while(i<s.length()){

            char c = s.charAt(i);
            // 4 cases
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
                i++;
            }
            else if(c == '['){
                i++;
                // recursive call means pushing element into the stack
                String decoded = decodeString(s);
                StringBuilder  newstring = new StringBuilder();
                for(int j = 0; j< num; j++ ){
                    newstring.append(decoded);
                }
                currstr.append(newstring);
                num = 0;



            }
            else if(c == ']'){
                i++;
                return currstr.toString();

            }
            else{
                currstr.append(c);
                i++;// next element






            }
        }

        return currstr.toString();


    }
}


















