class Solution {
    public String decodeString(String s) {
       if(s == null || s.length() == 0) return s;
        int num = 0;
        StringBuilder curStr = new StringBuilder();
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> charc = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){ //case 1
                num = num * 10 + c - '0';
            }else if(c == '['){ // case 2
                nums.add(num);
                charc.add(curStr);
                num = 0;
                curStr = new StringBuilder();
            }else if (c == ']'){ // case 3
                int times = nums.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j < times; j++){
                    newStr = newStr.append(curStr);
                }
                curStr = charc.pop().append(newStr);
            }else{ // case 4
                curStr = curStr.append(c);
            }
        }
        // as the return type is string 
        return curStr.toString();
    }
}
