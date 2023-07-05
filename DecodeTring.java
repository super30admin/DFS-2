class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder str = new StringBuilder();

        int n = s.length();
        int i = 0;

        while (i < n) {
            char c = s.charAt(i);

            if (c != ']') {
                str.append(c);
            }

            else {
                String st = "";

                while (str.length() > 0 && str.charAt(str.length() - 1) != '[') {
                    st = str.charAt(str.length() - 1) + st;
                    str.deleteCharAt(str.length() - 1);
                }

                str.deleteCharAt(str.length() - 1);
                int j = 0;
                double num = 0;
                while (str.length() > 0 && Character.isDigit(str.charAt(str.length() - 1))) {
                    num = Character.getNumericValue(str.charAt(str.length() - 1)) * Math.pow(10, j) + num;
                    str.deleteCharAt(str.length() - 1);
                    j++;
                }
                int number = (int) num;
                str.append(st.repeat(number));
            }

            i++;
        }

        return str.toString();
    }
}