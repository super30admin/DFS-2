import java.util.Stack;

/*
Decode a String
approach: do a dfs when we encounter a open bracket.
time: O(length of output string)
space: O(number of open brackets)
 */
public class Problem2 {
    static int index = 0;
    public static String decodeString(String s) {
        StringBuilder res = helper(s, new StringBuilder(), 0);
        return res.toString();
    }

    private static StringBuilder helper(String s, StringBuilder cs, int cn) {
        if(index>=s.length()) return cs;
        char curr = s.charAt(index++);
        if(Character.isDigit(curr)) {
            cn = cn*10+curr-'0';
        }
        else if(curr=='[') {
            StringBuilder res = helper(s,  new StringBuilder(), 0);
            int num = cn;

            while(num-->0) {
                cs.append(res);
            }
            cn = 0;
        }
        else if(curr==']') {
            return cs;
        }
        else {
            cs = cs.append(curr);
        }

        return helper(s,  cs, cn);
    }

    public static void main(String []args) {
        decodeString("3[a]2[bc]");
    }
}
