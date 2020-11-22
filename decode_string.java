//time complexity: O(N) length of given string
//space complexity: O(N) length of given string
//Ran on leet code and accepted 
class Solution {
   
    private int pos = 0;
    public String decodeString(String s)
    {
        StringBuilder sb = new StringBuilder();
        String num = "";
        for(int i = pos; i<s.length();i++)
        {
            //appending the alphabets to stringbuilder 
            if(s.charAt(i) !='[' && s.charAt(i)!=']' && !Character.isDigit(s.charAt(i)))
            {
                sb.append(s.charAt(i));
            } 
            //appending all the numerical values to num string
            else if((Character.isDigit(s.charAt(i))))
            {
                num+=s.charAt(i);
            } 
            //If it is open square bracket  
            else if (s.charAt(i) == '[')
            {
                //increment to next pos
                pos = i+1;
                //Iteratively calling decodeString for next pos
                String next = decodeString(s);
                //appending char to sb num times till n is 0  
                for (int n = Integer.valueOf(num); n>0;n--) sb.append(next);
                //make num null
                num = "";
                //make i value equal to current pos which is incremented by 1
                i = pos;
            }
            //If the encounters close square bracket make pos 
            else if (s.charAt(i) == ']') {
                //value of pos as i 
                pos = i; 
                //return the sb string
                return sb.toString();
            }
        }
      //return the whole string
      return sb.toString();  
}
}