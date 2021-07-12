class Solution {
    public String decodeString(String s) {
        Stack<Integer> st1 = new Stack<>();
        Stack<String> st2 = new Stack<>();
        String currStr = "";
        int currNum = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            //collect the number of times string needs to be repeted
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
         }
         //if [ is encountered, puss currNum and string(for the next iteration) into the stack
            else if(c == '['){
                st1.push(currNum);
                st2.push(currStr);
                currNum = 0;
                currStr = "";
            }
            //when ] is encountered, pop the num and create a string containing current string num times then add it to the string in stack
            else if(c == ']'){
                int num = st1.pop();
                StringBuilder str = new StringBuilder();
                for(int j=0; j<num; j++){
                    str.append(currStr);
                }
                currStr = st2.pop();
                currStr += str;
               //System.out.println(currStr);
            }
            else{
                currStr += c;
                
            }
        }
       return currStr; 
    } 
}