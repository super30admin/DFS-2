//Time Complexity : O(n*k) where k is the max repeat count and n is the length of the string
//Space Complexity : O(n*k)
public class DecodeString {
    Stack<StringBuilder> st;
    Stack<Integer> num;
    public String decodeString(String s) {
        st = new Stack<>();
        num = new Stack<>();
        int cnt = 0;
        StringBuilder str = new StringBuilder();


        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ']') {
                int c = num.pop();
                StringBuilder parent = st.pop();
                for(int j = 0; j < c; j++) {
                    parent.append(str);
                }

                str = parent;
                cnt = 0;
            }
            if(ch == '[') {
                st.push(str);
                num.push(cnt);
                cnt = 0;
                str = new StringBuilder();
            }
            if(Character.isDigit(ch)) {
                cnt = cnt * 10 + ch - '0';
            }
            if(ch >= 'a' && ch <= 'z') {
                str.append(ch);
            }


        }
        return str.toString();
    }
}
