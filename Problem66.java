TC : O(N)
SC : O(N) + O(N) = O(N)

class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        if(s == null || s.length()<1) return result.toString();
        
        Stack<Integer> numberStk = new Stack<>();
        Stack<StringBuilder> stringStk = new Stack<>();
        int i = 0;
        int num =0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + c-'0';
            }else if(s.charAt(i) == '['){
                numberStk.push(num);
                stringStk.push(result);
                num = 0;
                result = new StringBuilder();
            }else if(s.charAt(i) == ']'){
                int times = numberStk.pop();
                StringBuilder str = new StringBuilder();
                for(int j =0; j<times; j++){
                    str.append(result);
                }
                result = stringStk.pop().append(str);
            }else{
                result.append(c);
            }
            i++;
        }
        return result.toString();
    }
}