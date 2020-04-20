// Time Complexity - O(L) L = Length of output string
// Space Complexity - O(L) L = Length of output string)

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                int num = s.charAt(i)-'0';

                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + (s.charAt(i+1)-'0');
                    i++;
                }
                numStack.push(num);
            }else if(s.charAt(i) == '['){
                strStack.push(sb.toString());
                sb = new StringBuilder();
            }else if(s.charAt(i) == ']'){
                int times = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                while(times>0){
                    temp.append(sb);
                    times--;
                }
                sb = temp;
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}