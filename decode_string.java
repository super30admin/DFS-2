class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strStack =new Stack<>();
        Stack<Integer> numStack =new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum=0;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum*10+c-'0';
            }
            else if(c=='['){
                numStack.push(currNum);
                strStack.push(currStr);
                currNum= 0;
                currStr= new StringBuilder();

            }else if(c==']'){
                StringBuilder newStr = new StringBuilder();
                int times = numStack.pop();
                for(int j=0;j<times;j++){
                    newStr.append(currStr);

                }
                currStr=newStr;
                currStr= strStack.pop().append(currStr);

            }else{
                currStr.append(c);
            }


        }
        return currStr.toString();
    }

}