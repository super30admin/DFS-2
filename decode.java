class Solution {
    public String decodeString(String s) {
        Stack<Integer>nst=new Stack<>();
        Stack<String>strst=new Stack<>();
        int k=0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                k=(k*10)+(c-'0');
                continue;
            }
            if(c=='['){
                nst.push(k);
                k=0;
                strst.push(String.valueOf(c));
                continue;
            }
            if(c!=']'){
                strst.push(String.valueOf(c));
                continue;
            }
            StringBuilder temp=new StringBuilder();
            int count=nst.pop();
            while(!strst.peek().equals("[")){
                temp.insert(0,strst.pop());
            }
            strst.pop();
            StringBuilder replace=new StringBuilder();
            for(int i=0;i<count;i++){
                replace.append(temp);
            }
            strst.push(replace.toString());
        }
        StringBuilder result = new StringBuilder();
        while (!strst.empty()) {
            result.insert(0, strst.pop());  // reverse order
        }

        return result.toString();
    }
}