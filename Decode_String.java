// Time Complexity -> O(n)
// Space Complexity -> O(n)
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        int num = 0;
        StringBuilder currString = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }else if(c == '['){
                numSt.push(num);
                strSt.push(currString);
                num = 0;
                currString = new StringBuilder();
            }else if(c == ']'){
                int cnt = numSt.pop();
                StringBuilder decodedStr = new StringBuilder();
                for(int k = 0; k < cnt; k++){
                    decodedStr.append(currString);
                }
                currString = strSt.pop().append(decodedStr);
            }else{
                currString.append(c);
            }n
        }
        return currString.toString();
    }
}
