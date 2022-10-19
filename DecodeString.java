class Solution {
		// Using Two Stacks
    public String decodeString(String s) {
        
        if (s == null || s.length() == 0) return s;
        
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        
        for (int i=0; i<s.length(); i++) {
            
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');                
            } else if (c == '[') {
                strStack.push(currStr);
                numStack.push(num);
                num = 0;
                currStr = new StringBuilder();
            } else if (c == ']') {
                int times = numStack.pop();
                StringBuilder sb = new StringBuilder();
                for (int j=0; j<times; j++) {
                    sb.append(currStr);
                }
                currStr = strStack.pop().append(sb);
            } else {
                currStr.append(c);
            }
        }
        
        return currStr.toString();
    }
}


class Solution {
    int i;
    public String decodeString(String s) {
        // Using Recursion       
        if (s == null || s.length() == 0) return s;
        
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        
        while (i < s.length()) {
            
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                i++;
            } else if (c == '[') {
                i++;
                String decode = decodeString(s);
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<num; j++) {
                    sb.append(decode);
                }
                currStr.append(sb.toString());
                num = 0;
            } else if (c == ']') {
                i++;
                return currStr.toString();
            } else {
                currStr.append(c);
                i++;
            }
        }
        
        return currStr.toString();
    }
}
