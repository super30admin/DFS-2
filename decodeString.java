class Solution {
    String decodeString(String s) {
        Stack<Integer> countSt = new Stack<>();
        Stack<StringBuilder> stringSt = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                countSt.push(k);
                stringSt.push(curr);
                curr = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decodedString = stringSt.pop();
                for (int currentK = countSt.pop(); currentK > 0; currentK--) {
                    decodedString.append(curr);
                }
                curr = decodedString;
            } else {
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}

//Time Complexity:  O(maxK * n)
//Space Complexity: O(m+n)