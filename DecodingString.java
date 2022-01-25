// tc => length of deciphered string
// sc =>
public class DecodingString {
    public String decodeString(String s) {
        StringBuilder curr = new StringBuilder();
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        int number = 0;
        for(int i = 0; i < s.length(); i++) {
            // digit
            char currIndexVal = s.charAt(i);
            if(Character.isDigit(currIndexVal)) {
                number = (number * 10) + currIndexVal - '0';
            } else if(currIndexVal == '[') {
                strSt.push(curr);
                numSt.push(number);
                curr = new StringBuilder();
                number = 0;
            } else if(currIndexVal == ']') {
                int nu = numSt.pop();
                StringBuilder parent = strSt.pop();
                StringBuilder baby = new StringBuilder();
                for(int l=0; l<nu; l++) {
                    baby.append(curr);
                }
                curr = parent.append(baby);
            } else {
                curr.append(currIndexVal);
            }


        }
        return curr.toString();
    }
}
