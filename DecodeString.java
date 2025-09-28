//TC: O(n * k), SC, O(n * k)
public class DecodeString {

    private int i;
    public String decodeString(String s) {

        int num = 0;
        StringBuilder current = new StringBuilder();

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
                i++;
            } else if (ch == '[') {
                i++;
                String decoded = decodeString(s);
                for (int k = 0; k < num; k++) current.append(decoded);
                num = 0;
            } else if (ch == ']') {
                i++;
                return current.toString();
            } else {
                current.append(ch);
                i++;
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {
        final DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("3[a2[c]]")); //accaccacc
        System.out.println(decodeString.decodeString("2[abc]3[cd]ef")); //abcabccdcdcdef
    }
}
