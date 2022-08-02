//TC - O(n);
//SC - O(n);
class Solution {
    public String decodeString(String s) {
        Stack<Integer> intS = new Stack<>();
        Stack<String> stS = new Stack<>();
        int currNum=0;
        String currSt = "";
        //String res="";
        
        for(int i=0; i<s.length();i++){
            char ch =s.charAt(i);
            if(Character.isDigit(ch)){
                currNum = currNum*10 + ch - '0';
            }
            else if(ch == '['){
                intS.push(currNum);
                currNum=0;
                stS.push(currSt);
                currSt="";
            }
            else if(ch == ']') {
                String prev = stS.pop();
                int times = intS.pop();
                
                String temp="";
                temp = temp+prev;
                public class decodeString {
                    
                }
                
                for(int j=0;j<times;j++){
                    temp+= currSt;
                }
                currSt = temp;
            }
            else{
                currSt+=ch;
            }
        }
        
        return currSt;
    }
}

