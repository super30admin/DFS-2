
// TC :
// SC :

package S30_Codes.DFS_2;

class DecodeString {
    int i;
    String s;

    public String decodeString(String s) {
        this.i = 0;
        this.s = s;

        return decodeString().toString();
    }

    private StringBuilder decodeString(){
        int curFreq = 0;
        StringBuilder curStr = new StringBuilder("");

        while(i<s.length()){
            char c = s.charAt(i);
            i++;

            if(Character.isDigit(c)){
                curFreq = curFreq * 10 + Character.getNumericValue(c);
            }
            else if(c == '['){
                StringBuilder newStr = decodeString();
                curStr.append( multiplyString(curFreq, newStr) );
                curFreq = 0;
            }
            else if(c == ']'){
                return curStr;
            }
            else{
                curStr.append(c);
            }
        }

        return curStr;
    }

    private StringBuilder multiplyString(int freq, StringBuilder str){
        StringBuilder newStr = new StringBuilder("");

        while(freq > 0){
            newStr.append(str);
            freq--;
        }

        return newStr;
    }
}