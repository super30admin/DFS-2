class Solution {
    // iterative with stack 

    // public String decodeString(String s) {
    //     if(s == null || s.length() == 0) {
    //         return "";
    //     }
    //     Stack<StringBuilder> strStack = new Stack<>();
    //     Stack<Integer> numStack = new Stack<>();
    //     int num = 0;
    //     StringBuilder curr = new StringBuilder();
    //     for(int i = 0; i< s.length(); i++) {
    //         char c = s.charAt(i);
    //         if(Character.isDigit(c)) {
    //             num = num * 10 + (c - '0');
    //         } else if(c == '[') {
    //             numStack.push(num);
    //             strStack.push(curr);
    //             num = 0;
    //             curr = new StringBuilder();
    //         } else if(c == ']') {
    //             int temp = numStack.pop();
    //             StringBuilder newStr = new StringBuilder();
    //             for(int j = 0; j < temp; j++) {
    //                 newStr.append(curr);
    //             }
    //             curr = strStack.pop().append(newStr);
    //         } else {
    //             curr.append(c);
    //         }
    //     }
    //     return curr.toString();
    // }

    // recursive
    int i;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int num = 0;
        StringBuilder curr = new StringBuilder();
        while(i < s.length()) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                i++;
                num = num * 10 + (c - '0');
            } else if(c == '[') {
                i++;
                String decode = decodeString(s);
                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j < num; j++) {
                    newStr.append(decode);
                }
                curr.append(newStr);
                num = 0;
            } else if(c == ']') {
                i++;
                return curr.toString();
            } else {
                i++;
                curr.append(c);
            }
        }
        return curr.toString();
    }
}
