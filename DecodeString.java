/* TC, SC O(N), O(N)*/

class Solution {
    //in globalscope, so we dont need to use substring
    int i ;
    public String decodeString(String s) {
        // DFS recursive way
        if (s.length() == 0 || s == null ) return s;

        int num = 0 ;
        StringBuilder currString = new StringBuilder();
        while(i < s.length()){
            char c = s.charAt(i);
            if (Character.isDigit(c)){

                num = num * 10 + c-'0';
                 i++;

            } else if (c == '['){

                i++;
		// move to its child
                String child = decodeString(s);
                 StringBuilder newString = new StringBuilder();
                for (int k = 0 ; k < num; k++){
                    newString.append(child);
                }

                currString.append(newString);
                num = 0 ;

            } else if (c == ']'){
                 i++;
                return currString.toString();


            } else {
                //character
                currString.append(c);
                i++;
            }



        }
        return currString.toString();


    }
}
