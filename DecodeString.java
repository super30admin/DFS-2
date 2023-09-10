
//-- Here we have 4 scinarios:
//if its number then currno is the number
//if we have string then make curr string
//if we have opening bracket add the curr no and curr st in stack and rest to original
//if closing take sting repeat the no of times wth no stack and combine with parent.//


class DecodeString{
    public String decodeString(String s){
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder currStr =  new StringBuilder();
        int currNo = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNo = currNo * 10 + c -'0'; //ASCII value conversion coz we need convert from char to int. To support 10,100 we need *10
            }else if(c == '['){
                strSt.push(currStr);
                numSt.push(currNo);
                currStr = new StringBuilder();
                currNo = 0;
            }else if(c == ']'){
                int count = numSt.pop();
                StringBuilder child = new StringBuilder();
                for(int k = 0; k<count; k++){ // Repetation number of times.
                    child.append(currStr);
                }
                //combine with parent
                StringBuilder parent = strSt.pop();
                currStr = parent.append(child);
            }else{
                currStr.append(c);
            }

        }
return currStr.toString();
    }
}