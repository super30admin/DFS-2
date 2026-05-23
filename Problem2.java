class Problem2 {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            }else if(c == '['){

                strSt.push(currStr);
                numSt.push(currNum);

                currNum = 0;
                currStr = new StringBuilder();

            }else if(c == ']'){

                int cnt = numSt.pop();
                StringBuilder parent = strSt.pop();

                for(int k=0; k<cnt; k++){
                    parent.append(currStr);
                }
            
                currStr = parent;

            }else{
                currStr.append(c);
            }
        }

        return currStr.toString();
    }
}
