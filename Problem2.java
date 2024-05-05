package DFS-2;

public class Problem2 {
    int i =0;
    public String decodeString(String s) {
        int currNum=0;
        StringBuilder currStr = new StringBuilder();

        while(i<s.length()){
            char c = s.charAt(i);
             i++;
            if(Character.isDigit(c)){
                currNum = 10*currNum+c-'0';
            }else if(c=='['){   
                String innerString = decodeString(s);
                for(int j=0;j<currNum;j++){
                    currStr.append(innerString);
                }
                currNum=0;
            }else if(c==']'){
                return currStr.toString();
            }else{
                currStr.append(c);
            }
            
        }
        return currStr.toString();
    }
}
