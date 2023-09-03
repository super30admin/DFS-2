// Time Complexity : O(n) where n is length of the output
// Space Complexity :O(n) where n is length of the output
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Using BFS
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack();
        Stack<StringBuilder> strSt = new Stack(); //imutable

        int currNum =0;
        StringBuilder currStr = new StringBuilder();

        for (int i =0 ; i<s.length();i++){
            char c =s.charAt(i);
            if(Character.isDigit(c)){
                currNum= currNum*10 + c -'0';
            }else if(c=='['){
                strSt.push(currStr);
                numSt.push(currNum);
                currStr = new StringBuilder();
                currNum=0;
            }else if(c==']'){
                int cnt = numSt.pop();
                StringBuilder child = new StringBuilder();
                for ( int k =0 ; k< cnt ; k++){
                    child.append(currStr);
                }
                StringBuilder parent = strSt.pop();
                currStr  = parent.append(child);
            }
            else{
                currStr.append(c);
            }
        }

    return currStr.toString();
        
    }
}

// Time Complexity : O(n) where n is length of the output
// Space Complexity :O(n) where n is length of the output
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


//Using DFS
class Solution {
    int i;
    public String decodeString(String s) {
        StringBuilder currStr = new StringBuilder(); //imutable

        int currNum =0;

        while(i<s.length()){//tc: length of the string
            char c =s.charAt(i);
            if(Character.isDigit(c)){
                currNum= currNum*10 + c -'0';
                i++;
            }else if(c=='['){
                i++;
                String child = decodeString(s);
                for(int k=0;k<currNum;k++){// tc : m : no of times repeated; digits
                    currStr.append(child);
                }
                currNum=0;
                
            }else if(c==']'){
                i++;
                return currStr.toString();

            }
            else{
                currStr.append(c);
                i++;
            }
        }

    return currStr.toString();
        
    }
}