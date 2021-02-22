class Solution {
    public String decodeString(String s) {
    Stack<Integer> stackInt = new Stack<>();
    Stack<String> stackChar = new Stack<>();
    int currInt = 0;
    String currStr = "";
    
    for(char c: s.toCharArray()){
        if(Character.isDigit(c)){
            currInt = currInt * 10 + (c - '0');
        }
        else if(c == '['){
            stackInt.add(currInt);
            stackChar.add(currStr);
            currInt = 0;
            currStr = "";
        }
        else if(c == ']'){
            String temp = "";
            int value = stackInt.pop();
            for(int x=0;x<value;x++){
                temp = temp + currStr;
            }
            currStr = stackChar.pop();
            currStr = currStr + temp;
        }
        else{
            currStr = currStr + c;
        }
    }
        return currStr;
    }
}
