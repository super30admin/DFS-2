//https://leetcode.com/problems/decode-string
//TC O(n)
//SC O(n)

class Solution {
    public String decodeString(String s) {
        Stack<Integer> intstack = new Stack<>();
        Stack<String> stack = new Stack<>();
        int number=0;
        String str = "";
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                number = number * 10 + Character.getNumericValue(c);
            }else if(c == '['){
                intstack.push(number);
                stack.push(str);
                number = 0; str = "";
            }else if(c == ']'){
                StringBuilder sb = new StringBuilder();
                int num = intstack.pop();
                while(num>0){
                    sb.append(str);
                    num--;
                }
                str = stack.pop();
                str += sb;
            }else{
                str += c;
            }
        }
        return str;
    }
}
