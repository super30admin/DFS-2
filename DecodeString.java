/*The time and space complexity of this implementation
 * is O(N) where N is length of the string*/
class DecodeString {
    private int pos;

    public String decodeString(String s) {
        pos = 0;
        return decode(s);
    }

    private String decode(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;

        while (pos < s.length()) {
            char c = s.charAt(pos);
            pos++;

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (Character.isLetter(c)) {
                sb.append(c);
            } else if (c == '[') {
                String sub = decode(s);
                for (int i = 0; i < num; i++) {
                    sb.append(sub);
                }
                num = 0;
            } else if (c == ']') {
                return sb.toString();
            }
        }

        return sb.toString();
    }public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        String s = "3[a]2[bc]";
        String decoded = solution.decodeString(s);
        System.out.println(decoded); // prints "aaabcbc"
    }


}
