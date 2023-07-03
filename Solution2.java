class Solution2 {
    public String decodeString(String s) {
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();
        // strSt.push(currStr);
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if( Character.isDigit(c) ) {
                currNum = currNum *10 + c-'0';
            } else if( c == '[') {
                numSt.push(currNum);
                strSt.push(currStr);
                currStr = new StringBuilder();
                currNum = 0;
            } else if( c == ']') {
                int cnt = numSt.pop();
                StringBuilder child = new StringBuilder();
                for(int j = 0; j < cnt; j++) {
                    child.append(currStr);
                }
                StringBuilder temp = strSt.pop();
                currStr = temp.append(child);
                // strSt.push(temp);
            }
            else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}