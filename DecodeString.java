//O(N)
//O(N)

class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0){
            return " ";
        }

        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int num = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c -'0';
                //System.out.println(num);
            }
            else if(c == '['){
                strStack.push(current);
                numStack.push(num);
                current = new StringBuilder();
                num = 0;
            }
            else if(c == ']'){
                int times = numStack.pop();
               // System.out.println(times);
                StringBuilder newStr = new StringBuilder();
               // System.out.println("newStr"+newStr);

                for(int j=0; j<times; j++){
                    newStr.append(current);
                    //System.out.println("newStr"+newStr);
                }
                current = (strStack.pop()).append(newStr);
                //System.out.println(current);
            }
            else{
                current.append(c);
            }
            //System.out.println(current);
        }

        return current.toString();
        
    }
}