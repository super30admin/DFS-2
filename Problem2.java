//time o(maxK n)
//space o(m+n)

class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int k=0;
        StringBuilder currentString = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                k = k*10 + (c - '0');
            } else if(c == '[') {
                countStack.push(k);
                k=0;
                stringStack.push(currentString);
                currentString = new StringBuilder();
            } else if(c == ']') {
                StringBuilder decodedString = new StringBuilder(stringStack.pop());
                int count = countStack.pop();
                for(int i=1;i<=count; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(c);
            }
        }
        return currentString.toString();
    }
}
