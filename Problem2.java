class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum= 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c) ){
                currNum= currNum*10 + c-'0';
            }
            else if(c =='['){
                numStack.push(currNum);
                stringStack.push(currStr);
                currNum =0;
                currStr = new StringBuilder();
            }
            else if(c==']'){
                int pCount = numStack.pop();
                StringBuilder pStr= new StringBuilder();
                for(int j=0;j<pCount;j++){
                    pStr.append(currStr);
                }
                StringBuilder parent= stringStack.pop();
                currStr= parent.append(pStr);
            }
            else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}