//solved successfully on leetcode and faced no issues
//TC: O(n*k)
//SC: O(n*k)

class Solution {
    public String decodeString(String s) {
        Stack<Integer>numstack = new Stack<>();  //numstack
        Stack<String>stringstack = new Stack<>(); //stringstack
        int currentnum = 0;
        StringBuilder currentstring = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                currentnum = currentnum * 10 + (ch - '0');
            }
            else if( ch == '['){
                numstack.push(currentnum);
                stringstack.push(currentstring.toString());
                //reset
                currentnum = 0;
                currentstring = new StringBuilder();
            }
            else if(ch == ']'){
                int repeat = numstack.pop();
                StringBuilder decoded = new StringBuilder(stringstack.pop());
                for(int i = 0 ; i < repeat ; i++){
                    decoded.append(currentstring);
                }
                currentstring = decoded;
            }
            else{
                currentstring.append(ch);
            }
        }
        return currentstring.toString();
        
    }
}