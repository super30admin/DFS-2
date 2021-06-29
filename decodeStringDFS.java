// Time Complexity: not sure how to define in Big-Oh notation. Please help.
//Space Complexity: O(depth) where depth is equivalent to the amount of nested strings given

class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        int num = 0;
        StringBuilder curr = new StringBuilder();
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            } else if(c == '['){
                numSt.push(num);
                strSt.push(curr);
                num = 0; curr = new StringBuilder();
            } else if(c == ']'){
                int times = numSt.pop();
                StringBuilder child = new StringBuilder();
                for(int j=0; j < times; j++){
                    child.append(curr);
                }
                StringBuilder parent = strSt.pop();
                curr = parent.append(child);
            } else{
                curr.append(c);
            }
        }
        return curr.toString();
    }
}