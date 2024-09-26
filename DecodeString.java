/*
Time Complexity: O(n) where n is the length of the string
Space Complexity: O(n) : stack size. worse case when we have close bracket at the end we would be inserting all the chars in the stack
*/
class Solution {
    public String decodeString(String s) {
        //edge case
       if(s==null || s.length() ==0)
           return s;
        Stack<Character> st= new Stack<>();
        
        //iterate over the string
        for(int i=0; i< s.length(); i++){
            char c= s.charAt(i);
            //push everything in stack till we find "]"
            if(c != ']')
                st.push(c);
            else{
                
                StringBuilder sb = new StringBuilder();
                //get string to make from the stack, i.e. string between [ and ]
                while(!st.isEmpty() &&  Character.isLetter(st.peek()))
                    sb.insert(0, st.pop());
                String stringToMake = sb.toString();
                
                //remove "["
                st.pop();
                
                //get count from the stack which we have stored in the past which was before "["
                sb = new StringBuilder();
                while(!st.isEmpty() &&  Character.isDigit(st.peek()))
                    sb.insert(0, st.pop());
                int cnt = Integer.parseInt(sb.toString());
                
                //repeate the string cnt times.  
                sb = new StringBuilder();
                for(int j=0; j<cnt ; j++)
                   sb.append(stringToMake);
                
                //again insert in the stack
                for(char newc: sb.toString().toCharArray())
                    st.push(newc);
            }
        }
        StringBuilder finalString = new StringBuilder();
        for(char c: st)
            finalString.append(c);
        return finalString.toString();
    }
}
