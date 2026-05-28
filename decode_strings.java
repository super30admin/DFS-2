//time complexity O(n × k)
////space complexity O(n × k)
class Solution {
    int i=0;
    public String decodeString(String s) {
        int currnum=0;
        StringBuilder currstr = new StringBuilder();
        // if we use strings, it creates new path everytime but stringbuilder updates the same path 
        while(i<s.length()){
            char c= s.charAt(i); // char at that position 
            i++;
            if(Character.isDigit(c)) currnum=currnum*10+c-'0';
            // we are separating all numbers out 
            // char -> num ( currnum =0 initally )
            //change to currnumm =1, then 12 then 123...
            else if(c == '['){ // repeats the above process 
                String bb = decodeString(s);
                for(int k=0;k<currnum;k++){ // append the values for the reapting no. 
                    currstr.append(bb); 
                }
                currnum=0;
            }else if(c==']') return currstr.toString();
            else currstr.append(c);

        }
        return currstr.toString();
    }
}