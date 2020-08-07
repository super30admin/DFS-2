/*
// Time Complexity : roughly O(n) n = length od encoded string.
// Space Complexity :O(m) m = number of encoded patterns.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// nope, but i think BFS approch might be a lil straing forward.
//will foloow the same logic though.

// Your code here along with comments explaining your approach
*/
//This is a DFs approch.
//eg :
//1.a3[c2[d]e]z
//1.we keep "a" and 3 in memory.

//2.recurse c2[d]e.
//2.we keep "c" and 2 in memory.

//3.recurse d.
//3.return "d".

//2.add it in memory with c(2*d) = "cdd"
//2.add "e" to memory = cdde
//2.return "cdde".

//1.add it in memory with "a"(3*cdde) = "acddecddecdde"
//1.add "z" to memory = "acddecddecddez"
//1.return "acddecddecddez"

class Solution {
    public String decodeString(String s) {
        //doing this because stringBuilder is faster than string.
        //in case i move decode in here will have to change
        //stringbuilders to string
        return decode(s).toString();
    }

    private StringBuilder decode(String s){

        StringBuilder ret = new StringBuilder();
        StringBuilder subret = new StringBuilder();
        int subK = 0;

        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);

            //if char add in ret.
            if(Character.isLetter(ch)){
                ret.append(ch);
            }

            //if digit get the whole number.
            else if(Character.isDigit(ch)){
                subK = subK*10+(ch - '0');
            }

            //if not letter or digit, i.e. parenthesis (or anything else).
            else{
                if(ch == '['){
                    //get strt and end index of substring(subproblem)
                    int strt = i+1;
                    Stack<Character> stk = new Stack<>();
                    stk.push('[');
                    while(!stk.isEmpty()){
                        i++;
                        if(s.charAt(i) == '[')
                            stk.push('[');
                        else if(s.charAt(i) == ']')
                            stk.pop();
                    }

                    //add decoded string to string in memory.
                    subret = decode(s.substring(strt, i));
                    for(int j = 0 ; j < subK; j++){
                        ret.append(subret);
                    }
                    //reset subK to 0 for this subproblem.
                    //since we might get other subproblem next.
                    subK = 0;
                }
            }
        }
        return ret;
    }
}
