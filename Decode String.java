class Solution {
    public String decodeString(String s) {
        Stack<Integer> cStack = new Stack<>();
        Stack<StringBuilder> sStack = new Stack<>();

        StringBuilder cString = new StringBuilder();
        int cNumber = 0;


        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                cNumber = cNumber * 10 + (c - '0');
            }
            else if(c == '['){
                cStack.push(cNumber);
                sStack.push(cString);

                cString = new StringBuilder();
                cNumber = 0;
            }
            else if(c == ']'){
                int rCount = cStack.pop();
                StringBuilder pString = sStack.pop();

                for(int i = 0; i<rCount; i++){
                    pString.append(cString);
                }
                cString = pString;
            }
            else{
                cString.append(c);
            }
        }

        return cString.toString();
    }
}
// Time Complexity: O(N) -> Each character in the string is processed once.
// Space Complexity: O(N) -> Stack stores characters or substrings during recursion or iteration.
